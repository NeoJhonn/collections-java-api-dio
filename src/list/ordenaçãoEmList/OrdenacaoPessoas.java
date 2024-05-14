package list.ordenaçãoEmList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {

    private List<Pessoa> listaPessoas;

    public OrdenacaoPessoas() {
        this.listaPessoas = new ArrayList<>();
    }

    // Adiciona uma pessoa à lista.
    public void adicionarPessoa(String nome, int idade, double altura) {
        this.listaPessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> listaOrdenadaPorIdade = this.listaPessoas;

        //ordenar lista por idade usando comparable
        Collections.sort(listaOrdenadaPorIdade);

        return listaOrdenadaPorIdade;
    }

    // Ordena as pessoas da lista por altura usando um Comparator personalizado.
    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> listaOrdenadaPorAltura = this.listaPessoas;

        // ordenar lista por Altura usando ComparablePorAltura
        // personalizados que criamos
        Collections.sort(listaOrdenadaPorAltura, new ComparatorPorAltura());

        return listaOrdenadaPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        // Adicionar pessoas na lista
        ordenacaoPessoas.adicionarPessoa("Nome 1", 20, 1.56);
        ordenacaoPessoas.adicionarPessoa("Nome 1", 30, 1.80);
        ordenacaoPessoas.adicionarPessoa("Nome 1", 25, 1.70);
        ordenacaoPessoas.adicionarPessoa("Nome 1", 17, 1.60);

        // imprimir a lista
        System.out.println(ordenacaoPessoas.listaPessoas);

        // Ordenar por idade
        System.out.println(ordenacaoPessoas.ordenarPorIdade());

        // ordenar por altura
        System.out.println(ordenacaoPessoas.ordenarPorAltura());
    }
}
