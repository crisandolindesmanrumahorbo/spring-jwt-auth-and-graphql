package com.example.demo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDto {
    @NotNull(message = "Name of the user must not null")
    private String name;

    @NotNull(message = "Phone of the user must not null")
    private String phone;

    @NotNull(message = "Phone of the user must not null")
    private String email;

}
