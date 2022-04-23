package com.example.umbrellaarea.umbrellaarea.admin.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class ViewUmbrellaZone {

    private String zoneName;

    private Integer umbrellaCount;

    private double nx;

    private double ny;
}
