package com.reto3y4.services.ServicesIa;


import com.reto3y4.entitys.GamaEntity;
import com.reto3y4.entitys.MensajesEntity;


import java.util.List;

public interface MensagesServiceIa {

    List<MensajesEntity> findALll();

    MensajesEntity save(MensajesEntity mensaje);


    void update(MensajesEntity mensaje);

    MensajesEntity findById(Long id);

    void deleteById(Long id);
}
