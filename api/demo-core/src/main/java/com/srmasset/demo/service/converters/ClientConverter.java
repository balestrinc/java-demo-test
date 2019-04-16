package com.srmasset.demo.service.converters;

import com.srmasset.demo.api.Client;
import com.srmasset.demo.repository.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {
    public ClientConverter() {
    }

    public Client convertToDto(ClientEntity entity) {
        Client client = new Client(entity.getId(),
                entity.getName(),
                entity.getCreditLimit(),
                entity.getRisk(),
                entity.getInterestRate());
        return client;
    }

    public ClientEntity convertToEntity(Client client) {
        ClientEntity entity = new ClientEntity(client.getName(),
                client.getCreditLimit(),
                client.getInterestRate(),
                client.getRisk());
        return entity;
    }
}