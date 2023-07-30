package com.navigation.system.navigation.controller;

import com.navigation.system.navigation.dto.ReportDto;
import com.navigation.system.navigation.dto.ReportResponse;
import com.navigation.system.navigation.entity.BaseStation;
import com.navigation.system.navigation.entity.MobileStation;
import com.navigation.system.navigation.entity.Report;
import com.navigation.system.navigation.service.BaseStationService;
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

    @GetMapping("/scan")
    public ResponseEntity<Map<String,Integer>> scan(){
        Map<String,Integer> reportCounts = new HashMap<String, Integer>() {
        };
        List<BaseStation> baseStations = baseStationService.getAllBaseStations();
        List<MobileStation> mobileStations = mobileStationService.getAllMobileStations();

        for (BaseStation base:baseStations) {
            int count = 0;
            for (MobileStation mobile:mobileStations) {
                float distance = (float)calculateDistance(base,mobile);
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
    }
    @GetMapping("/reports")
    public ResponseEntity<List<ReportResponse>> getReports(){
        List<BaseStation> baseStations = baseStationService.getAllBaseStations();
        List<Report> allReports = reportService.getAllReports();
        List<ReportResponse> response = new ArrayList<>();
        for (BaseStation base: baseStations) {
            response.add(generateResponse(base.getId(),allReports));
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/location")
    public ResponseEntity<Optional<MobileStation>> getMobileStationById(@RequestParam long id){

        return ResponseEntity.ok().body(mobileStationService.getMobileStationById(id));
    }

    private double calculateDistance(BaseStation base, MobileStation mobile) {

        double ac = Math.abs(Math.abs(mobile.getY()) - Math.abs(base.getY()));
        double cb = Math.abs(Math.abs(mobile.getX()) - Math.abs(base.getX()));

        return Math.hypot(ac, cb);
    }

    private ReportResponse generateResponse(long baseId, List<Report> allReports){
        ReportResponse response = new ReportResponse();
        response.baseStationId = baseId;
        response.reports = new ArrayList<>();
        for (Report report: allReports) {
            if (report.getBaseStation().getId() == baseId){
                ReportDto dto = new ReportDto(report.getMobileStation().getId(), report.getDistance(), report.getLogTime());
                response.reports.add(dto);
            }
        }
        return response;
    }
}
