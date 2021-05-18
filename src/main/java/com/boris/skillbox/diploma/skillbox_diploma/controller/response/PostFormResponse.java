package com.boris.skillbox.diploma.skillbox_diploma.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostFormResponse {
    private long count;
    private List<PostResponse> posts;
}
