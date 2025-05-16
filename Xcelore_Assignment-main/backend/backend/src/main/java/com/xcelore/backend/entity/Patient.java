package com.xcelore.backend.entity;

import com.xcelore.backend.entity.enums.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3)
    private String name;

    @Size(max = 20)
    private String city;

    @Email
    private String email;

    @Size(min = 10)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Symptom symptom;
}