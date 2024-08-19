package br.com.quote.controller;

import br.com.quote.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/quote")
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping
    public ResponseEntity<String> search() {
        return ResponseEntity.ok(quoteService.searchQuote());
    }

}
