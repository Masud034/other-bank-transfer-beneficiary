package com.example.otherbanktransferbeneficiary.repositories;

import com.example.otherbanktransferbeneficiary.entities.CardTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardTransferRepository extends JpaRepository<CardTransfer, String> {
    boolean existsByUserIdAndCardNumber(String userId, String cardNumber);

    CardTransfer findByUserIdAndId(String userId, String beneficiaryId);

    List<CardTransfer> findAllByUserId(String userId);

    void deleteByUserIdAndId(String userId, String beneficiaryId);
}
