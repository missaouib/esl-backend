package me.zhengjie.modules.system.domain.esl;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

import static me.zhengjie.utils.JpaRepositoryUtil.SCHEMA_NAME_2;

/**
 * 关系（Material/Storage Location/ESL）实体
 * 原数据库表：[dbo].[RelationTable]
 */
@Entity
@Getter
@Setter
@Table(name="T_Relationship", schema = SCHEMA_NAME_2)
public class T_Relationship {

    /**
     * 关系序列号,唯一不重复
     * 声明主键
     * 声明主键的生成策略
     * 原数据库字段：[dbo].[RelationTable].[id]
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 关系所在工厂（Plant），对应SoluM AIMS中的门店编号（StoreCode）
     * 原数据库无此字段
     */
    @Column(columnDefinition ="nvarchar(50)", name="storeCode")
    private String storeCode;

    /**
     * 关系所对应的物料id
     * 原数据库字段：[dbo].[RelationTable].[mid]
     */
    private Integer mid;

    /**
     * 关系所对应的库位id
     * 原数据库字段：[dbo].[RelationTable].[sid]
     */
    private Integer sid;

    /**
     * 关系所对应的ESL的id
     * 原数据库字段：[dbo].[RelationTable].[labelCode]
     */
    @Column(columnDefinition ="nvarchar(50)", name="labelCode")
    private String labelCode;

    /**
     * 关系删除与否标记
     * 原数据库字段：[dbo].[RelationTable].[flag]，但是逻辑应该未实现
     */
    private Integer flag;

    @NotNull
    private Date createDate;

    @NotNull
    private Date updateDate;
}
