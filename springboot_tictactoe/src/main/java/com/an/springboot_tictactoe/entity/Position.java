package com.an.springboot_tictactoe.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Position {
    int boardRow;
    int boardColumn;
}
