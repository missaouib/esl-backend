package me.zhengjie.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zhengjie.annotation.Log;
import me.zhengjie.annotation.rest.AnonymousPostMapping;
import me.zhengjie.modules.system.domain.aims.request.LabelLinkRequest;
import me.zhengjie.modules.system.domain.aims.response.LabelResponseObject;
import me.zhengjie.modules.system.domain.aims.response.StationResponseObject;
import me.zhengjie.modules.system.service.ESLLabelService;
import me.zhengjie.modules.system.service.StationService;
import me.zhengjie.modules.system.service.dto.LabelQueryCriteria;
import me.zhengjie.utils.PageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "Labels Management")
@RequestMapping("/api/labels")
public class LabelController {

    private final ESLLabelService labelService;
    private final StationService stationService;

    @Log("查询标签信息")
    @ApiOperation("Get List of Labels by StationCode")
    @GetMapping
    @PreAuthorize("@el.check('label:list')")
    public ResponseEntity<Object> getAllLabels(LabelQueryCriteria criteria){
        log.info("");
        StationResponseObject[] stations = stationService.getStations();
        LabelResponseObject[] labels = new LabelResponseObject[0];
        for( StationResponseObject station : stations){

            int fal = labels.length;

            LabelResponseObject[] labelResponse = labelService.getLabelsByStationCode(station.getCode());
            if(labelResponse != null) {
                int sal = labelResponse.length;
                LabelResponseObject[] tempLabelArray = new LabelResponseObject[fal + sal];  //resultant array of size first array and second array
                System.arraycopy(labels, 0, tempLabelArray, 0, fal);
                System.arraycopy(labelResponse, 0, tempLabelArray, fal, sal);
                labels = tempLabelArray;
            }
        }
        return new ResponseEntity<>(PageUtil.toPage(labels, labels.length), HttpStatus.OK);
    }

    @Log("查询标签信息")
    @ApiOperation("Get List of Labels by StationCode")
    @GetMapping(value = "/{stationCode}")
    @PreAuthorize("@el.check('label:list')")
    public ResponseEntity<Object> getAllLabelsByStationCode(@PathVariable String stationCode){
        log.info("");
        return new ResponseEntity<>(labelService.getLabelsByStationCode(stationCode), HttpStatus.OK);
    }

    @Log("关联标签和显示内容")
    @ApiOperation("Link a Label with a station and articles")
    @AnonymousPostMapping(value = "/linkLabel/{stationCode}")
    //    @PreAuthorize("@el.check('roles:list')")
    public ResponseEntity<Object> linkLabel(@PathVariable String stationCode, @RequestBody LabelLinkRequest labelLinkRequest){
        return new ResponseEntity<>(labelService.linkLabelWithArticleAndStation(stationCode, labelLinkRequest), HttpStatus.OK);
    }

}
