package com.kuba.lab2_4.service;

import com.kuba.lab2_4.model.Show;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MovieService {

    private static final List<Show> shows = new ArrayList<>();

    public MovieService() {
        List<String> mv1 = new ArrayList<>();
        mv1.add("May the Force be with you!");
        mv1.add("Stop!");
        List<String> mv2 = new ArrayList<>();
        mv2.add("I'm the king of the world!");
        List<String> mv3 = new ArrayList<>();
        mv3.add("It's alive! It's alive!");
        List<String> mv4 = new ArrayList<>();
        mv4.add("I'll be back.");
        List<String> mv5 = new ArrayList<>();
        mv5.add("You're gonna need a bigger boat.");
        List<String> mv6 = new ArrayList<>();

        shows.add(new Show(1L,"Star Wars", 1977, "science-fiction", mv1));
        shows.add(new Show(2L,"Titanic", 1997, "romance", mv2));
        shows.add(new Show(3L, "Frankenstein", 1931, "science-fiction", mv3));
        shows.add(new Show(4L, "The Terminator,", 1984, "action", mv4));
        shows.add(new Show(5L, "Jaws", 1975, "horror", mv5));
        shows.add(new Show(6L, "The Adventures of Sherlock Holmes", 1939, "detective", mv6));
    }

    public List<Show> getMovies() {
        return shows;
    }

    public List<String> getQuotes() {
        List<String> quotes = new ArrayList<>();
        for(Show show : shows) {
            quotes.addAll(show.getQuotes());
        }
        return quotes;
    }

    public String getRandomQuote() {
        Random rand = new Random();
        List<String> quotes = new ArrayList<>();
        for(Show show : shows) {
            quotes.addAll(show.getQuotes());
        }
        return quotes.get(rand.nextInt(quotes.size()));
    }

    public List<String> getQuotesByMovie(String showName) {
        for(Show show: shows){
            if(show.getName().toLowerCase().equals(showName)) return show.getQuotes();
        }
        return null;
    }



}
