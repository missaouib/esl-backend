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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

import static me.zhengjie.utils.JpaRepositoryUtil.SCHEMA_NAME_2;

/**
 * 关系（Material/Storage Location/ESL）实体
 * 原数据库表：[dbo].[RelationTable]
 */
@Entity
@Getter
@Setter
@Table(name="T_Relationship", schema = SCHEMA_NAME_2)
public class T_Relationship extends BaseEntity implements Serializable {

    /**
     * 关系序列号,唯一不重复
     * 声明主键
     * 声明主键的生成策略
     * 原数据库字段：[dbo].[RelationTable].[id]
     */
    @Id
    @NotNull(groups = {Update.class})
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Timestamp updateDate;
}
