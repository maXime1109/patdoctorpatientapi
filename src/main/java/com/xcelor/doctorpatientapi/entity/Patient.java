package com.xcelor.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String city;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 10, max = 15)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Symptom symptom;

    // Getters and setters

    public enum Symptom {
        ARTHRITIS, BACK_PAIN, TISSUE_INJURIES, DYSMENORRHEA, SKIN_INFECTION, SKIN_BURN, EAR_PAIN
    }

    // Getters and Setters
}
