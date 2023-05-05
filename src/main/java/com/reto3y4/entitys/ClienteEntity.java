package com.reto3y4.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="cliente")
@Data
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClient")
    private Long idClient;

    @NotEmpty
    @Column(name = "email")
    private  String email;

    @NotEmpty
    @Column(name = "password")
     private String password;

    @NotEmpty
    @Column(name="name")
    private  String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties({"client","car"})
    private List<MensajesEntity> messages;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties({"client","messages","car"})
    private List<ReservasEntity> reservations;




}
