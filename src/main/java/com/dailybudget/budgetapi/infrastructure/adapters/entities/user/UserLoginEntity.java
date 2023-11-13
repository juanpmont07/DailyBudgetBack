package com.dailybudget.budgetapi.infrastructure.adapters.entities.user;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Data
@Entity
@Table(name = "userlogin")
public class UserLoginEntity {

    @Id
    @Column(name="user_id")
    private UUID userId;
    private String username = EMPTY;
    private String password = EMPTY;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserInfoEntity userInfo;
}
