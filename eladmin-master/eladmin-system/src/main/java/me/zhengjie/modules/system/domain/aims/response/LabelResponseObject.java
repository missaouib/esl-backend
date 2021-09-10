package me.zhengjie.modules.system.domain.aims.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.zhengjie.modules.system.domain.aims.request.Article;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class LabelResponseObject {
    private String stationCode;
    private String labelCode;
    private String type;
    @Setter(onMethod_ = {@JsonSetter("status")})
    @Getter(onMethod_ = {@JsonGetter("status")})
    private String labelStatus;
    private Set<Article> articleList;

}
