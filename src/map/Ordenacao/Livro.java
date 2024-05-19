package map.Ordenacao;

public class Livro {

    private String título;
    private String autor;
    private double preco;

    public Livro(String título, String autor, double preco) {
        this.título = título;
        this.autor = autor;
        this.preco = preco;
    }

    public String getTítulo() {
        return título;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "{" +
                "título='" + título + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                '}';
    }
}
