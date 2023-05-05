package com.reto3y4.Controller;


import com.reto3y4.entitys.ReservasEntity;
import com.reto3y4.services.ServicesIa.ReservationsIa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/dev", "/api/Reservation"})
@CrossOrigin("*")
public class ReservationsController {
    @Autowired
    ReservationsIa reservationsIa;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<?> getRerservas() {

        return new ResponseEntity<List<ReservasEntity> >(reservationsIa.findAll(),HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<?> serMensajes(@RequestBody ReservasEntity reserva) {

        System.out.println(reserva);
        if (reserva != null) {
            return new ResponseEntity<ReservasEntity>(reservationsIa.save(reserva), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReservasEntity reserva) {


        ReservasEntity result = reservationsIa.findById(reserva.getIdReservation());

        if (result != null) {
            reserva.setIdReservation(result.getIdReservation());
            return new ResponseEntity<ReservasEntity>(reservationsIa.save(reserva), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<ReservasEntity> result = Optional.ofNullable((reservationsIa.findById(id)));

        if (result.isPresent()) {
            reservationsIa.deleteById(id);
         return new   ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new   ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
