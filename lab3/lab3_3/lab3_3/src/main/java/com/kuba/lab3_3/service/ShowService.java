package com.kuba.lab3_3.service;

import com.kuba.lab3_3.dto.QuoteDto;
import com.kuba.lab3_3.model.Quote;
import com.kuba.lab3_3.model.Show;
import com.kuba.lab3_3.repository.QuoteRepository;
import com.kuba.lab3_3.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    QuoteRepository quoteRepository;

    public List<Show> getShows() {
        return showRepository.findAll();
    }

    public Quote getRandomQuote() {
        Random rand = new Random();
        List<Quote> quotes = quoteRepository.findAll();
        return quotes.get(rand.nextInt(quotes.size()));
    }

    public List<Quote> getQuotesByMovie(String showName) {
        Optional<Show> show = showRepository.findShowByName(showName);
        List<Quote> quotes = quoteRepository.findAll();
        if (show.isEmpty()) return new ArrayList<>();
        quotes = quotes.stream().filter(q -> q.getShow().getName().equals(showName)).toList();
        return quotes;
    }

    public Show addShow(Show show) {
        showRepository.save(show);
        return show;
    }

    public Quote addQuote(QuoteDto quoteDto) throws Exception {
        Optional<Show> show = showRepository.findById(quoteDto.showId);
        if (show.isEmpty()) throw new Exception();
        Quote quote = new Quote(quoteDto.quoteText, show.get());
        quoteRepository.save(quote);
        return quote;
    }


}
