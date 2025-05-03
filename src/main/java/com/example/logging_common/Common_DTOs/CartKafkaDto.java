package com.example.logging_common.Common_DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartKafkaDto {
    private String userEmail;
    private List<ProductKafkaDto> productList;
    private double totalAmount;
}
