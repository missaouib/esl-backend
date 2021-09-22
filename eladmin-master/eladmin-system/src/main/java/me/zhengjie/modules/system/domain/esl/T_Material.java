package me.zhengjie.modules.system.domain.esl;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.zhengjie.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static me.zhengjie.utils.JpaRepositoryUtil.SCHEMA_NAME_2;

/**
 * 物料（Material）实体
 * 原数据库表：[dbo].[PartsTable]
 */
@Entity
@Getter
@Setter
@Table(name="T_Material", schema = SCHEMA_NAME_2)
public class T_Material extends BaseEntity implements Serializable {

    /**
     * 物料序列号,唯一不重复
     * 声明主键
     * 声明主键的生成策略
     * 原数据库字段：[dbo].[PartsTable].[id]
     */
    @Id
    @NotNull(groups = {Update.class})
    @ApiModelProperty(value = "ID", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 物料所在工厂（Plant），对应SoluM AIMS中的门店编号（StoreCode）
     * 原数据库字段：[dbo].[PartsTable].[storeCode]
     */
    @Column(name = "storeCode", columnDefinition ="nvarchar(20)")
    private String storeCode;

    /**
     * 物料编号
     * 原数据库字段：[dbo].[PartsTable].[sku]
     */

    @Column(name = "materialCode", columnDefinition ="nvarchar(50)", unique= true)
    private String materialCode;

    /**
     * 物料二维码编号
     */
    @Column(name = "materialQrcode", columnDefinition ="nvarchar(50)")
    private String materialQRCode;

    /**
     * 物料名称
     * 原数据库字段：[dbo].[PartsTable].[itemName]
     */
    @Column(name = "materialName", columnDefinition ="nvarchar(50)")
    private String materialName;

    /**
     * 物料描述
     * 原数据库无此字段
     */
    @Column(name = "materialDesc", columnDefinition ="nvarchar(100)")
    private String materialDesc;

    /**
     * 物料最小包装量(SPN)
     * 原数据库字段：[dbo].[PartsTable].[unit]
     */

    @Column(name = "materialSPN")
    private Integer materialSPN;

    /**
     * 物料最小值
     * 原数据库字段：[dbo].[PartsTable].[quantityMin]
     */
    @Column(name = "quantityMin")
    private Integer quantityMin;

    /**
     * 物料最大值
     * 原数据库字段：[dbo].[PartsTable].[quantityMax]
     */
    @Column(name = "quantityMax")
    private Integer quantityMax;

    /**
     * 物料删除与否标记
     * 原数据库无此字段
     */
    private Integer flag;

}
