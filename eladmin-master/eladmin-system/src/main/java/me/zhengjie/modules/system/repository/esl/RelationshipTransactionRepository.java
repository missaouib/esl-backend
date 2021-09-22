package me.zhengjie.modules.system.repository.esl;

import me.zhengjie.modules.system.domain.esl.T_RelationshipTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RelationshipTransactionRepository extends JpaRepository<T_RelationshipTransaction, Long>, JpaSpecificationExecutor<T_RelationshipTransaction> {
}
