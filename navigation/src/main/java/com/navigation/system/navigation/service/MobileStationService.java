package com.navigation.system.navigation.service;

import com.navigation.system.navigation.entity.MobileStation;
import com.navigation.system.navigation.interfaces.IBaseStationRepository;
import com.navigation.system.navigation.interfaces.IMobileStationRepository;
import com.navigation.system.navigation.interfaces.IMobileStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MobileStationService implements IMobileStationService {

    @Autowired
    private IMobileStationRepository mobileStationRepository;

    @Override
    public List<MobileStation> getAllMobileStations() {
        return this.mobileStationRepository.findAll();
    }
}
