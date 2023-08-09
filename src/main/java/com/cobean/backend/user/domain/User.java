package com.cobean.backend.user.domain;

import com.cobean.backend.common.domain.DateTime;
import com.cobean.backend.roasters.domain.Roasters;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class User extends DateTime {
    @Id
    @Column(name = "user_id", columnDefinition = "varchar(128)")
    private String id;

    @Column(name = "user_name", nullable = false, columnDefinition = "varchar(128)")
    private String name;

    @Column(name = "user_nickname", nullable = false, columnDefinition = "varchar(64)")
    private String nickname;

    @Column(name = "user_password", nullable = false, columnDefinition = "varchar(128)")
    private String password;

    @Column(name = "user_role", nullable = false, columnDefinition = "varchar(64)")
    private String role;
}
