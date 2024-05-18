package set.Ordenacao;

import java.util.*;

public class CadastroProdutos {

    private Set<Produto> produtosSet;

    public CadastroProdutos() {
        this.produtosSet = new HashSet<>();
    }

    // Adiciona um produto ao cadastro
    public void adicionarProduto(String nome, long codigo, double preco, int quantidade) {
        this.produtosSet.add(new Produto(nome, codigo, preco, quantidade));
    }

    // Exibe todos os produtos do cadastro em ordem alfabética pelo nome.
    public Set<Produto> exibirProdutosPorNome() {
        // Aqui usando o TreeSet, ele automaticamente passando um Set
        // como parâmetro ele vai criar um novo produtoSet ordenado pelo
        // nome pois tenho o Comparable implementado na classe Produto
        // Para Ordenar uso o TreeSet<>, que é outra sub classe de Set
        return new TreeSet<>(this.produtosSet);
    }

    // Exibe todos os produtos do cadastro em ordem crescente de preço.
    public Set<Produto> exibirProdutosPorPreco() {
        // Aqui usando o TreeSet, ele automaticamente passando um Set
        // como parâmetro ele vai criar um novo produtoSet ordenado pelo
        // preço pois tenho o Comparator ComparatorPorPreco criado para a classe Produto
        // Para Ordenar uso o TreeSet<>, que é outra sub classe de Set
        // passo o Comparator que criei para ordenar
        Set<Produto> produtosPorPrecoSet = new TreeSet<>(new ComparatorPorPreco());

        // Adiciono produtosSet em produtosPorPrecoSet pois este esta vazio.
        produtosPorPrecoSet.addAll(this.produtosSet);

        return produtosPorPrecoSet;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        // Adicionando Produtos
        cadastroProdutos.adicionarProduto("Frango", 001, 15.5, 20);
        cadastroProdutos.adicionarProduto("Arroz", 002, 10.5, 15);
        cadastroProdutos.adicionarProduto("Goiaba", 003, 18.5, 8);
        cadastroProdutos.adicionarProduto("Manteiga", 004, 17.5, 56);
        cadastroProdutos.adicionarProduto("Leite", 007, 11.5, 23);
        cadastroProdutos.adicionarProduto("Pão", 006, 5.5, 35);
        cadastroProdutos.adicionarProduto("Carne", 005, 7.5, 78);

        // Exibir produtos
        System.out.println("Produtos: " + cadastroProdutos.produtosSet);

        System.out.println("");

        // Exibir produtos por nome
        System.out.println("Produtos por Nome: " + cadastroProdutos.exibirProdutosPorNome());

        System.out.println("");

        // Exibir produtos por preço
        System.out.println("Produtos por Preço: " + cadastroProdutos.exibirProdutosPorPreco());
    }

}
