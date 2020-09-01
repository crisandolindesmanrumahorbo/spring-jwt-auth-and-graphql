package com.example.demo.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ResponseUserDto {
    private int id;

    @NotNull(message = "Name of the user must not null")
    private String name;

    @NotNull(message = "Phone of the user must not null")
    private String phone;

    @NotNull(message = "Phone of the user must not null")
    private String email;

}
