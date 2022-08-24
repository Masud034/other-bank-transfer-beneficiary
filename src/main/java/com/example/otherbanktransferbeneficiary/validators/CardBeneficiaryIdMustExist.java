package com.example.otherbanktransferbeneficiary.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CardBeneficiaryIdMustExistValidator.class)
public @interface CardBeneficiaryIdMustExist {

    String message() default "INVALID Beneficiary Id ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}