package me.zhengjie.modules.system.repository.esl;

import me.zhengjie.modules.system.domain.esl.T_DemandQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DemandQuantityRepository extends JpaRepository<T_DemandQuantity, Long>, JpaSpecificationExecutor<T_DemandQuantity> {

    /**
     * 根据 PID 查询
     * @param relationship_id relationship_id
     * @return /
     */
    List<T_DemandQuantity> findByRelationshipId(Long relationship_id);
}
