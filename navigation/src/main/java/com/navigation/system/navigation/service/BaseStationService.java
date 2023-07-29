package com.navigation.system.navigation.service;

import com.navigation.system.navigation.entity.BaseStation;
import com.navigation.system.navigation.interfaces.IBaseStationRepository;
import com.navigation.system.navigation.interfaces.IBaseStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BaseStationService implements IBaseStationService {

    @Autowired
    private IBaseStationRepository baseStationRepository;

    @Override
    public List<BaseStation> getAllBaseStations() {
        return this.baseStationRepository.findAll();
    }
}
