package com.example.logging_common.Common_DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductKafkaDto {
    private UUID productId;
    private int quantity;
    private double pricePerQuantity;
}
