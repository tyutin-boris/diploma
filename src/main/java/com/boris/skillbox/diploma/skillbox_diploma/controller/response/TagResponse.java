package com.boris.skillbox.diploma.skillbox_diploma.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagResponse {
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double weight;

    public TagResponse(String name) {
        this.name = name;
    }
}
