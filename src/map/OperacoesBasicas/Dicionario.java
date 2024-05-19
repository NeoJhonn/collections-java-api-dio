package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> palavrasMap;

    public Dicionario() {
        this.palavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        this.palavrasMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!this.palavrasMap.isEmpty()) {
            this.palavrasMap.remove(palavra);
        }
    }

    public void exibirPalavras() {
        System.out.println(this.palavrasMap);
    }

    public String pesquisarPorPalavra(String palavra) {
        String definicao = null;

        if (!this.palavrasMap.isEmpty()) {
            definicao = this.palavrasMap.get(palavra);
        }

        return definicao;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        // Adicionar palavras
        dicionario.adicionarPalavra("Palavra1", "definição1");
        dicionario.adicionarPalavra("Palavra2", "definição2");
        dicionario.adicionarPalavra("Palavra3", "definição3");
        dicionario.adicionarPalavra("Palavra4", "definição4");
        dicionario.adicionarPalavra("Palavra5", "definição5");

        // Exibir palavras
        dicionario.exibirPalavras();

        System.out.println();

        // Remover palavra
        dicionario.removerPalavra("Palavra3");

        // Exibir palavras
        dicionario.exibirPalavras();

        System.out.println();

        // Pesquisar por palavra
        System.out.println("Palavra5 = " + dicionario.pesquisarPorPalavra("Palavra5"));


    }


}
