package com.reto3y4.services.ServicesIa;


import com.reto3y4.entitys.ClienteEntity;

import java.util.List;

public interface ClienteServiceIa {

    List<ClienteEntity> findAll();

    ClienteEntity save(ClienteEntity cliente);


    void update(ClienteEntity cliente);

    ClienteEntity findById(Long id);

    void deleteById(Long id);

}
