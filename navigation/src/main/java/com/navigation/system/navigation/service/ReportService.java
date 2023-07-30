package com.navigation.system.navigation.service;

import com.navigation.system.navigation.entity.Report;
import com.navigation.system.navigation.interfaces.IMobileStationRepository;
import com.navigation.system.navigation.interfaces.IReportRepository;
import com.navigation.system.navigation.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReportService  implements IReportService {

    @Autowired
    private IReportRepository reportRepository;

    @Override
    public void addReport(Report report) {
        reportRepository.save(report);
    }

    @Override
    public List<Report> getAllReports() {
        return this.reportRepository.findAll();
    }
}
