package com.otr.DataDriver.repositories;

import com.otr.DataDriver.models.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TruckRepository extends JpaRepository<Truck, Long> {
}
