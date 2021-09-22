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
 * 库位（Storage Location）实体
 * 原数据库表：[dbo].[ShelfTierTable]
 */
@Entity
@Getter
@Setter
@Table(name="T_StorageLocation", schema = SCHEMA_NAME_2)
public class T_StorageLocation extends BaseEntity implements Serializable {

    /**
     * 库位序列号,唯一不重复
     * 声明主键
     * 声明主键的生成策略
     */
    @Id
    @NotNull(groups = {Update.class})
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 库位的物理二维码编号
     */
    @Column(columnDefinition ="nvarchar(50)", name = "storageLocationQrcode")
    private String storageLocationQRCode;

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

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Timestamp updateDate;
}
