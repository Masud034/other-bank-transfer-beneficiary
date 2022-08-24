package com.example.otherbanktransferbeneficiary.controllers;

import com.example.otherbanktransferbeneficiary.endpoints.EndpointUtils;
import com.example.otherbanktransferbeneficiary.entities.CardTransfer;
import com.example.otherbanktransferbeneficiary.services.CardTransferService;
import com.example.otherbanktransferbeneficiary.validators.CardBeneficiaryIdMustExist;
import lombok.Getter;
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
public class CardTransferController {

    private final CardTransferService cardTransferService;

    @PostMapping(value = EndpointUtils.ADD_CARD_BENEFICIARY, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardTransfer> addBeneficiary(@PathVariable String userId, @RequestBody @Valid CardTransfer cardTransfer) {
        return new ResponseEntity<>(cardTransferService.addBeneficiary(userId, cardTransfer), HttpStatus.CREATED);
    }

    @GetMapping(value = EndpointUtils.GET_CARD_BENEFICIARY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardTransfer> getBeneficiary(@PathVariable String userId, @PathVariable @CardBeneficiaryIdMustExist String beneficiaryId) {
        return new ResponseEntity<>(cardTransferService.getBeneficiary(userId, beneficiaryId), HttpStatus.OK);
    }

    @GetMapping(value = EndpointUtils.GET_ALL_CARD_BENEFICIARY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CardTransfer>> getAllBeneficiaries(@PathVariable String userId) {
        return new ResponseEntity<>(cardTransferService.getAllBeneficiaries(userId), HttpStatus.OK);
    }

    @DeleteMapping(value = EndpointUtils.DELETE_CARD_BENEFICIARY)
    public ResponseEntity<String> deleteBeneficiary(@PathVariable String userId, @PathVariable @CardBeneficiaryIdMustExist String beneficiaryId) {
        cardTransferService.deleteBeneficiary(userId, beneficiaryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
