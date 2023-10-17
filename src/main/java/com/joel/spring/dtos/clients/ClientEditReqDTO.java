package com.joel.spring.dtos.clients;

import lombok.Getter;

@Getter
public class ClientEditReqDTO extends ClientPostReqDTO {
    private Long client_id;
}
