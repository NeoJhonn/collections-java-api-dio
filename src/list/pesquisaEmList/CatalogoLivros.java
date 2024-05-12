package list.pesquisaEmList;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    List<Livro> livros;

    public CatalogoLivros() {
        this.livros = new ArrayList<>();
    }

    // Adiciona um livro ao catálogo.
    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        this.livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosEncontrados = null;
        if (!this.livros.isEmpty())
        livrosEncontrados = this.livros.stream().filter(livro -> livro.getAutor()
                .equalsIgnoreCase(autor)).toList();

        return livrosEncontrados;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosEncontrados = null;
        if (!this.livros.isEmpty())
            livrosEncontrados = this.livros.stream().filter(livro -> livro.getAnoPublicacao() >= anoInicial
            && livro.getAnoPublicacao() <= anoFinal).toList();

        return livrosEncontrados;
    }

    // Pesquisa livros por título e retorna o primeiro livro encontrado.
    public Livro pesquisarPorTitulo(String titulo) {
        Livro livro = null;

        if (!livros.isEmpty())
        livro = this.livros.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst().orElse(null);

        return livro;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        // adicionar livros
        catalogoLivros.adicionarLivro("Título 1", "Autor 1", 2020);
        catalogoLivros.adicionarLivro("Título 1", "Autor 2", 2021);
        catalogoLivros.adicionarLivro("Título 2", "Autor 2", 2022);
        catalogoLivros.adicionarLivro("Título 3", "Autor 3", 2023);
        catalogoLivros.adicionarLivro("Título 4", "Autor 4", 1994);

        // pesquisar por autor
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));

        // pesquizar por intervalo de anos
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(1994, 2021));

        // pesquizar pelo título
        System.out.println(catalogoLivros.pesquisarPorTitulo("Título 4"));

    }


}
