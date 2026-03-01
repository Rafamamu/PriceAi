package com.gmail.rafaroga46.PriceAi.controller;

import com.gmail.rafaroga46.PriceAi.service.OpenAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AiResponseController {

    private OpenAiService openAiService;

    public AiResponseController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @GetMapping
    public Mono<ResponseEntity<String>> generateResponseAi() {
        return  openAiService.generateResponseAi();
    }
}
