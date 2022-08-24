package com.example.otherbanktransferbeneficiary.repositories;

import com.example.otherbanktransferbeneficiary.entities.AccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransferRepository extends JpaRepository<AccountTransfer, String> {
    boolean existsByAccountNumber(String accountNumber);

    AccountTransfer findByUserIdAndId(String userId, String beneficiaryId);

    List<AccountTransfer> findAllByUserId(String userId);

    void deleteByUserIdAndId(String userId, String beneficiaryId);
}
