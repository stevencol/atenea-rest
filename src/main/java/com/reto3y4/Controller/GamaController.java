package com.reto3y4.Controller;


import com.reto3y4.entitys.GamaEntity;
import com.reto3y4.services.ServicesImpl.GamaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/dev", "/api/Gama"})
@CrossOrigin("*")
public class GamaController {

    @Autowired
    GamaServiceImpl gamaService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<?> getGamas() {

        return  new  ResponseEntity<List<GamaEntity>> (gamaService.findAll() , HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<?> getGamas(@RequestBody GamaEntity gama) {

        if (gama != null) {

            return new ResponseEntity<> (gamaService.save(gama), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody GamaEntity gama) {


        GamaEntity resultGama = gamaService.findById(gama.getIdGama());

        if (resultGama != null) {
            gama.setIdGama(resultGama.getIdGama());
            return  new ResponseEntity<GamaEntity>(gamaService.save(gama) , HttpStatus.CREATED);
        }

       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<GamaEntity> resulGama = Optional.ofNullable(gamaService.findById(id));

        if (resulGama.isPresent()) {
            gamaService.deleteById(id);
            return  new ResponseEntity<>(  HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }


}
