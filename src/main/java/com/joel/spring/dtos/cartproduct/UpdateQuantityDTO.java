package com.joel.spring.dtos.cartproduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UpdateQuantityDTO {
    private String id;
    private Integer quantity;
}
