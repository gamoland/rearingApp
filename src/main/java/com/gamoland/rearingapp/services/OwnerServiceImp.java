package com.gamoland.rearingapp.services;

import com.gamoland.rearingapp.models.Owner;
import com.gamoland.rearingapp.repositories.OwnerRepository;
import com.gamoland.rearingapp.services.interfaces.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceImp implements OwnerService {
    private final OwnerRepository ownerRepository;


    public OwnerServiceImp(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Override
    public boolean matchUserPassword(String username, String password) {
        if (ownerRepository.findByUsername(username).isPresent()) {
            Owner owner = ownerRepository.findByUsername(username).get();
            if (owner.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Owner> findByUsername(String username) {
        return ownerRepository.findByUsername(username);
    }

    @Override
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    //TODO finish validation for email
    @Override
    public boolean validemil(Owner owner) {

        return true;
    }
}
