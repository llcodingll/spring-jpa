package com.example.spring_jpa.user.domain;

import ch.qos.logback.core.util.StringUtil;
import com.example.spring_jpa.config.BaseEntity;
import com.example.spring_jpa.store.domain.Store;
import com.example.spring_jpa.user.request.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "USERS",
        indexes = {
                @Index(columnList = "email"),
                @Index(columnList = "username")
        }
)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String username;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Store> stores = new ArrayList<>();

    private LocalDateTime createAt = LocalDateTime.now();

    public void update(UserRequest request) {
        if(!StringUtil.isNullOrEmpty(request.password()))
            this.password = request.password();
        if (!StringUtil.isNullOrEmpty(request.username())) {
            this.username = request.username();
        }
    }
}
