package com.kuba.lab3_3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "show_")
@Getter
@Setter
@NoArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int releaseYear;
    private String genre;
}
