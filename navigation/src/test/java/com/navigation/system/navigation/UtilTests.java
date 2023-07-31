package com.navigation.system.navigation;

import com.navigation.system.navigation.entity.BaseStation;
import com.navigation.system.navigation.entity.MobileStation;
import com.navigation.system.navigation.entity.Report;
import com.navigation.system.navigation.service.ControllerHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UtilTests {

	@Autowired
	private ControllerHelper controllerHelper;

	@Test
	public void ReportResponseIsGeneratedCorrectly(){

		// Arrange
		long baseId = 1;
		List<Report> reports = new ArrayList<>();
		for (long i = 1; i < 6; i++) {
			Report report = new Report();
			BaseStation base = new BaseStation();
			MobileStation mobile = new MobileStation();
			base.setId(i);
			mobile.setId(i);
			report.setBaseStation(base);
			report.setMobileStation(mobile);
			reports.add(report);
		}

		// Assert
		assertEquals(controllerHelper.generateResponse(baseId, reports).reports.size(),1);
	}

	@Test
	public void CalculateDistanceReturnsCorrectDistance(){
		// Arrange
		BaseStation baseStation = new BaseStation();
		baseStation.setX(0);
		baseStation.setY(0);
		MobileStation mobileStation = new MobileStation();
		mobileStation.setX((float)0.5);
		mobileStation.setY((float)0.5);
		// Assert
		assertEquals(controllerHelper.calculateDistance(baseStation,mobileStation), 0.707, 0.001);
	}

}
