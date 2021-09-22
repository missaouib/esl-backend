package me.zhengjie.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zhengjie.annotation.rest.AnonymousGetMapping;
import me.zhengjie.modules.system.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "Stations Management")
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;

    @ApiOperation("Get List of Stations")
    @AnonymousGetMapping
//    @PreAuthorize("@el.check('roles:list')")
    public ResponseEntity<Object> getAllStations(){
        return new ResponseEntity<>(stationService.getStations(), HttpStatus.OK);
    }

}
