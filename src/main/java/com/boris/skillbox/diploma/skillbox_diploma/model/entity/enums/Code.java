package com.boris.skillbox.diploma.skillbox_diploma.model.entity.enums;

public enum Code {
    MULTIUSER_MODE("name", false),
    POST_PRE_MODERATION("name", false),
    STATISTICS_IS_PUBLIC("name", false);

    private String name;
    private boolean value;

    Code(String name, boolean value) {

        this.name = name;
        this.value = value;
    }
}
