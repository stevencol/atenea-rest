package com.reto3y4.services.ServicesIa;


import com.reto3y4.entitys.GamaEntity;

import java.util.List;

public interface GamaServiceIa {

    List<GamaEntity> findAll();

    GamaEntity save(GamaEntity gama);

    void update(GamaEntity gama);

    GamaEntity findById(Long id);

    void deleteById(Long id);
}
