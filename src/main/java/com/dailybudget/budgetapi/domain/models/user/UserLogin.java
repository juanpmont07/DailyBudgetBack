package com.dailybudget.budgetapi.domain.models.user;

import com.dailybudget.budgetapi.infrastructure.adapters.entities.user.UserInfoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "userlogin")
public class UserLogin {

    @Id
    @Column(name="user_id")
    private UUID userId;
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserInfoEntity userInfo;
}
