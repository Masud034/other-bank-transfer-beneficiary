package com.example.otherbanktransferbeneficiary.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class AccountTransfer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String userId;

    private String accountNumber;

    private String accountHolder;

    private String saveAsName;

    private String bankId;

    private String districtId;

    private String branchId;

    private String routingNumber;
}
