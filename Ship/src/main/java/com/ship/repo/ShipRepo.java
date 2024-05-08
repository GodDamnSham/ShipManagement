package com.ship.repo;

import com.ship.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepo extends JpaRepository<Ship,Long> {
    Ship findByShipName(String shipName);

}
