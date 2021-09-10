package me.zhengjie.modules.system.service.impl;

import lombok.RequiredArgsConstructor;
import me.zhengjie.modules.system.domain.aims.response.StationResponseObject;
import me.zhengjie.modules.system.service.StationService;
import me.zhengjie.modules.utils.RestTemplateService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private static final String STATION_PATH = "/stations";

    private final RestTemplateService<StationResponseObject[]> restTemplateService;

    @Override
    public StationResponseObject[] getStations() {
        MultiValueMap<String, String> queryVariables = new LinkedMultiValueMap<String, String>();
        queryVariables.add("accessPoints", "false");

        ResponseEntity<StationResponseObject[]> responseEntity = this.restTemplateService.exchangeWithPathQueryVariablesGetMethod(StationResponseObject[].class, STATION_PATH, queryVariables, HttpMethod.GET);

        return responseEntity.getBody();
    }
}
