package com.reto3y4.services.ServicesImpl;


import com.reto3y4.entitys.ClienteEntity;
import com.reto3y4.repository.ClienteRepository;
import com.reto3y4.services.ServicesIa.ClienteServiceIa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl  implements ClienteServiceIa {

    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<ClienteEntity> findAll() {
        return  (List<ClienteEntity>) repository.findAll();
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return repository.save(cliente);
    }

    @Override
    public void update(ClienteEntity cliente) {

    }

    @Override
    public ClienteEntity findById(Long id) {
        return  repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
