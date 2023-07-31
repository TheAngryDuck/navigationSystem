package com.navigation.system.navigation.service;

import com.navigation.system.navigation.dto.ReportDto;
import com.navigation.system.navigation.dto.ReportResponse;
import com.navigation.system.navigation.entity.BaseStation;
import com.navigation.system.navigation.entity.MobileStation;
import com.navigation.system.navigation.entity.Report;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ControllerHelper {
    public double calculateDistance(BaseStation base, MobileStation mobile) {

        double ac = Math.abs(Math.abs(mobile.getY()) - Math.abs(base.getY()));
        double cb = Math.abs(Math.abs(mobile.getX()) - Math.abs(base.getX()));

        return Math.hypot(ac, cb);
    }

    public ReportResponse generateResponse(long baseId, List<Report> allReports){
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
