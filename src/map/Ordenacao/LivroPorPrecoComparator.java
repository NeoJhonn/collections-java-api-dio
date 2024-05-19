package map.Ordenacao;

import java.util.Comparator;
import java.util.Map;

public class LivroPorPrecoComparator implements Comparator<String> {
    private final Map<String, Livro> map;

    public LivroPorPrecoComparator(Map<String, Livro> map) {
        this.map = map;
    }


    @Override
    public int compare(String link1, String link2) {
        Double preco1 = map.get(link1).getPreco();
        Double preco2 = map.get(link2).getPreco();
        return preco1.compareTo(preco2);
    }
}
