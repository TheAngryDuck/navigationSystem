package com.navigation.system.navigation.entity;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Column(name = "distance")
    private float distance;

    @Column(name = "log_time")
    private Timestamp logTime;

    public long getId() {return id;}
    public void setId(long id) {
        this.id = id;
    }
    public MobileStation getMobileStation() {
        return mobileStation;
    }
    public void setMobileStation(MobileStation mobileStation) {
        this.mobileStation = mobileStation;
    }
    public BaseStation getBaseStation() {
        return baseStation;
    }
    public void setBaseStation(BaseStation baseStation) {
        this.baseStation = baseStation;
    }
    public float getDistance() {
        return distance;
    }
    public void setDistance(float distance) {
        this.distance = distance;
    }
    public Timestamp getLogTime() {
        return logTime;
    }
    public void setLogTime(Timestamp time) {
        this.logTime = time;
    }
}
