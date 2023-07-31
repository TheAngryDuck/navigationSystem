package com.navigation.system.navigation.controller;

import com.navigation.system.navigation.dto.ReportResponse;
import com.navigation.system.navigation.entity.BaseStation;
import com.navigation.system.navigation.entity.MobileStation;
import com.navigation.system.navigation.entity.Report;
import com.navigation.system.navigation.service.BaseStationService;
import com.navigation.system.navigation.service.ControllerHelper;
import com.navigation.system.navigation.service.MobileStationService;
import com.navigation.system.navigation.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.*;

@RestController
public class NavigationController {

    @Autowired
    private BaseStationService baseStationService;

    @Autowired
    private MobileStationService mobileStationService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private ControllerHelper controllerHelper;

    @GetMapping("/scan")
    public ResponseEntity<Map<String,Integer>> scan(){
        Map<String,Integer> reportCounts = new HashMap<String, Integer>() {
        };
        List<BaseStation> baseStations = baseStationService.getAllBaseStations();
        List<MobileStation> mobileStations = mobileStationService.getAllMobileStations();

        if (baseStations.size() > 0 && mobileStations.size() > 0){
            for (BaseStation base:baseStations) {
                int count = 0;
                for (MobileStation mobile:mobileStations) {
                    float distance = (float)controllerHelper.calculateDistance(base,mobile);
                    if (distance <= base.getRadius()){
                        Report newReport = new Report();
                        newReport.setBaseStation(base);
                        newReport.setMobileStation(mobile);
                        newReport.setDistance(distance);
                        newReport.setLogTime(new Timestamp(System.currentTimeMillis()));
                        reportService.addReport(newReport);
                        count ++;
                    }
                }
                reportCounts.put(base.getName(), count);
            }
            return ResponseEntity.ok().body(reportCounts);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/reports")
    public ResponseEntity<List<ReportResponse>> getReports(){
        List<BaseStation> baseStations = baseStationService.getAllBaseStations();
        List<Report> allReports = reportService.getAllReports();
        if (baseStations.size() > 0 ){
            if (allReports.size() > 0){
                List<ReportResponse> response = new ArrayList<>();
                for (BaseStation base: baseStations) {
                    ReportResponse reportResponse = controllerHelper.generateResponse(base.getId(),allReports);
                    if (reportResponse.reports.size() > 0){
                        response.add(reportResponse);
                    }
                }
                return ResponseEntity.ok().body(response);
            }else{
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/location")
    public ResponseEntity<Optional<MobileStation>> getMobileStationById(@RequestParam long id){
        if (id > 0){
            Optional<MobileStation> response = mobileStationService.getMobileStationById(id);
            if (response.isPresent()){
                return ResponseEntity.ok().body(response);
            }else{
                return ResponseEntity.notFound().build();
            }
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
