package com.navigation.system.navigation.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mobile_stations")
public class MobileStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "last_known_x_coordinate")
    private float last_known_x_coordinate;

    @Column(name = "last_known_y_coordinate")
    private float last_known_y_coordinate;

    @OneToMany(mappedBy="mobileStation")
    private Set<Report> reports;
}
