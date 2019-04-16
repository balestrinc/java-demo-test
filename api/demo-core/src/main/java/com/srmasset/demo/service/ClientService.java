package com.srmasset.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.srmasset.demo.api.Risk;
import com.srmasset.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.srmasset.demo.service.converters.ClientConverter;

import com.srmasset.demo.api.Client;
import com.srmasset.demo.repository.entity.ClientEntity;

import static java.util.stream.Collectors.toList;

@Component
public class ClientService {


    private final ClientConverter clientConverter;
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientConverter clientConverter,
                         ClientRepository repository) {
        this.clientConverter = clientConverter;
        this.repository = repository;

    }

    public List<Client> getAll() {
        return repository.findAll().stream().map(entity -> clientConverter.convertToDto(entity)).collect(toList());
    }

    @Transactional
    public Client create(Client client) {
        ClientEntity entityToSave = clientConverter.convertToEntity(setInterestRate(client));
        ClientEntity newClientEntity = repository.save(entityToSave);
        return clientConverter.convertToDto(newClientEntity);
    }

    private Client setInterestRate(Client client) {
        client.setInterestRate(client.getRisk().getRate());
        return client;
    }


}