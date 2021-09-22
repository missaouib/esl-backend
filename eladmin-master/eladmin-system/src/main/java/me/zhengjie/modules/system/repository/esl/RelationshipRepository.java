package me.zhengjie.modules.system.repository.esl;

import me.zhengjie.modules.system.domain.esl.T_DemandQuantity;
import me.zhengjie.modules.system.domain.esl.T_Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<T_Relationship, Long>, JpaSpecificationExecutor<T_Relationship> {

    /**
     * 根据 原料ID 查询
     * @param mid mid
     * @return /
     */
    @Query(value = "select * from dbo.t_relationship where mid = ?1", nativeQuery = true)
    List<T_DemandQuantity> findByMId(Long mid);

    /**
     * 根据 库位ID 查询
     * @param sid sid
     * @return /
     */
    @Query(value = "select * from dbo.t_relationship where sid = ?1", nativeQuery = true)
    List<T_DemandQuantity> findBySId(Long sid);

    /**
     * 根据 ID 查询
     * @param labelCode labelCode
     * @return /
     */
//    @Query(value = "select * from dbo.t_relationship where labelCode = ?1", nativeQuery = true)
    List<T_DemandQuantity> findByLabelCode(String labelCode);

}
