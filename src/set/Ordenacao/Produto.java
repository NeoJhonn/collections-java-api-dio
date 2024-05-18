package set.Ordenacao;

import java.util.Objects;

public class Produto implements Comparable<Produto> {

    private String nome;
    private long codigo;
    private double preco;
    private int quantidade;

    public Produto(String nome, long codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Com os métodos hashcode() e equals() implementados na hora de adicionar um
    // Produto no HashSet só serão adicionados Produtos com códigos únicos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return getCodigo() == produto.getCodigo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    @Override
    public String toString() {
        return "{"
                + nome +
                ", código= " + codigo +
                ", preço= " + preco +
                ", quantidade= " + quantidade +
                '}';
    }

    // na hora de ordenar vai comparar e ordenar pelo nome em ordem alfabética
    @Override
    public int compareTo(Produto p) {
        return this.nome.compareToIgnoreCase(p.getNome());
    }
}
