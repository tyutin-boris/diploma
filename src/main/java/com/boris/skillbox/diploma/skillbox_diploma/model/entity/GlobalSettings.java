package com.boris.skillbox.diploma.skillbox_diploma.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "global_settings")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private boolean value;
}
