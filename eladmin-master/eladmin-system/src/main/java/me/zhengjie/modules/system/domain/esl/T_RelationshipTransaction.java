package me.zhengjie.modules.system.domain.esl;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static me.zhengjie.utils.JpaRepositoryUtil.SCHEMA_NAME_2;

/**
 * 关系操作记录实体
 * 原数据库表：[dbo].[TpTable]
 */
@Entity
@Getter
@Setter
@Table(name="T_RelationshipTransaction", schema = SCHEMA_NAME_2)
public class T_RelationshipTransaction {

    /**
     * 关系操作序列号,唯一不重复
     * 声明主键
     * 声明主键的生成策略
     * 原数据库字段：[dbo].[TpTable].[id]
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 物料所在工厂（Plant），对应SoluM AIMS中的门店编号（StoreCode）
     * 原数据库字段：[dbo].[TpTable].[storeCode]
     */
    @Column(name = "storeCode", columnDefinition ="nvarchar(20)")
    private String storeCode;

    /**
     * 操作对应的关系id
     * 原数据库字段：[dbo].[TpTable].[relationid]
     */
    @Column(name = "relationship_id")
    private Integer relationship_id;

    /**
     * 操作对应的按钮次数
     * 原数据库字段：[dbo].[TpTable].[counter]
     */
    private Integer counter;

    /**
     * 操作对应的按钮次数
     * 原数据库字段：[dbo].[TpTable].[eindex]
     * 20210625：增加说明：1为右键（负值，减少需求数量1），2为左键（正值，增加需求数量1）
     */
    private Integer eindex;

    /**
     * TODO待和Vendor确认，此字段应该是对应的ESL模板相关数据
     * 原数据库字段：[dbo].[TpTable].[promoflag]
     */
    private Integer promoflag;

    @NotNull
    private Date createDate;

    @NotNull
    private Date updateDate;
}
