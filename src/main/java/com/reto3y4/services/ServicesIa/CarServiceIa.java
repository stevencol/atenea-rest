package com.reto3y4.services.ServicesIa;


import com.reto3y4.entitys.CarEntity;

import java.util.List;

public interface CarServiceIa {

    List<CarEntity> findAll();

    void save(CarEntity car);


    void update(CarEntity car);

    CarEntity findById(Long id);

    void deleteById(Long id);
}
