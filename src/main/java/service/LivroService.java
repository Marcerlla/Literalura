package com.literalura.service;

import com.literalura.dto.DadosLivro;
import com.literalura.model.Autor;
import com.literalura.model.Livro;
import com.literalura.repository.AutorRepository;
import com.literalura.repository.LivroRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void buscarLivroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");
        String json = ConsumoApi.obterDados(url);

        try {
            JsonNode root = new com.fasterxml.jackson.databind.ObjectMapper().readTree(json);
            JsonNode livroJson = root.get("results").get(0);

            DadosLivro dados = ConverteDados.obterDados(livroJson.toString(), DadosLivro.class);

            Autor autor = new Autor(
                    dados.autores().get(0).nome(),
                    dados.autores().get(0).anoNascimento(),
                    dados.autores().get(0).anoFalecimento()
            );

            Livro livro = new Livro(
                    dados.titulo(),
                    dados.idiomas().get(0),
                    dados.downloads(),
                    autor
            );

            autorRepository.save(autor);
            livroRepository.save(livro);

            System.out.println("Livro salvo: " + livro.getTitulo());

        } catch (Exception e) {
            System.out.println("Erro ao processar livro: " + e.getMessage());
        }
    }

    public void listarLivros() {
        livroRepository.findAll().forEach(l ->
                System.out.println(l.getTitulo() + " - " + l.getIdioma())
        );
    }

    public void listarAutores() {
        autorRepository.findAll().forEach(a ->
                System.out.println(a.getNome() + " (" + a.getAnoNascimento() + " - " + a.getAnoFalecimento() + ")")
        );
    }

    public void listarAutoresVivos(int ano) {
        autorRepository.findAll().stream()
                .filter(a -> a.getAnoNascimento() != null && a.getAnoNascimento() <= ano &&
                        (a.getAnoFalecimento() == null || a.getAnoFalecimento() > ano))
                .forEach(a -> System.out.println(a.getNome()));
    }

    public void listarLivrosPorIdioma(String idioma) {
        livroRepository.findByIdioma(idioma).forEach(l ->
                System.out.println(l.getTitulo() + " (" + idioma + ")")
        );
    }
}
