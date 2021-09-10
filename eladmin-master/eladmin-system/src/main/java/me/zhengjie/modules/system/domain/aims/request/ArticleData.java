package me.zhengjie.modules.system.domain.aims.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class ArticleData implements Serializable {

    private String material_code;
    private String material_qrcode;
    private String material_desc;
    private String quantity_min;
    private String quantity_max;
    private String materialspn;
    private String storage_location;
    private String storage_location_qrcode;

}
