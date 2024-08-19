package br.com.quote.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class QuoteService {

    private static final String QUOTE_API_URL = "https://economia.awesomeapi.com.br/json/all/USD-BRL";
    private final RestClient restClient;

    public QuoteService() {
        this.restClient = RestClient.create();
    }

    public String searchQuote() {
        return restClient.get().uri(QUOTE_API_URL)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json"
                ).retrieve().body(String.class);
    }

    public static void main(String[] args) {
        QuoteService quoteService = new QuoteService();
        System.out.println(quoteService.searchQuote());
    }

}





