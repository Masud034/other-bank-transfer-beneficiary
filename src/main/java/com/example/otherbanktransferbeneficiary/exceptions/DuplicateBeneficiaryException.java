package com.example.otherbanktransferbeneficiary.exceptions;

public class DuplicateBeneficiaryException extends RuntimeException {
    public DuplicateBeneficiaryException(String message) {
        super(message);
    }
}
