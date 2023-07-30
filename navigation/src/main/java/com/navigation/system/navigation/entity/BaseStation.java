package com.navigation.system.navigation.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "base_stations")
public class BaseStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "x_coordinate")
    private float xCoordinate;

    @Column(name = "y_coordinate")
    private float yCoordinate;

    @Column(name = "detection_radius")
    private float detectionRadius;

    @OneToMany(mappedBy="baseStation")
    private Set<Report> reports;

    public long getId() {return id;}
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getY() {
        return yCoordinate;
    }
    public void setY(float y) {
        this.yCoordinate = y;
    }
    public float getX() {
        return xCoordinate;
    }
    public void setX(float x) {
        this.xCoordinate = x;
    }
    public float getRadius() {
        return detectionRadius;
    }
    public void setRadius(float radius) {
        this.detectionRadius = radius;
    }
}
