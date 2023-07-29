package com.navigation.system.navigation.interfaces;

import com.navigation.system.navigation.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportRepository extends JpaRepository<Report, Long> {
}
