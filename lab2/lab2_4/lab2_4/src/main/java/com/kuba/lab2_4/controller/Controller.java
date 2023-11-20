package com.kuba.lab2_4.controller;

import com.kuba.lab2_4.model.Show;
import com.kuba.lab2_4.service.MovieService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    MovieService movieService;

    @GetMapping("/shows")
    public ResponseEntity<Object> getShows() {
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/quote")
    public ResponseEntity<Object> getQuotes() {

        return new ResponseEntity<>(movieService.getRandomQuote(), HttpStatus.OK);
    }

    @GetMapping("/quotes")
    public ResponseEntity<Object> getShowByQuote(@PathParam("show") String show) {
        return new ResponseEntity<>(movieService.getQuotesByMovie(show), HttpStatus.OK);
    }


}
