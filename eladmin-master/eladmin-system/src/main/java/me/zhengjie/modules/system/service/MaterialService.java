package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.esl.T_Material;
import me.zhengjie.modules.system.service.dto.MaterialDto;
import me.zhengjie.modules.system.service.dto.MaterialQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MaterialService {

    /**
     * 根据ID查询
     *
     * @param id /
     * @return /
     */
    MaterialDto findById(Long id);

    /**
     * 创建
     *
     * @param resources /
     * @return /
     */
    void create(T_Material resources);

    /**
     * 编辑
     *
     * @param resources /
     */
    void update(T_Material resources);

    /**
     * 删除
     *
     * @param ids /
     */
    void delete(Set<Long> ids);

    /**
     * 分页查询
     *
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Map<String, Object> queryAll(MaterialQueryCriteria criteria, Pageable pageable);

    /**
     * 查询全部数据
     *
     * @param criteria /
     * @return /
     */
    List<MaterialDto> queryAll(MaterialQueryCriteria criteria);

    /**
     * 导出数据
     *
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<MaterialDto> queryAll, HttpServletResponse response) throws IOException;

    /**
     * 验证是否被用户关联
     *
     * @param ids /
     */
    void verification(Set<Long> ids);
}
