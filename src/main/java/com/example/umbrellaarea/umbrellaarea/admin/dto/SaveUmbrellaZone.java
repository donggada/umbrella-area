package com.example.umbrellaarea.umbrellaarea.admin.dto;

import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class SaveUmbrellaZone {

//    @NotNull(message = "존 이름 필수 값입니다.")
    private String zoneName;

//    @NotNull(message = "우산 갯수는 필수 값 입니다.")
    private Integer umbrellaCount;

//    @NotNull(message = "x 좌표는 필수 값 입니다.")
    private double nx;

//    @NotNull(message = "y 좌표는 필수 값 입니다.")
    private double ny;
}
