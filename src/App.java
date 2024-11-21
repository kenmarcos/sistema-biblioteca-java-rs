import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.rocketseat.biblioteca.Autor;
import com.rocketseat.biblioteca.Biblioteca;
import com.rocketseat.biblioteca.Livro;

public class App {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Adicionando autores
        Autor autor1 = new Autor(1, "Autor Teste1", LocalDate.of(1965, 11, 18));
        Autor autor2 = new Autor(1, "Autor Teste2", LocalDate.of(1957, 9, 7));

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        // Adicionando livros
        Livro livro1 = new Livro(1, "Livro Teste1", autor1);
        Livro livro2 = new Livro(2, "Livro Teste2", autor2);
        Livro livro3 = new Livro(3, "Livro Teste3", autor1);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        while (true) {
            System.out.println("Deseja ver os livros disponíveis? (S/N)");
            String resposta = scanner.nextLine().toUpperCase();

            if (resposta.equals("S")) {
                List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();

                if (livrosDisponiveis.isEmpty()) {
                    System.out.println("Nenhum livro disponível para empréstimo.");
                } else {
                    System.out.println("Livros disponíveis para empréstimo:");
                    for (Livro livro : livrosDisponiveis) {
                        System.out.println("- " + livro.getId() + ": " + livro.getTitulo());
                    }

                    System.out.println("Digite o ID do livro que deseja empréstimo: ");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroEscolhido = biblioteca.buscarLivroPorId(idLivro);

                    if (livroEscolhido != null && livroEscolhido.isDisponivel()) {
                        System.out.println("Digite seu nome: ");
                        String nomeUsuario = scanner.nextLine();

                        biblioteca.fazerEmprestimoDeLivro(livroEscolhido, nomeUsuario);
                        System.out.println(
                                "O livro " + livroEscolhido.getTitulo() + " foi emprestado para " + nomeUsuario);
                    } else {
                        System.out.println("Livro não encontrado ou indisponível para empréstimo.");
                    }
                }
            } else if (resposta.equals("N")) {
                System.out.println("Obrigado por utilizar nossa biblioteca!");
                break;
            } else {
                System.out.println("Opção inválida. Por favor, digite 'S' ou 'N'.");
            }
        }

        scanner.close();
    }
}
