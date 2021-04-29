package com.gamoland.rearingapp.repositories;

import com.gamoland.rearingapp.models.Colony;
import com.gamoland.rearingapp.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColonyRepository extends CrudRepository<Colony, Long> {
}
