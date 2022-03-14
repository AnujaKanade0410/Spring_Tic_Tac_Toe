package com.an.springboot_tictactoe.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class CreateMoveDTO {
    @NotNull
    int boardRow;
    @NotNull
    int boardColumn;
}
