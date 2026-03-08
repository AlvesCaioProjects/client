package com.bank_service.client;

import com.bank_service.client.dto.AccountDTO;
import com.bank_service.client.dto.OperationDTO;
import com.bank_service.client.dto.TransferDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "wallet-service", url = "${wallet.service.url}")
public interface AccountClient {

    @GetMapping("/{id}")
    AccountDTO getAccount(@PathVariable("id") UUID id);

    @PatchMapping("/{id}/deposit")
    AccountDTO deposit(@PathVariable("id") UUID id, @RequestBody OperationDTO operation);

    @PatchMapping("/{id}/withdraw")
    AccountDTO withdraw(@PathVariable("id") UUID id, @RequestBody OperationDTO operation);

    @PatchMapping("/transfer")
    AccountDTO transfer(@RequestBody TransferDTO transfer);
}
