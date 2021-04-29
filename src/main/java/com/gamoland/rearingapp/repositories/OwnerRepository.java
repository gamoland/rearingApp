package com.gamoland.rearingapp.repositories;

import com.gamoland.rearingapp.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByUsername(String username);
}
