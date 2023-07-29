package com.navigation.system.navigation.interfaces;

import com.navigation.system.navigation.entity.MobileStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMobileStationRepository extends JpaRepository<MobileStation,Long> {
}
