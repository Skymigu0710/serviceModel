package com.gato.gatito.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gatitos")

public class Gatito {
    @Id//
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Para que sea autoincrementable
    private long id;
    private String name;
    private String raza;
    private String color;
    private String dueño;
}
