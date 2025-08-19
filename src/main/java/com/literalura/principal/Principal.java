package com.literalura;

import com.literalura.service.LivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    private final LivroService livroService;

    public Principal(LivroService livroService) {
        this.livroService = livroService;
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU LITERALURA =====");
            System.out.println("1 - Buscar livro por título");
            System.out.println("2 - Listar todos os livros");
            System.out.println("3 - Listar autores");
            System.out.println("4 - Listar autores vivos em determinado ano");
            System.out.println("5 - Listar quantidade de livros por idioma");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o título do livro: ");
                    String titulo = sc.nextLine();
                    livroService.buscarLivroPorTitulo(titulo);
                }
                case 2 -> livroService.listarLivros();
                case 3 -> livroService.listarAutores();
                case 4 -> {
                    System.out.print("Digite o ano: ");
                    int ano = sc.nextInt();
                    livroService.listarAutoresVivos(ano);
                }
                case 5 -> {
                    System.out.print("Digite o idioma (ex: en, pt, es): ");
                    String idioma = sc.nextLine();
                    livroService.listarLivrosPorIdioma(idioma);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}
