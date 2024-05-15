package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> conjuntoConvidados;

    public ConjuntoConvidados() {
        conjuntoConvidados = new HashSet<>();
    }

    // Adiciona um convidado ao conjunto.
    public void adicionarConvidado(String nome, int codigoConvite) {
        this.conjuntoConvidados.add(new Convidado(nome, codigoConvite));
    }

    // Remove um convidado do conjunto com base no código do convite.
    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = this.conjuntoConvidados.stream().filter(c ->
                c.getCodigoConvite() == codigoConvite).findFirst().orElse(null);

        if (convidadoParaRemover != null) {
            this.conjuntoConvidados.remove(convidadoParaRemover);
        }
    }

    // Conta o número total de convidados no Set.
    public  int contarConvidados() {
        return this.conjuntoConvidados.size();
    }

    // Exibe todos os convidados do conjunto.
    public void exibirConvidados() {
        System.out.println(this.conjuntoConvidados);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        // adicionar convidadeos no Set
        conjuntoConvidados.adicionarConvidado("Convidado1", 1234);
        conjuntoConvidados.adicionarConvidado("Convidado2", 1235);
        // esse convidado não será adicionado pois defini que o codigo convite é
        // único, na classe convidado Criei com o Override os métodos equal() e
        // hashCode() para verificar se tem códigos duplicados, pois definimos que o
        // codigoConvite será um valor único no conjunto
        conjuntoConvidados.adicionarConvidado("Convidado3", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado4", 1237);

        // exibir número de convidados
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados dentro do Set" + "\n");

        // remover Convidade pelo código do convite
        conjuntoConvidados.removerConvidadoPorCodigoConvite(1237);
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados dentro do Set" + "\n");

        // imprimir convidados
        conjuntoConvidados.exibirConvidados();
    }
}
