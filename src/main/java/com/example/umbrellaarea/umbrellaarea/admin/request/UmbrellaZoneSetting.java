package com.example.umbrellaarea.umbrellaarea.admin.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
public class UmbrellaZoneSetting {

    private String zoneName;
    private Integer umbrellaCount;
    private double nx;
    private double ny;
}
