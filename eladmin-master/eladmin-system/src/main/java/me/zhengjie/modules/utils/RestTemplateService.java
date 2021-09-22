package me.zhengjie.modules.utils;

import lombok.RequiredArgsConstructor;
import me.zhengjie.config.esl.AimsConfig;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * this service class is used to wrapper RestTemplate Exchange Request and return the required response entity back
 *
 * @param <T>
 **/
@RequiredArgsConstructor
@Component
public class RestTemplateService<T> {

    private final RestTemplate restTemplate;

    private final AimsConfig aimsConfig;

    public ResponseEntity<T> exchangeWithPathQueryVariablesGetMethod(Class<T> responseBodyClass, String path, MultiValueMap<String, String> queryVariables, HttpMethod httpMethod) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);

        return this.exchangeWithRequestEntity(responseBodyClass, path, queryVariables, httpMethod, entity);
    }

    public ResponseEntity<T> exchangeWithPathQueryVariablesPostMethod(Class<T> responseBodyClass,
                                                                             String path,
                                                                             MultiValueMap<String, String> queryVariables,
                                                                             HttpMethod httpMethod, T requestBody) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(requestBody, headers);
        return this.exchangeWithRequestEntity(responseBodyClass, path, queryVariables, httpMethod, entity);
    }

    public ResponseEntity<T> exchangeWithPathQueryVariablesDeleteMethod(Class<T> responseBodyClass, String path, MultiValueMap<String, String> queryVariables, HttpMethod httpMethod) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);

        return this.exchangeWithRequestEntity(responseBodyClass, path, queryVariables, httpMethod, entity);
    }


    public ResponseEntity<T> exchangeWithRequestEntity(Class<T> t,
                                                           String path,
                                                           MultiValueMap<String, String> queryVariables,
                                                           HttpMethod httpMethod,
                                                           HttpEntity<?> entity){
        String callEndPoint = this.aimsConfig.getAimsBackendUri() + path;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(callEndPoint)
                .queryParams(queryVariables);
        UriComponents uriComponents = builder.build().encode();

        ResponseEntity<T> responseEntity = this.restTemplate.exchange(
                uriComponents.toUri(),
                httpMethod,
                entity,
                t
        );
        return responseEntity;
    }
}
