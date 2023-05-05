package com.reto3y4.Controller;


import com.reto3y4.entitys.ClienteEntity;
import com.reto3y4.entitys.MensajesEntity;
import com.reto3y4.services.ServicesIa.MensagesServiceIa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/dev", "/api/Message"})
@CrossOrigin("*")
public class MensagesController {

    @Autowired
    MensagesServiceIa mensagesService;

    @GetMapping("/all")
    public ResponseEntity<?> getMensajes() {

        return new ResponseEntity<List<MensajesEntity>>(mensagesService.findALll(), HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<?> MensajesEntity(@RequestBody MensajesEntity mensaje) {

        System.out.println(mensaje);
        if (mensaje != null) {
            return new ResponseEntity<MensajesEntity>(mensagesService.save(mensaje), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MensajesEntity mensaje) {


        MensajesEntity result = mensagesService.findById(mensaje.getIdMessage());

        if (result != null) {
            mensaje.setIdMessage(result.getIdMessage());
           return  new ResponseEntity<MensajesEntity>( mensagesService.save(mensaje), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<MensajesEntity> result = Optional.ofNullable((mensagesService.findById(id)));

        if (result.isPresent()) {
            mensagesService.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
