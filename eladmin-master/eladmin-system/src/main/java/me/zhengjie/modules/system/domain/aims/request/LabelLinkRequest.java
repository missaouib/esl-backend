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
public class LabelLinkRequest implements Serializable {
    private String[] articleIdList;
    private String labelCode;
    private String templateName;
}
