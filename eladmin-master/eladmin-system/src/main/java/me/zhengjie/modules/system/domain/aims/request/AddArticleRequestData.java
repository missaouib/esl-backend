package me.zhengjie.modules.system.domain.aims.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NonNull
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class AddArticleRequestData implements Serializable {

    private Article[] dataList;

}
