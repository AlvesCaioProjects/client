package com.bank_service.client.dto;

import com.bank_service.client.model.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountDTO {

    private UUID id;
    private BigDecimal balance;
    private Status status;
}
