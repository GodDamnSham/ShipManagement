package com.example;

import java.util.List;
import java.util.Optional;

import com.example.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ManagerRepo;


@Service
public class ManagerService {
	
	@Autowired
	ManagerRepo managerRepo;
	
	public List<Manager> getAllManager(){
		System.out.println("here");
		return this.managerRepo.findAll();
	}
	
	public Manager addManager(Manager m) {
        return this.managerRepo.save(m);
	}

	public Manager getManagerByID(Long id) {
		Optional<Manager> manager = this.managerRepo.findById(id);
        return manager.orElse(null);
    }

	public void deleteManagerByID(Long id) {
		this.managerRepo.deleteById(id);
	}
}
