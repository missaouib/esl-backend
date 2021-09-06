package me.zhengjie.modules.system.domain.esl;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.Date;

import static me.zhengjie.utils.JpaRepositoryUtil.SCHEMA_NAME_2;

/**
 * LSC工厂关系操作记录汇总的实体 原数据库表：[dbo].[DemandQuantity]
 **/
@Getter
@Setter
@Entity
@Table(name = "T_DemandQuantity", schema = SCHEMA_NAME_2)
public class T_DemandQuantity {


    /**
     * 汇总记录序列号,唯一不重复
     * 声明主键
     * 声明主键的生成策略
     * 原数据库字段：[dbo].[DemandQuantity].[id]
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 汇总记录对应的关系id
     * 原数据库字段：[dbo].[DemandQuantity].[relationship_id]
     */
    private Integer relationship_id;

    /**
     * 汇总记录对应的需求数量
     * 原数据库字段：[dbo].[DemandQuantity].[quantity]
     */
    private Integer quantity;

    @NotNull
    private Date createDate;

    @NotNull
    private Date updateDate;

}
