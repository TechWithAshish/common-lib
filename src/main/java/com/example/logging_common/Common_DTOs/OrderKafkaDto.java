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
public class OrderKafkaDto {
    private UUID orderId;
    private List<ProductKafkaDto> productList;
    private Double totalAmount;
}
