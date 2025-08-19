package com.literalura.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON: " + e.getMessage());
        }
    }
}
