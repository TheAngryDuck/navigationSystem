package com.navigation.system.navigation.interfaces;

import com.navigation.system.navigation.entity.BaseStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseStationRepository extends JpaRepository<BaseStation,Long> {
}
