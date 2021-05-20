package com.boris.skillbox.diploma.skillbox_diploma.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "global_settings")
@Data
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
