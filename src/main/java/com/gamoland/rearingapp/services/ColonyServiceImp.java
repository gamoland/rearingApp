package com.gamoland.rearingapp.services;

import com.gamoland.rearingapp.repositories.ColonyRepository;
import com.gamoland.rearingapp.services.interfaces.ColonyService;
import com.gamoland.rearingapp.services.interfaces.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class ColonyServiceImp implements ColonyService {
    private final ColonyRepository colonyRepository;


    public ColonyServiceImp(ColonyRepository colonyRepository) {
        this.colonyRepository = colonyRepository;
    }
}
