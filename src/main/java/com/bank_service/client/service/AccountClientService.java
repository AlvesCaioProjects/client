package com.bank_service.client.service;

import com.bank_service.client.AccountClient;
import com.bank_service.client.dto.AccountDTO;
import com.bank_service.client.dto.OperationDTO;
import com.bank_service.client.dto.TransferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountClientService {

    @Autowired
    private AccountClient accountClient;

    public AccountDTO getAccountById(UUID id){
        return accountClient.getAccount(id);
    }

    public AccountDTO deposit(UUID id, OperationDTO operation){
        return accountClient.deposit(id, operation);
    }

    public Object withdraw(UUID id, OperationDTO operation){
        Boolean transactionIsValid = transactionIsValid(id, operation.getValue());
        if(transactionIsValid){
            return accountClient.withdraw(id, operation);
        } else {
            return new RuntimeException("Saldo insuficiente");
        }
    }

    public Object transfer(UUID id, TransferDTO transfer){
        Boolean transactionIsValid = transactionIsValid(id, transfer.getValue());
        if(transactionIsValid){
            return accountClient.transfer(transfer);
        } else {
            return new RuntimeException("Saldo insuficiente");
        }
    }

    private Boolean transactionIsValid(UUID accountId, BigDecimal amount){
        AccountDTO accountValidation = getAccountById(accountId);
        if (accountValidation.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0){
            return false;
        }
        return true;
    }
}
