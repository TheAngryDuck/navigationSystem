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
    private float lastKnownXCoordinate;

    @Column(name = "last_known_y_coordinate")
    private float lastKnownYCoordinate;

    @OneToMany(mappedBy="mobileStation")
    private Set<Report> reports;

    public long getId() {return id;}
    public void setId(long id) {
        this.id = id;
    }
    public float getY() {
        return lastKnownYCoordinate;
    }
    public void setY(float y) {
        this.lastKnownYCoordinate = y;
    }
    public float getX() {
        return lastKnownXCoordinate;
    }
    public void setX(float x) {
        this.lastKnownXCoordinate = x;
    }
}
