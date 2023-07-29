package com.navigation.system.navigation.entity;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="mobile_station_id", nullable=false)
    private MobileStation mobileStation;

    @ManyToOne
    @JoinColumn(name="base_station_id", nullable=false)
    private BaseStation baseStation;

    private long distance;

    private Timestamp log_time;
}
