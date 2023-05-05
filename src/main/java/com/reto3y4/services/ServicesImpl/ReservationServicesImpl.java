package com.reto3y4.services.ServicesImpl;


import com.reto3y4.entitys.ReservasEntity;
import com.reto3y4.repository.ReservasRepository;
import com.reto3y4.services.ServicesIa.ReservationsIa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServicesImpl implements ReservationsIa {


    @Autowired
    ReservasRepository reservationRespo;


    @Override
    public List<ReservasEntity> findAll() {
      return reservationRespo.findAll();
    }

    @Override
    public ReservasEntity save(ReservasEntity reserva) {
        return reservationRespo.save(reserva);
    }

    @Override
    public void update(ReservasEntity reserva) {

    }

    @Override
    public ReservasEntity findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
