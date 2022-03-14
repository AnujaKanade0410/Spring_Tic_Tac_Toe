package com.an.springboot_tictactoe.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PlayerDTO {

    @NotNull
    private String userName;
    @NotNull
    private String passwordHash;
    @NotNull
    private String email;
}
