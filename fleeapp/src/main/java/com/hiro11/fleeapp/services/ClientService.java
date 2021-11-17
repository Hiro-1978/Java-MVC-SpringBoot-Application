package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.Client;
import com.hiro11.fleeapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    //Get All Clients
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    //Get Client By Id
    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    //Delete Client
    public void delete(int id) {
        clientRepository.deleteById(id);
    }

    //Update Client
    public void save(Client client) {
        clientRepository.save(client);
    }
}
