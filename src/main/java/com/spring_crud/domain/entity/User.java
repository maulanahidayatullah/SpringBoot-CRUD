package com.spring_crud.domain.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -696969L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String password;

    private String token;

    private String token_expired_at;
}
