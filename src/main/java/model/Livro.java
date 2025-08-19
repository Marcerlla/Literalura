package com.literalura.model;

import jakarta.persistence.*;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private Integer downloads;

    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    public Livro() {}

    public Livro(String titulo, String idioma, Integer downloads, Autor autor) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.downloads = downloads;
        this.autor = autor;
    }

    // getters e setters
}
