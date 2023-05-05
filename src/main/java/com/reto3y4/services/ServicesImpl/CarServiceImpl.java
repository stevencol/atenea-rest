package com.reto3y4.services.ServicesImpl;

import com.reto3y4.entitys.CarEntity;
import com.reto3y4.repository.CarRepository;
import com.reto3y4.services.ServicesIa.CarServiceIa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarServiceIa {

    @Autowired
    CarRepository carRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CarEntity> findAll() {
       return carRepository.findAll();
    }

    @Override
    public void save(CarEntity car) {
        carRepository.save(car);
    }

    @Override
    public void update(CarEntity car) {

    }

    @Override
    public CarEntity findById(Long id) {
      return  carRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
    carRepository.deleteById(id);
    }
}
