package com.bank_service.client;

import com.bank_service.client.dto.AccountDTO;
import com.bank_service.client.dto.OperationDTO;
import com.bank_service.client.dto.TransferDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "wallet-service", url = "${wallet.service.url}")
public interface AccountClient {

    @GetMapping("wallet/{id}")
    AccountDTO getAccount(@PathVariable("id") UUID id);

    @PostMapping("wallet/{id}/deposit")
    AccountDTO deposit(@PathVariable("id") UUID id, @RequestBody OperationDTO operation);

    @PostMapping("wallet/{id}/withdraw")
    AccountDTO withdraw(@PathVariable("id") UUID id, @RequestBody OperationDTO operation);

    @PostMapping("wallet/transfer")
    AccountDTO transfer(@RequestBody TransferDTO transfer);
}
