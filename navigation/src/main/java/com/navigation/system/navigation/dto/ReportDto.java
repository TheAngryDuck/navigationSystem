package com.navigation.system.navigation.dto;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
public class ReportDto {

    public long mobileStationId;
    public float distance;
    public Timestamp timestamp;
}
