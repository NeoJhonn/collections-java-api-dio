package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> listaItems;

    public CarrinhoDeCompras() {
        this.listaItems = new ArrayList<>();
    }

    // Adiciona um item ao carrinho com o nome, preço e quantidade especificados.
    public void adicionarItem(String nome, double preco, int quantidade) {
        this.listaItems.add(new Item(nome, preco, quantidade));
    }

    // Remove um item do carrinho com base no seu nome.
    public void removerItem(String nome) {
       List<Item> itemsParaRemover = this.listaItems.stream().filter(item -> item.getNome()
               .equalsIgnoreCase(nome)).toList();

       if (itemsParaRemover != null)
           this.listaItems.removeAll(itemsParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;

        for (Item item : this.listaItems) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }

        return valorTotal;
    }

    public void exibirItens() {
        System.out.println(this.listaItems);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        // Imprimir valor total do carrinho
        System.out.println("Valor total do carrinho de compras = "+ carrinho.calcularValorTotal());

        // Adicionar items no carrinho
        carrinho.adicionarItem("Bolacha", 8, 2);
        carrinho.adicionarItem("Bolacha", 8, 3);
        carrinho.adicionarItem("Sabonete", 4, 2);
        System.out.println("Valor total do carrinho de compras = "+ carrinho.calcularValorTotal());
        carrinho.exibirItens();

        // Remover item do carrinho
        carrinho.removerItem("Sabonete");
        carrinho.exibirItens();
    }


}
