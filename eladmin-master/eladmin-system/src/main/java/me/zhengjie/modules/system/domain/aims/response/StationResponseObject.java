package me.zhengjie.modules.system.domain.aims.response;

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
public class StationResponseObject implements Serializable {
    private String code;
    private String name;
    private String zoneId;
    private StationLabelSummery summaryOfLabels;
}
