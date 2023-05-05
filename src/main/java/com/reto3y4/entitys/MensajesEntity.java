package com.reto3y4.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "mensajes")
@Data
@JsonPropertyOrder({ "idMessage", "messageText", "car", "client" })
public class MensajesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private  Long idMessage;

    @Column(name = "messageText")
    private String messageText;

    @ManyToOne
    @JsonIgnoreProperties({"messages","reservations"})
    @JoinColumn(name = "idCar")
    private CarEntity car;

    @ManyToOne
    @JsonIgnoreProperties({"messages","reservations"})
    @JoinColumn(name="idCliente")
    private ClienteEntity client;


}
