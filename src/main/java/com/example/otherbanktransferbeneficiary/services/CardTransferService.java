package com.example.otherbanktransferbeneficiary.services;

import com.example.otherbanktransferbeneficiary.entities.CardTransfer;
import com.example.otherbanktransferbeneficiary.exceptions.DuplicateBeneficiaryException;
import com.example.otherbanktransferbeneficiary.repositories.CardTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CardTransferService {

    private final CardTransferRepository cardTransferRepository;

    public CardTransfer addBeneficiary(String userId, CardTransfer cardTransfer) {
        if (cardTransferRepository.existsByUserIdAndCardNumber(userId, cardTransfer.getCardNumber()))
            throw new DuplicateBeneficiaryException("This card beneficiary is already added");
        cardTransfer.setUserId(userId);
        return cardTransferRepository.save(cardTransfer);
    }

    public CardTransfer getBeneficiary(String userId, String beneficiaryId) {
        return cardTransferRepository.findByUserIdAndId(userId, beneficiaryId);
    }

    public List<CardTransfer> getAllBeneficiaries(String userId) {
        return cardTransferRepository.findAllByUserId(userId);
    }

    public void deleteBeneficiary(String userId, String beneficiaryId) {
        cardTransferRepository.deleteByUserIdAndId(userId, beneficiaryId);
    }
}
