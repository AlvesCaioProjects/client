package com.bank_service.client.controller;

import com.bank_service.client.dto.AccountDTO;
import com.bank_service.client.dto.OperationDTO;
import com.bank_service.client.dto.TransferDTO;
import com.bank_service.client.service.AccountClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/account")
public class AccountClientController {

    @Autowired
    private AccountClientService accountClientService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<AccountDTO> getAccount(@PathVariable UUID id) {
        return ResponseEntity.ok(accountClientService.getAccountById(id));
    }

    @PostMapping(value = "/{id}/deposit")
    private ResponseEntity<AccountDTO> deposit(@PathVariable UUID id, @RequestBody OperationDTO operation) {
        return ResponseEntity.ok(accountClientService.deposit(id, operation));
    }

    @PostMapping(value = "/{id}/withdraw")
    public ResponseEntity<Object> withdraw(@PathVariable UUID id, @RequestBody OperationDTO operation) {
        Object response = accountClientService.withdraw(id, operation);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/transfer")
    public ResponseEntity<Object> transfer(@RequestBody TransferDTO transfer) {
        Object response = accountClientService
                .transfer(transfer.getAccountSender(), transfer);
        return ResponseEntity.ok(response);
    }
}
