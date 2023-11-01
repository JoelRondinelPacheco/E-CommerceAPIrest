package com.joel.spring.controllers;

import com.joel.spring.dtos.clients.ClientEditReqDTO;
import com.joel.spring.dtos.clients.ClientPostReqDTO;
import com.joel.spring.entities.Client;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Client> crate(@RequestBody ClientPostReqDTO body) {
        return new ResponseEntity<Client>(this.clientService.save(body), HttpStatus.OK);
    }

    @GetMapping
    public List<Client> getAll () { return this.clientService.getAll(); }

    @GetMapping("/{client_id}")
    public ResponseEntity<Client> getById (@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<Client>(this.clientService.getById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{client_id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.clientService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("edit/{client_id}")
    public ResponseEntity<Client> edit(@RequestBody ClientEditReqDTO body) throws NotFoundException {
        Client client = this.clientService.update(body);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }


}
