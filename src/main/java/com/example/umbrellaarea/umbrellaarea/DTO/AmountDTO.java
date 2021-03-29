package com.example.umbrellaarea.umbrellaarea.DTO;

import lombok.Data;

@Data
public class AmountDTO {
    private Integer total, tax_free, vat, point, discount;
}
