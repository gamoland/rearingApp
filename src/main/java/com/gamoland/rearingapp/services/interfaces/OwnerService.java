package com.gamoland.rearingapp.services.interfaces;

import com.gamoland.rearingapp.models.Owner;

import java.util.Optional;


public interface OwnerService {
    boolean matchUserPassword(String username, String password);

    Optional<Owner> findByUsername(String username);

    void save(Owner owner);

    boolean validemil(Owner owner);
}
