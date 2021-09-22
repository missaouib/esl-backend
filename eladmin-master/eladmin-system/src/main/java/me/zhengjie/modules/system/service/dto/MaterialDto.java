package me.zhengjie.modules.system.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.zhengjie.base.BaseDTO;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MaterialDto  extends BaseDTO implements Serializable {


    private Long id;

    private String storeCode;

    private String materialCode;

    private String materialQRCode;

    private String materialName;

    private String materialDesc;

    private Integer materialSPN;

    private Integer quantityMin;

    private Integer quantityMax;

    private Integer flag;

    public MaterialDto(String materialName, String storeCode) {
        this.materialName = materialName;
        this.storeCode = storeCode;
    }
}
