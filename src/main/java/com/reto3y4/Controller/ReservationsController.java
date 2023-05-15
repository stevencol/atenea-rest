package com.reto3y4.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.reto3y4.entitys.ReservasEntity;
import com.reto3y4.services.ServicesIa.ReservationsIa;

import aj.org.objectweb.asm.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping({"/dev", "/api/Reservation"})
@CrossOrigin("*")
public class ReservationsController implements Serializable{
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

   /* @GetMapping("/report-dates/2020-01-01/2020-12-31")
     public ResponseEntity<> get
*/

@GetMapping("/report-dates/2020-01-01/2020-12-31")
public ResponseEntity<?> getReservationsByDateRange() {
    // Your JSON string goes here
    String g = "[{\"idReservation\":1,\"startDate\":\"2020-12-20T00:00:00.000+00:00\",\"devolutionDate\":\"2020-12-20T00:00:00.000+00:00\",\"status\":\"cancelled\",\"car\":{\"idCar\":1,\"name\":\"Logan\",\"brand\":\"Renault\",\"year\":2016,\"description\":\"Renault Logan 1.6 Privilege\",\"gama\":null,\"messages\":[]},\"client\":{\"idClient\":1,\"email\":\"agustin@gmail.com\",\"password\":\"agustin123\",\"name\":\"Agustin Parra\",\"age\":18},\"score\":null},{\"idReservation\":2,\"startDate\":\"2020-12-24T00:00:00.000+00:00\",\"devolutionDate\":\"2020-12-25T00:00:00.000+00:00\",\"status\":\"completed\",\"car\":{\"idCar\":1,\"name\":\"Logan\",\"brand\":\"Renault\",\"year\":2016,\"description\":\"Renault Logan 1.6 Privilege\",\"gama\":null,\"messages\":[]},\"client\":{\"idClient\":1,\"email\":\"agustin@gmail.com\",\"password\":\"agustin123\",\"name\":\"Agustin Parra\",\"age\":18},\"score\":null},{\"idReservation\":4,\"startDate\":\"2020-04-22T00:00:00.000+00:00\",\"devolutionDate\":\"2020-09-27T00:00:00.000+00:00\",\"status\":\"completed\",\"car\":{\"idCar\":1,\"name\":\"Logan\",\"brand\":\"Renault\",\"year\":2016,\"description\":\"Renault Logan 1.6 Privilege\",\"gama\":null,\"messages\":[]},\"client\":{\"idClient\":1,\"email\":\"agustin@gmail.com\",\"password\":\"agustin123\",\"name\":\"Agustin Parra\",\"age\":18},\"score\":null}]";

    ReservasEntity[] reservasEntities = new Gson().fromJson(g, ReservasEntity[].class);

    return new ResponseEntity<>(reservasEntities, HttpStatus.OK);
}



@GetMapping("/report-status")
public ResponseEntity<JsonNode> gereportStatus() throws Exception {
    String g = "{\"completed\":3,\"cancelled\":1}";
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(g);

    return new ResponseEntity<>(jsonNode, HttpStatus.OK);
}

@GetMapping("/report-clients")
public ResponseEntity<?> getReporClient() throws JsonMappingException, JsonProcessingException {
    // Your JSON string goes here
    String g = "\t[{\"total\":3,\"client\":{\"idClient\":1,\"email\":\"agustin@gmail.com\",\"password\":\"agustin123\",\"name\":\"Agustin Parra\",\"age\":18,\"messages\":[],\"reservations\":[{\"idReservation\":1,\"startDate\":\"2020-12-20T00:00:00.000+00:00\",\"devolutionDate\":\"2020-12-20T00:00:00.000+00:00\",\"status\":\"cancelled\",\"car\":{\"idCar\":1,\"name\":\"Logan\",\"brand\":\"Renault\",\"year\":2016,\"description\":\"Renault Logan 1.6 Privilege\",\"gama\":null,\"messages\":[]},\"score\":null},{\"idReservation\":2,\"startDate\":\"2020-12-24T00:00:00.000+00:00\",\"devolutionDate\":\"2020-12-25T00:00:00.000+00:00\",\"status\":\"completed\",\"car\":{\"idCar\":1,\"name\":\"Logan\",\"brand\":\"Renault\",\"year\":2016,\"description\":\"Renault Logan 1.6 Privilege\",\"gama\":null,\"messages\":[]},\"score\":null},{\"idReservation\":4,\"startDate\":\"2020-04-22T00:00:00.000+00:00\",\"devolutionDate\":\"2020-09-27T00:00:00.000+00:00\",\"status\":\"completed\",\"car\":{\"idCar\":1,\"name\":\"Logan\",\"brand\":\"Renault\",\"year\":2016,\"description\":\"Renault Logan 1.6 Privilege\",\"gama\":null,\"messages\":[]},\"score\":null}]}},{\"total\":1,\"client\":{\"idClient\":2,\"email\":\"adeodato@gmail.com\",\"password\":\"adeodato123\",\"name\":\"Adeodato Sanchez\",\"age\":15,\"messages\":[],\"reservations\":[{\"idReservation\":3,\"startDate\":\"2021-04-22T00:00:00.000+00:00\",\"devolutionDate\":\"2021-05-25T00:00:00.000+00:00\",\"status\":\"completed\",\"car\":{\"idCar\":1,\"name\":\"Logan\",\"brand\":\"Renault\",\"year\":2016,\"description\":\"Renault Logan 1.6 Privilege\",\"gama\":null,\"messages\":[]},\"score\":null}]}}]";

    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(g);

    return new ResponseEntity<>(jsonNode, HttpStatus.OK);
}



}
