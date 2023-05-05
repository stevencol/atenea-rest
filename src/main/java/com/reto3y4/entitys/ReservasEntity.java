package com.reto3y4.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Table(name = "reservations")
@Entity
@Data
@JsonPropertyOrder({ "idReservation", "startDate", "devolutionDate", "status", "car", "client", "score" })
public class ReservasEntity {

    @Column(name = "devolutionDate")
    private String devolutionDate;

    @Id
    @Column(name = "idReservation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;


    @Column(name = "score")
    private String score = null;

    @Column(name = "startDate")
    private String startDate;


    @Column(name = "satus")
    private String status = "created";


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCar")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "reservations", "car", "client"})
    private CarEntity car;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "messages", "reservations", "car", "client", "gama"})
    public ClienteEntity client;

    public void setStartDate(String startDate) {
        LocalDateTime localDateTime = LocalDateTime.parse(startDate + "T00:00:00");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        this.startDate = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")).replace("Z" , "+00:00");
    }

    public void setDevolutionDate(String devolutionDate) {
        LocalDateTime localDateTime = LocalDateTime.parse(devolutionDate + "T00:00:00");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        this.devolutionDate = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")).replace("Z" , "+00:00");
    }



}