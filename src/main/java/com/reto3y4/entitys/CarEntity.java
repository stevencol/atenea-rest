package com.reto3y4.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table (name = "car")
@Data
@JsonPropertyOrder({ "idCar", "name", "brand", "year", "description", "gama", "messages", "reservations" })

public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCar;


    @NotEmpty(message = "No puede estar Vacio")
    @Column(name = "name")
    @Size(max = 45 )
    private  String name;

    @NotEmpty(message = "No puede estar Vacio")
    @Column(name = "brand")
    @Size(max = 45 )
    private  String brand;


    @Column(name = "model")
    @Digits(integer = 4 , fraction = 0 , message = "En año debe contener 4 Didigtos")
    @JsonProperty("year")
    private  int model;

    @NotEmpty(message = "No puede estar Vacio")
    @Column(name = "description")
    @Size(max = 250 )
    private  String description;

    @ManyToOne
    @JoinColumn(name = "idGama" )
    @JsonIgnoreProperties("cars")
    private GamaEntity gama;

    @OneToMany(mappedBy =  "car")
    @JsonIgnoreProperties({"car","client"})
    private List<MensajesEntity> messages;


    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY )
    @JsonIgnoreProperties({"client","messages","car"})
    private List<ReservasEntity> reservations;





}
