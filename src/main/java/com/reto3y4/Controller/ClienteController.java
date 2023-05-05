package com.reto3y4.Controller;

import com.reto3y4.entitys.ClienteEntity;
import com.reto3y4.entitys.GamaEntity;
import com.reto3y4.services.ServicesImpl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/dev", "/api/Client"})
@CrossOrigin("*")

public class ClienteController {


    @Autowired
    private ClienteServiceImpl clienteService;


    @GetMapping("/all")
    public ResponseEntity<?> getClientes() {
        return new ResponseEntity<List<ClienteEntity>>(clienteService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<?> saveClient(@RequestBody ClienteEntity cliente) {

        if (cliente != null) {
            clienteService.save(cliente);
             return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return  new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public  ResponseEntity<?> update(@RequestBody ClienteEntity cliente) {


        ClienteEntity result = clienteService.findById(cliente.getIdClient());

        if (result != null) {
            cliente.setIdClient(result.getIdClient());
           return new ResponseEntity<ClienteEntity >(clienteService.save(cliente), HttpStatus.CREATED);
        }

return   new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<ClienteEntity> result = Optional.ofNullable((clienteService.findById(id)));

        if (result.isPresent()) {
            clienteService.deleteById(id);
            return   new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return   new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
