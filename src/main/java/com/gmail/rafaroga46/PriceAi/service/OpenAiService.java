package com.gmail.rafaroga46.PriceAi.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class OpenAiService {

    private final WebClient webClient;
    private String apiKey = System.getenv("OPENAI_API_KEY");

    public OpenAiService(WebClient webClient) {
        this.webClient = webClient;
    }



    public Mono<String> generateResponseAi() {

        String prompt = "Preciso que você me envie " +
                "os produtos que eu te mandar baseado no meu banco de dadoscom o melhor preço!?";

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4.1",
                "reasoning", Map.of("effort", "low"),
                "input", List.of(
                        Map.of("role", "system", "content", "Voçê é um buscador de melhores preços"),
                        Map.of("role", "user", "content", prompt)
                )
        );

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer" + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var output = (List<Map<String, Object>>) response.get("output");
                    if (output != null && !output.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) output.get(0).get("message");

                        return message.get("content").toString();
                    }

                    return "Nenhuma receita foi gerada.";
                });
    }
}
