package com.reto3y4.services.ServicesImpl;


import com.reto3y4.entitys.GamaEntity;
import com.reto3y4.repository.GamaRepository;
import com.reto3y4.services.ServicesIa.GamaServiceIa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamaServiceImpl implements GamaServiceIa {

    @Autowired
     private GamaRepository gamaRepository;

    @Override
    public List<GamaEntity> findAll() {
        return gamaRepository.findAll();
    }

    @Override
    public GamaEntity save(GamaEntity gama) {
    return   gamaRepository.save(gama);
    }

    @Override
    public void update(GamaEntity gama) {

    }

    @Override
    public GamaEntity findById(Long id) {
       return gamaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
   gamaRepository.deleteById(id);
    }
}
