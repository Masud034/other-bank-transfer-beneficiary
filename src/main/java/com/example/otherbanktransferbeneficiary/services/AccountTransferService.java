package com.example.otherbanktransferbeneficiary.services;

import com.example.otherbanktransferbeneficiary.entities.AccountTransfer;
import com.example.otherbanktransferbeneficiary.exceptions.DuplicateBeneficiaryException;
import com.example.otherbanktransferbeneficiary.repositories.AccountTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountTransferService {

    private final AccountTransferRepository accountTransferRepository;

    public AccountTransfer addBeneficiary(String userId, AccountTransfer accountTransfer) {
        if (accountTransferRepository.existsByUserIdAndAccountNumber(userId, accountTransfer.getAccountNumber()))
            throw new DuplicateBeneficiaryException("This beneficiary is already added");
        accountTransfer.setUserId(userId);
        return accountTransferRepository.save(accountTransfer);
    }

    public AccountTransfer getBeneficiary(String userId, String beneficiaryId) {
        return accountTransferRepository.findByUserIdAndId(userId, beneficiaryId);
    }

    public List<AccountTransfer> getAllBeneficiaries(String userId) {
        return accountTransferRepository.findAllByUserId(userId);
    }

    public void deleteBeneficiary(String userId, String beneficiaryId) {
        accountTransferRepository.deleteByUserIdAndId(userId, beneficiaryId);
    }
}
