package me.zhengjie.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.rest.AnonymousGetMapping;
import me.zhengjie.annotation.rest.AnonymousPostMapping;
import me.zhengjie.modules.system.domain.aims.request.LabelLinkRequest;
import me.zhengjie.modules.system.service.ESLLabelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "Labels Management")
@RequestMapping("/api/labels")
public class LabelController {

    private final ESLLabelService labelService;

    @ApiOperation("Get List of Labels by StationCode")
    @AnonymousGetMapping
//    @PreAuthorize("@el.check('roles:list')")
    public ResponseEntity<Object> getAllLabelsByStationCode(@RequestParam String stationCode){
        return new ResponseEntity<>(labelService.getLabelsByStationCode(stationCode), HttpStatus.OK);
    }

    @ApiOperation("Link a Label with a station and articles")
    @AnonymousPostMapping(value = "/{stationCode}")
    //    @PreAuthorize("@el.check('roles:list')")
    public ResponseEntity<Object> linkLabel(@PathVariable String stationCode, @RequestBody LabelLinkRequest labelLinkRequest){
        return new ResponseEntity<>(labelService.linkLabelWithArticleAndStation(stationCode, labelLinkRequest), HttpStatus.OK);
    }

}
