package com.kuba.lab2_4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Show {
    private Long id;

    private String name;
    private int releaseYear;
    private String genre;

    private List<String> quotes;

}
