package com.srmasset.demo.app;

import com.srmasset.demo.api.Client;
import com.srmasset.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class ClientController {

    private ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @RequestMapping(value = "/client", method = POST)
    public ResponseEntity<Client> createUser(@Valid @RequestBody Client client) {
        Client newClient = service.create(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/client", method = GET)
    public ResponseEntity<List<Client>> getUsers() {
        List<Client> clients = service.getAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
