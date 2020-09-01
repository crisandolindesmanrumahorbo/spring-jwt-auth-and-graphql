package com.example.demo.user;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "api_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @EqualsAndHashCode.Exclude
    @NotNull(message = "Name of the user must not null")
    private String name;

    @EqualsAndHashCode.Exclude
    @NotNull(message = "Password of the user must not null")
    private String password;

    @NotNull(message = "Username of the user must not null")
    private String username;

    @EqualsAndHashCode.Exclude
    @NotNull(message = "Phone of the user must not null")
    @Column(unique = true)
    private String phone;

    @EqualsAndHashCode.Exclude
    @NotNull(message = "Phone of the user must not null")
    @Column(unique = true)
    private String email;

}
