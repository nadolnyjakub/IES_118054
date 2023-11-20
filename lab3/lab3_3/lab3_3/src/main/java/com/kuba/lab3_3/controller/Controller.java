package com.kuba.lab3_3.controller;

import com.kuba.lab3_3.dto.QuoteDto;
import com.kuba.lab3_3.model.Quote;
import com.kuba.lab3_3.model.Show;
import com.kuba.lab3_3.service.ShowService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    ShowService showService;

    @GetMapping("/shows")
    public ResponseEntity<Object> getShows() {
        return new ResponseEntity<>(showService.getShows(), HttpStatus.OK);
    }

    @GetMapping("/quote")
    public ResponseEntity<Object> getQuotes() {

        return new ResponseEntity<>(showService.getRandomQuote(), HttpStatus.OK);
    }

    @GetMapping("/quotes")
    public ResponseEntity<Object> getQuotesByMovie(@PathParam("show") String show) {
        return new ResponseEntity<>(showService.getQuotesByMovie(show), HttpStatus.OK);
    }

    @PostMapping("/quote")
    public ResponseEntity<Object> addQuote(@RequestBody QuoteDto quote) {
        try {
            Quote q = showService.addQuote(quote);
            return new ResponseEntity<>(q, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Did not create", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/shows")
    public ResponseEntity<Object> addShow(@RequestBody Show show) {
        return new ResponseEntity<>(showService.addShow(show), HttpStatus.CREATED);
    }



}
