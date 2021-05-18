package com.boris.skillbox.diploma.skillbox_diploma.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumbersOfPostDTO {
    private String year;
    private long numbersOfPostPerYear;
}
