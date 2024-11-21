package com.rocketseat.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }

        return livrosDisponiveis;
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }

        return null;
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void fazerEmprestimoDeLivro(Livro livro, String nomeUsuario) {
        if (livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, nomeUsuario);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }
    }
}
