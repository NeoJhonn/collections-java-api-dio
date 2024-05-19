package map.Pesquisa;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> contagemMap;

    public ContagemPalavras() {
        this.contagemMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        this.contagemMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!this.contagemMap.isEmpty()) {
            this.contagemMap.remove(palavra);
        }
    }

    public void exibirContagemPalavras() {
        System.out.println(this.contagemMap);
    }

    public String encontrarPalavraMaisFrequente() {
        int maiorContagem = Integer.MIN_VALUE;
        String palavra = "";

        if (!this.contagemMap.isEmpty()) {
            for (Integer c: this.contagemMap.values()) {
                if (c > maiorContagem) {
                    maiorContagem = c;
                }
            }

            for (String p: this.contagemMap.keySet()) {
                if (this.contagemMap.get(p) == maiorContagem) {
                    palavra = p;
                }
            }
        }


        return "Palavara mais frequënte= "+ palavra +", contagem= " + maiorContagem;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        // Adicionar palavras
        contagemPalavras.adicionarPalavra("Palavra1", 10);
        contagemPalavras.adicionarPalavra("Palavra2", 13);
        contagemPalavras.adicionarPalavra("Palavra3", 25);
        contagemPalavras.adicionarPalavra("Palavra5", 50);
        contagemPalavras.adicionarPalavra("Palavra4", 58);

        // Exibir contagem palavras
        contagemPalavras.exibirContagemPalavras();

        System.out.println();

        // Remover palavra
        contagemPalavras.removerPalavra("Palavra1");
        // Exibir contagem palavras
        contagemPalavras.exibirContagemPalavras();

        System.out.println();

        // Exibir palavra mais frequënte
        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());

    }
}
