package com.kuba.lab3_3.repository;

import com.kuba.lab3_3.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
