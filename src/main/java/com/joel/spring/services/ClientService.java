package com.joel.spring.services;

import com.joel.spring.dtos.clients.ClientEditReqDTO;
import com.joel.spring.dtos.clients.ClientPostReqDTO;
import com.joel.spring.entities.Client;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService implements ICrudService<Client, ClientPostReqDTO, ClientEditReqDTO, Long> {

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public Client getById(Long id) throws NotFoundException {
        Optional<Client> optionalClient =  this.clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return client;
        }
        throw new NotFoundException("Client not found");
    }

    @Override
    @Transactional
    public Client save(ClientPostReqDTO dto) {
        return this.clientRepository.save(new Client(dto.getName(), dto.getLastname(), dto.getDni()));

    }

    @Override
    public String delete(Long id) {
        this.clientRepository.deleteById(id);
        return "Client deleted";
    }

    @Override
    public Client update(ClientEditReqDTO dto) throws NotFoundException {
        Client client = this.getById(dto.getClient_id());
        client.setName(dto.getName());
        client.setLastname(dto.getLastname());
        client.setDni(dto.getDni());
        this.clientRepository.save(client);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return this.clientRepository.findAll();
    }
}
