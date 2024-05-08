package com.example;
import com.example.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ManagerRepo extends JpaRepository<Manager, Long> {

}
