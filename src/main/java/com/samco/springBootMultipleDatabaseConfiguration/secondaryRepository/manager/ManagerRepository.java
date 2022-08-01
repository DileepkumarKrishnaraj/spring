package com.samco.springBootMultipleDatabaseConfiguration.secondaryRepository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samco.springBootMultipleDatabaseConfiguration.secondary.manager.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
