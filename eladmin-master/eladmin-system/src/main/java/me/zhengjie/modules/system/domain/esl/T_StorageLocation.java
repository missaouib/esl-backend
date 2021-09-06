package me.zhengjie.modules.system.domain.esl;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static me.zhengjie.utils.JpaRepositoryUtil.SCHEMA_NAME_2;

/**
 * 库位（Storage Location）实体
 * 原数据库表：[dbo].[ShelfTierTable]
 */
@Entity
@Getter
@Setter
@Table(name="T_StorageLocation", schema = SCHEMA_NAME_2)
public class T_StorageLocation {

    /**
     * 库位序列号,唯一不重复
     * 声明主键
     * 声明主键的生成策略
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 库位所在工厂（Plant），地应SoluM AIMS中的门店编号（StoreCode）
     * 原数据库字段：[dbo].[ShelfTierTable].[storeCode]
     */
    @Column(name="storeCode", length = 20)
    private String storeCode;

    /**
     * 库位的物理编号
     * 原数据库字段：[dbo].[ShelfTierTable].[PhyShelftier]
     */
    @Column(columnDefinition ="nvarchar(50)", name = "storageLocation")
    private String storageLocation;

    /**
     * 库位的系统中（如ERP）编号
     * 原数据库字段：[dbo].[ShelfTierTable].[SysShelftier]
     */
    @Column(columnDefinition ="nvarchar(50)", name = "sysStorageLocation")
    private String sysStorageLocation;

    /**
     * 库位删除与否标记
     * 原数据库无此字段
     * TODO：此定义需要再商量下
     * 20210625增加：库位的Flag, 1=生产，2=仓库。暂时后续逻辑没有用到，先放着。
     */
    private Integer flag;

    @NotNull
    private Date createDate;

    @NotNull
    private Date updateDate;
}
