package com.bank_service.client.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OperationDTO {

    private UUID accountId;
    private BigDecimal value;
}
