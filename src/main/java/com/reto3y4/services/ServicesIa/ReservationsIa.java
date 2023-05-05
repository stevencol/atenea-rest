package com.reto3y4.services.ServicesIa;

import com.reto3y4.entitys.GamaEntity;
import com.reto3y4.entitys.ReservasEntity;

import java.util.List;

public interface ReservationsIa {

    List<ReservasEntity> findAll();

    ReservasEntity save(ReservasEntity reserva);


    void update(ReservasEntity reserva);

    ReservasEntity findById(Long id);

    void deleteById(Long id);
}

