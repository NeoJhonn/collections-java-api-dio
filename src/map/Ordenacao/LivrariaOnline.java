package map.Ordenacao;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LivrariaOnline {

    private Map<String, Livro> livrosMap;

    public LivrariaOnline() {
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        this.livrosMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        if (!this.livrosMap.isEmpty()) {
            for (Map.Entry<String, Livro> entry: this.livrosMap.entrySet()) {
                Livro livro = entry.getValue();
                String link = entry.getKey();

                if (livro.getTítulo().equalsIgnoreCase(titulo)) {
                    this.livrosMap.remove(link);
                }
            }
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        Map<String, Livro> livrosPorPrecoMap = new TreeMap<>(new LivroPorPrecoComparator(this.livrosMap));

        livrosPorPrecoMap.putAll(this.livrosMap);

        return livrosPorPrecoMap;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new HashMap<>();

        if (!this.livrosMap.isEmpty()) {
            for (Map.Entry<String, Livro> entry : this.livrosMap.entrySet()) {
                Livro livro = entry.getValue();
                String link = entry.getKey();
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.put(link, livro);
                }
            }
        }

        return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro() {
        Livro livroMaisCaro = null;
        Double maiorPreco = Double.MIN_VALUE;

        if (!this.livrosMap.isEmpty()) {
            for (Livro l : this.livrosMap.values()) {
                if (l.getPreco() > maiorPreco) {
                    livroMaisCaro = l;
                    maiorPreco = l.getPreco();
                }


            }
        }

        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato() {
        Livro livroMaisBarato = null;
        Double menorPreco = Double.MAX_VALUE;

        if (!this.livrosMap.isEmpty()) {
            for (Livro l : this.livrosMap.values()) {
                if (l.getPreco() < menorPreco) {
                    livroMaisBarato = l;
                    menorPreco = l.getPreco();
                }


            }
        }

        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        // Adicionar livros
        livrariaOnline.adicionarLivro("978-3-16-148410-0", "Título 1", "Autor 1", 13.5);
        livrariaOnline.adicionarLivro("978-3-16-148410-1", "Título 2", "Autor 1", 15.5);
        livrariaOnline.adicionarLivro("978-3-16-148410-2", "Título 3", "Autor 1", 18.5);
        livrariaOnline.adicionarLivro("978-3-16-148410-3", "Título 4", "Autor 4", 20.5);
        livrariaOnline.adicionarLivro("978-3-16-148410-4", "Título 5", "Autor 5", 30.5);
        livrariaOnline.adicionarLivro("978-3-16-148410-5", "Título 6", "Autor 6", 7.5);

        // Exibir livros por preço
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());

        System.out.println();

        // Exivir livros escritos por um dado autor
        System.out.println("Lista de livro por autor: "+ livrariaOnline.pesquisarLivrosPorAutor("Autor 1"));

        System.out.println();

        // Obter o livro mais caro
        System.out.println("O livro mais caro é : "+ livrariaOnline.obterLivroMaisCaro());

        System.out.println();

        // Obter o livro mais barato
        System.out.println("O livro mais barato é : "+ livrariaOnline.obterLivroMaisBarato());
    }

}
