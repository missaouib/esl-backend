package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.aims.request.LabelLinkRequest;
import me.zhengjie.modules.system.domain.aims.response.LabelLinkResponse;
import me.zhengjie.modules.system.domain.aims.response.LabelResponseObject;

public interface ESLLabelService {
    LabelResponseObject[] getLabelsByStationCode(String stationCode);
    LabelLinkResponse linkLabelWithArticleAndStation(String stationCode, LabelLinkRequest labelLinkRequest);
}
