package com.kuba.lab3_3.repository;

import com.kuba.lab3_3.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<Show> findShowByName(String name);
}
