package com.example.otherbanktransferbeneficiary.validators;
import com.example.otherbanktransferbeneficiary.repositories.AccountTransferRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class AccountBeneficiaryIdMustExistValidator implements ConstraintValidator<AccountBeneficiaryIdMustExist, String> {

    private final AccountTransferRepository accountTransferRepository;

    public void initialize(AccountBeneficiaryIdMustExist bankIdMustExist) {
    }

    public boolean isValid(String id, ConstraintValidatorContext context) {
        return accountTransferRepository.findById(id).isPresent();
    }
}
