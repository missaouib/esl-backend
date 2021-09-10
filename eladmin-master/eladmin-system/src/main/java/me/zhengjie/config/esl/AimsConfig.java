package me.zhengjie.config.esl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AimsConfig {
    @Value("${aims.backend.uri}")
    private String aimsBackendUri;
}
