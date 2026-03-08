package com.bank_service.client.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TransferDTO {

    private UUID accountSender;
    private UUID accountReceiver;
    private BigDecimal value;
}
