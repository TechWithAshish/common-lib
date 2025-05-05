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
public class PaymentKafkaFailedDto {
    private UUID orderId;
    private String paymentFailureReason;
}
