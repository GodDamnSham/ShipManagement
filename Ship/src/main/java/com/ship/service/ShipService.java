package com.ship.service;

import com.ship.repo.ShipRepo;
import com.ship.entity.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    @Autowired
    ShipRepo shipRepo;

    public List<Ship> getAllShips(){
        return this.shipRepo.findAll();
    }

    public Ship getShipById(Long id){
        return this.shipRepo.findById(id).orElse(null);
    }

    public void delShipById(Long id){
        this.shipRepo.deleteById(id);
    }
    public Ship addShip(Ship s){
        Ship sp = this.shipRepo.findByShipName(s.getShipName());
        if(sp!=null){
            int q = s.getQuantity();
            int q2 = sp.getQuantity();
            int total= q+q2;
            if(total<4){
                sp.setQuantity(total);
                this.shipRepo.save(sp);
                return sp;
            }else{
                return null;
            }
        }else {
            return this.shipRepo.save(s);
        }
    }
}
