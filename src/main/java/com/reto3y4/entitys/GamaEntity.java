package com.reto3y4.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "gama")
@Data
public class GamaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGama;

    @NotEmpty(message = "No puede estar Vacio")
    @Column(name = "name")
    @Size(max = 45)
    private  String name;

    @NotEmpty(message = "No puede estar Vacio")
    @Column(name = "description")
    @Size(max = 45)
    private  String description;



    @OneToMany(mappedBy = "gama", cascade = CascadeType.ALL ,  fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"gama","cars"})
    private List<CarEntity>  cars;

}
