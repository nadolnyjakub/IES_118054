package com.kuba.lab3_3.model;

import com.kuba.lab3_3.repository.QuoteRepository;
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
public class Quote {
    @Id
    @GeneratedValue
    Long id;

    private String quoteText;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    public Quote(String quoteText, Show show) {
        this.quoteText = quoteText;
        this.show = show;
    }
}
