package com.reto3y4.repository;


import com.reto3y4.entitys.GamaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamaRepository extends JpaRepository<GamaEntity, Long> {


}
