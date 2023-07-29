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
    private float x_coordinate;

    @Column(name = "y_coordinate")
    private float y_coordinate;

    @Column(name = "detection_radius")
    private float detection_radius;

    @OneToMany(mappedBy="baseStation")
    private Set<Report> reports;
}
