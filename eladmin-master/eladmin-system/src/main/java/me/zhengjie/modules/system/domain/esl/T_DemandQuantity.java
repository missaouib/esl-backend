package me.zhengjie.modules.system.domain.esl;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

import static me.zhengjie.utils.JpaRepositoryUtil.SCHEMA_NAME_2;

/**
 * LSC工厂关系操作记录汇总的实体 原数据库表：[dbo].[DemandQuantity]
 **/
@Getter
@Setter
@Entity
@Table(name = "T_DemandQuantity", schema = SCHEMA_NAME_2)
public class T_DemandQuantity extends BaseEntity implements Serializable {


    /**
     * 汇总记录序列号,唯一不重复
     * 声明主键
     * 声明主键的生成策略
     * 原数据库字段：[dbo].[DemandQuantity].[id]
     */
    @Id
    @NotNull(groups = {Update.class})
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 汇总记录对应的关系id
     * 原数据库字段：[dbo].[DemandQuantity].[relationship_id]
     */
    @OneToOne
    private T_Relationship relationship;

    /**
     * 汇总记录对应的需求数量
     * 原数据库字段：[dbo].[DemandQuantity].[quantity]
     */
    private Integer quantity;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Timestamp updateDate;

}
