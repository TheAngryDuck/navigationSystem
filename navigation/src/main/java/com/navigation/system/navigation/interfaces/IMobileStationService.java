package com.navigation.system.navigation.interfaces;

import com.navigation.system.navigation.entity.MobileStation;

import java.util.List;
import java.util.Optional;

public interface IMobileStationService {

    List<MobileStation> getAllMobileStations();

    Optional<MobileStation> getMobileStationById(long id);

}
