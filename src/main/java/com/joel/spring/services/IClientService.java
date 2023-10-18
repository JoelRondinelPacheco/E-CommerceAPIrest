package com.joel.spring.services;

import com.joel.spring.dtos.clients.ClientEditReqDTO;
import com.joel.spring.dtos.clients.ClientPostReqDTO;
import com.joel.spring.entities.Client;

public interface IClientService extends ICrudService<Client, ClientPostReqDTO, ClientEditReqDTO, Long> {
}
