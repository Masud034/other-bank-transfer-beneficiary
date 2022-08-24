package com.example.otherbanktransferbeneficiary.controllers;

import com.example.otherbanktransferbeneficiary.endpoints.EndpointUtils;
import com.example.otherbanktransferbeneficiary.entities.AccountTransfer;
import com.example.otherbanktransferbeneficiary.services.AccountTransferService;
import com.example.otherbanktransferbeneficiary.validators.BeneficiaryIdMustExist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class AccountTransferController {

    private final AccountTransferService accountTransferService;

    @PostMapping(value = EndpointUtils.ADD_ACCOUNT_BENEFICIARY,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountTransfer> addBeneficiary(@PathVariable String userId, @RequestBody @Valid AccountTransfer accountTransfer) {
        return new ResponseEntity<>(accountTransferService.addBeneficiary(userId, accountTransfer), HttpStatus.CREATED);
    }

    @GetMapping(value = EndpointUtils.GET_ACCOUNT_BENEFICIARY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountTransfer> getBeneficiary(@PathVariable String userId, @PathVariable @BeneficiaryIdMustExist String beneficiaryId) {
        return new ResponseEntity<>(accountTransferService.getBeneficiary(userId, beneficiaryId), HttpStatus.OK);
    }

    @GetMapping(value = EndpointUtils.GET_ALL_ACCOUNT_BENEFICIARY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountTransfer>> getAllBeneficiaries(@PathVariable @BeneficiaryIdMustExist String userId) {
        return new ResponseEntity<>(accountTransferService.getAllBeneficiaries(userId), HttpStatus.OK);
    }

    @DeleteMapping(value = EndpointUtils.DELETE_ACCOUNT_BENEFICIARY)
    public ResponseEntity<String> deleteBeneficiary(@PathVariable String userId, @PathVariable @BeneficiaryIdMustExist String beneficiaryId) {
        accountTransferService.deleteBeneficiary(userId, beneficiaryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
