package com.datalyze.mcpspring.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/ia")
public class GeminiController {

    private final ChatClient chatClient;

    public GeminiController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/preguntar")
    public Map<String, String> preguntar(
            @RequestParam(defaultValue = "Hola, Gemini") String mensaje) {

        String respuesta = chatClient.prompt()
                .user(mensaje)
                .call()
                .content();

        return Map.of("respuesta", respuesta);
    }
}
