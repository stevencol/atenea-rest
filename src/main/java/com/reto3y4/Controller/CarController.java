package com.reto3y4.Controller;


import com.reto3y4.entitys.CarEntity;
import com.reto3y4.services.ServicesIa.CarServiceIa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/dev", "/api/Car"})
@CrossOrigin("*")
public class CarController {


    @Autowired
    CarServiceIa carService;

    @GetMapping("/all")
    public ResponseEntity<?>getGamas() {

        return  new ResponseEntity<List<CarEntity> >(carService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<?> setCar(@RequestBody CarEntity car) {
        System.out.println(car.getGama());
        if (car != null) {
            carService.save(car);
            return  new ResponseEntity<CarEntity>(car , HttpStatus.CREATED);
        }
        return  new ResponseEntity<CarEntity>(car , HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CarEntity car) {


        CarEntity carResult = carService.findById(car.getIdCar());

        if (carResult != null) {
            car.setIdCar(carResult.getIdCar());
            car.setGama(carResult.getGama());
            carService.save(car);
            return  new ResponseEntity<CarEntity>(car, HttpStatus.CREATED);
        }

        return  new ResponseEntity<CarEntity>(car, HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<CarEntity> resulGama = Optional.ofNullable(carService.findById(id));

        if (resulGama.isPresent()) {
            carService.deleteById(id);
            return  new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/Hola")
    public String hola(@RequestParam String nombre) {
        return nombre;
    }


}
