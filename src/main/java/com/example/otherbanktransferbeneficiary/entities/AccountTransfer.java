package com.example.otherbanktransferbeneficiary.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountTransfer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String userId;

    @NotEmpty
    private String accountNumber;

    @NotEmpty
    private String accountHolder;

    @NotEmpty
    private String saveAsName;

    @NotEmpty
    private String bankId;

    @NotEmpty
    private String districtId;

    @NotEmpty
    private String branchId;

    @NotEmpty
    private String routingNumber;
}
