package com.example.otherbanktransferbeneficiary.validators;
import com.example.otherbanktransferbeneficiary.repositories.AccountTransferRepository;
import com.example.otherbanktransferbeneficiary.repositories.CardTransferRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class CardBeneficiaryIdMustExistValidator implements ConstraintValidator<CardBeneficiaryIdMustExist, String> {

    private final CardTransferRepository cardTransferRepository;

    public void initialize(CardBeneficiaryIdMustExist cardBeneficiaryIdMustExist) {
    }

    public boolean isValid(String id, ConstraintValidatorContext context) {
        return cardTransferRepository.findById(id).isPresent();
    }
}