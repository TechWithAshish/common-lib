package com.example.logging_common.Common_DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartKafkaDto {
//    private UUID cardId; need to decide on this field whether to take or not....
    private String userEmail;
    private List<ProductKafkaDto> productList;
    private Double totalAmount;
}
