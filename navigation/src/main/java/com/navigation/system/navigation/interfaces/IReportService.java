package com.navigation.system.navigation.interfaces;

import com.navigation.system.navigation.entity.Report;

import java.util.List;

public interface IReportService {

    void addReport(Report report);

    List<Report> getAllReports();

}
