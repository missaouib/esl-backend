package me.zhengjie.modules.system.domain.aims.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class AlarmStatus implements Serializable {
    private int index;
    private boolean status;
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ssZ")
    private Date date;
    private int counter;
}
