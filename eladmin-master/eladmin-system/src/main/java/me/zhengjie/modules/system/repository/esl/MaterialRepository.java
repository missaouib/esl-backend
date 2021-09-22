package me.zhengjie.modules.system.repository.esl;

import me.zhengjie.modules.system.domain.esl.T_Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface MaterialRepository extends JpaRepository<T_Material, Long>, JpaSpecificationExecutor<T_Material> {

    /**
     * 移除原料
     * @param id 原料ID
     */
    @Modifying
    @Query(value = "delete from dbo.t_material where id = ?1", nativeQuery = true)
    void deleteById(Long id);

    /**
     * 根据名称查询
     * @param materialName 名称
     * @return /
     */
    T_Material findByMaterialName(String materialName);

    /**
     * 根据Id删除
     * @param ids /
     */
    void deleteAllByIdIn(Set<Long> ids);

}
