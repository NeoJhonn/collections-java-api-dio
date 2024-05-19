package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        this.estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        System.out.println(this.estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0;

        if (!this.estoqueProdutosMap.isEmpty()) {
             valorTotal = this.estoqueProdutosMap.values().stream()
                     .mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();
        }

        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto maisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if (!this.estoqueProdutosMap.isEmpty()) {
            for (Produto p : this.estoqueProdutosMap.values()) {
                if (p.getPreco() > maiorPreco) {
                    maisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }

        return maisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto maisBarato = null;

        if (!this.estoqueProdutosMap.isEmpty()) {
            for (Produto p: this.estoqueProdutosMap.values()) {
                if (maisBarato == null) {
                    maisBarato = p;
                } else {
                    if (p.getPreco() < maisBarato.getPreco()) {
                        maisBarato = p;
                    }
                }
            }
        }

        return maisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto maiorQuantidade = null;
        double maiorTotal = Double.MIN_VALUE;

        if (!this.estoqueProdutosMap.isEmpty()) {
            for (Produto p : this.estoqueProdutosMap.values()) {
                double tempTotal = p.getPreco() * p.getQuantidade();
                if(tempTotal > maiorTotal) {
                    maiorQuantidade = p;
                    maiorTotal = tempTotal;
                }
            }
        }

        return maiorQuantidade;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        // Adicionar produtos
        estoqueProdutos.adicionarProduto(322l, "Produto1", 5, 10);
        estoqueProdutos.adicionarProduto(324l, "Produto2", 7, 5);
        estoqueProdutos.adicionarProduto(327l, "Produto3", 8, 7);
        estoqueProdutos.adicionarProduto(329l, "Produto4", 9, 12);
        estoqueProdutos.adicionarProduto(326l, "Produto5", 11, 24);
        estoqueProdutos.adicionarProduto(328l, "Produto6", 15, 18);

        // Exibir produtos
        estoqueProdutos.exibirProdutos();

        System.out.println();

        // Valor total estoque
        System.out.println("Total estoque = " + estoqueProdutos.calcularValorTotalEstoque());

        System.out.println();

        // Produto mais caro
        System.out.println("Produto mais caro é = " + estoqueProdutos.obterProdutoMaisCaro());

        System.out.println();

        // Produto mais barato
        System.out.println("Produto mais barato é = " + estoqueProdutos.obterProdutoMaisBarato());

        System.out.println();

        // Retorna o produto que está em maior quantidade no estoque, considerando o valor total de
        // cada produto (quantidade * preço).
        System.out.println("Produto maior quantidade no estoque = " +
                estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
