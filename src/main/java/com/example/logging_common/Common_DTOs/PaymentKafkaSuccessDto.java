package com.example.logging_common.Common_DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentKafkaSuccessDto {
    private UUID orderId;
    private UUID paymentId;
}
