package com.boris.skillbox.diploma.skillbox_diploma.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalendarResponse {
    private Set<String> years;
    private Map<String, Long> posts;
}
