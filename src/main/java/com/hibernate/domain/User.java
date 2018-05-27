package com.hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @Transient
    private String passwordConfirm;

    private enum ROLE {
        SIMPLE_USER,
        ADMIN
    };

    private boolean enabled;
    private String confirmationToken;
}
