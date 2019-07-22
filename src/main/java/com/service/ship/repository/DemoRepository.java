package com.service.ship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.ship.model.Demo;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Long>{

}
