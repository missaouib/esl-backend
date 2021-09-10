package me.zhengjie.modules.system.service.impl;

import lombok.RequiredArgsConstructor;
import me.zhengjie.modules.system.domain.aims.request.LabelLinkRequest;
import me.zhengjie.modules.system.domain.aims.response.LabelLinkResponse;
import me.zhengjie.modules.system.domain.aims.response.LabelResponseObject;
import me.zhengjie.modules.system.service.ESLLabelService;
import me.zhengjie.modules.utils.RestTemplateService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
@RequiredArgsConstructor
public class ESLLabelServiceImpl implements ESLLabelService {

    private static final String Label_PATH = "/labels";
    private static final String Link_PATH = "/link";

    private final RestTemplateService restTemplateService;

    @Override
    public LabelResponseObject[] getLabelsByStationCode(String stationCode) {
        MultiValueMap<String, String> queryVariables = new LinkedMultiValueMap<String, String>();
        queryVariables.add("stationCode", stationCode);

        ResponseEntity<LabelResponseObject[]> responseEntity = this.restTemplateService.exchangeWithPathQueryVariablesGetMethod(LabelResponseObject[].class, Label_PATH, queryVariables, HttpMethod.GET);

        return responseEntity.getBody();
    }

    public LabelLinkResponse linkLabelWithArticleAndStation(String stationCode, LabelLinkRequest labelLinkRequest){
        MultiValueMap<String, String> queryVariables = new LinkedMultiValueMap<String, String>();

        ResponseEntity<LabelLinkResponse> responseEntity = this.restTemplateService.exchangeWithPathQueryVariablesPostMethod(LabelLinkResponse.class, Label_PATH + Link_PATH + "/" + stationCode, queryVariables, HttpMethod.POST, labelLinkRequest);

        return responseEntity.getBody();
    }
}
