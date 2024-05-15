package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    // Adiciona uma palavra ao conjunto.
    public void adicionarPalavra(String palavra) {
        this.palavrasUnicas.add(palavra);
    }

    // Remove uma palavra do conjunto.
    public void removerPalavra(String palavra) {
        String palavraParaRemover = this.palavrasUnicas.stream().filter(p -> p.equalsIgnoreCase(palavra))
                .findFirst().orElse(null);

        if (palavraParaRemover != null) {
            this.palavrasUnicas.remove(palavraParaRemover);
        }
    }

    // Verifica se uma palavra está presente no conjunto.
    public boolean verificarPalavra(String palavra) {
        String palavraParaVerificar = this.palavrasUnicas.stream().filter(p -> p.equalsIgnoreCase(palavra))
                .findFirst().orElse(null);

        if (palavraParaVerificar != null) {
            return true;
        } else {
            return false;
        }
    }

    // Exibe todas as palavras únicas do conjunto.
    public void exibirPalavrasUnicas() {
        System.out.println(this.palavrasUnicas);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        // Adiconar palavras
        conjuntoPalavrasUnicas.adicionarPalavra("Jhonny");
        conjuntoPalavrasUnicas.adicionarPalavra("Miguel");
        conjuntoPalavrasUnicas.adicionarPalavra("Mylena");
        conjuntoPalavrasUnicas.adicionarPalavra("Whitney");
        conjuntoPalavrasUnicas.adicionarPalavra("Bruna");
        conjuntoPalavrasUnicas.adicionarPalavra("Letícia");

        // Exibir palavara únicas
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        // Remover uma palavra
        conjuntoPalavrasUnicas.removerPalavra("Letícia");
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        // verificar se uma palavra está presente no conjunto
        if (conjuntoPalavrasUnicas.verificarPalavra("João")) {
            System.out.println("A palavra 'João' está presente no conjunto");
        } else {
            System.out.println("A palavra 'João' não está presente no conjunto");

        }
    }
}
