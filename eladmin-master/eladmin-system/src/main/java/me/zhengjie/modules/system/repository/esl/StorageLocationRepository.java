package me.zhengjie.modules.system.repository.esl;

import me.zhengjie.modules.system.domain.esl.T_StorageLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StorageLocationRepository extends JpaRepository<T_StorageLocation, Long>, JpaSpecificationExecutor<T_StorageLocation> {

    /**
     * 更新节点数目
     * @param flag /
     */
    @Modifying
    @Query(value = "update dbo.storage_location set flag = ?1 where id = ?2 ",nativeQuery = true)
    void updateFlagById(Integer flag, Long id);
}
