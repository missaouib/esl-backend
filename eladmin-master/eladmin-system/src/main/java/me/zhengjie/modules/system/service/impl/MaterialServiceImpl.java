package me.zhengjie.modules.system.service.impl;

import lombok.RequiredArgsConstructor;
import me.zhengjie.exception.EntityExistException;
import me.zhengjie.modules.system.domain.Job;
import me.zhengjie.modules.system.domain.esl.T_Material;
import me.zhengjie.modules.system.repository.UserRepository;
import me.zhengjie.modules.system.repository.esl.MaterialRepository;
import me.zhengjie.modules.system.service.MaterialService;
import me.zhengjie.modules.system.service.dto.MaterialDto;
import me.zhengjie.modules.system.service.dto.MaterialQueryCriteria;
import me.zhengjie.modules.system.service.mapstruct.MaterialMapper;
import me.zhengjie.utils.CacheKey;
import me.zhengjie.utils.FileUtil;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import me.zhengjie.utils.RedisUtils;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "material")
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;
    private final RedisUtils redisUtils;
    private final UserRepository userRepository;

    @Override
    public Map<String,Object> queryAll(MaterialQueryCriteria criteria, Pageable pageable) {
        Page<T_Material> page = materialRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(materialMapper::toDto).getContent(),page.getTotalElements());
    }

    @Override
    public List<MaterialDto> queryAll(MaterialQueryCriteria criteria) {
        List<T_Material> list = materialRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
        return materialMapper.toDto(list);
    }

    @Override
    @Cacheable(key = "'id:' + #p0")
    public MaterialDto findById(Long id) {
        T_Material job = materialRepository.findById(id).orElseGet(T_Material::new);
        ValidationUtil.isNull(job.getId(), "Job", "id", id);
        return materialMapper.toDto(job);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(T_Material resources) {
        T_Material job = materialRepository.findByMaterialName(resources.getMaterialName());
        if(job != null){
            throw new EntityExistException(Job.class,"name",resources.getMaterialName());
        }
        materialRepository.save(resources);
    }

    @Override
    @CacheEvict(key = "'id:' + #p0.id")
    @Transactional(rollbackFor = Exception.class)
    public void update(T_Material resources) {
        T_Material material = materialRepository.findById(resources.getId()).orElseGet(T_Material::new);
        T_Material old = materialRepository.findByMaterialName(resources.getMaterialName());
        if(old != null && !old.getId().equals(resources.getId())){
            throw new EntityExistException(Job.class,"name",resources.getMaterialName());
        }
        ValidationUtil.isNull( material.getId(),"Material","id",resources.getId());
        resources.setId(material.getId());
        materialRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        materialRepository.deleteAllByIdIn(ids);
        // 删除缓存
        redisUtils.delByKeys(CacheKey.JOB_ID, ids);
    }

    @Override
    public void download(List<MaterialDto> materialDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (MaterialDto materialDto : materialDtos) {
            Map<String,Object> map = new LinkedHashMap<>();

            map.put("仓库标识", materialDto.getStoreCode());
            map.put("原材料标识", materialDto.getStoreCode());
            map.put("原材料二维码标识", materialDto.getMaterialQRCode());
            map.put("原材料名字", materialDto.getMaterialName());
            map.put("最小数量", materialDto.getQuantityMin());
            map.put("最大数量",  materialDto.getQuantityMax());
            map.put("创建日期", materialDto.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public void verification(Set<Long> ids) {
//        if(userRepository.countByJobs(ids) > 0){
//            throw new BadRequestException("所选的岗位中存在用户关联，请解除关联再试！");
//        }
    }
}
