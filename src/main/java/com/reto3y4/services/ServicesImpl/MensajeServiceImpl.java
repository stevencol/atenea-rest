package com.reto3y4.services.ServicesImpl;


import com.reto3y4.entitys.MensajesEntity;
import com.reto3y4.repository.MensajeRepository;
import com.reto3y4.services.ServicesIa.MensagesServiceIa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeServiceImpl  implements MensagesServiceIa {

    @Autowired
    private MensajeRepository mesRepository;

    @Override
    public List<MensajesEntity> findALll() {
        return (List<MensajesEntity>) mesRepository.findAll();
    }

    @Override
    public MensajesEntity save(MensajesEntity mensaje) {
      return   mesRepository.save(mensaje);

    }

    @Override
    public void update(MensajesEntity mensaje) {

    }

    @Override
    public MensajesEntity findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
