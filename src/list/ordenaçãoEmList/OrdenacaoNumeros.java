package list.ordenaçãoEmList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {

    private List<Integer> listaNumeros;

    public OrdenacaoNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    // Adiciona um número à lista.
    public void adicionarNumero(int numero) {
       this.listaNumeros.add(numero);
    }

    // Ordena os números da lista em ordem ascendente usando a interface Comparable e a class Collections.
    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendentes = this.listaNumeros;

        // Ordenar números em orderm ascendente
        Collections.sort(numerosAscendentes);

        return numerosAscendentes;
    }

    // Ordena os números da lista em ordem descendente usando um Comparable e a class Collections.
    public List<Integer> ordenarDescendente() {
        List<Integer> numerosDescendentes = this.listaNumeros;

        // Ordenar números em orderm Descendentes
        Collections.sort(numerosDescendentes, Collections.reverseOrder());

        return numerosDescendentes;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        // Adicionar números na lista
        ordenacaoNumeros.adicionarNumero(7);
        ordenacaoNumeros.adicionarNumero(6);
        ordenacaoNumeros.adicionarNumero(8);
        ordenacaoNumeros.adicionarNumero(10);
        ordenacaoNumeros.adicionarNumero(9);

        // imprimir lista sem ordenação
        System.out.println(ordenacaoNumeros.listaNumeros+ "\n");

        // Ordenar Ascendente
        System.out.println(ordenacaoNumeros.ordenarAscendente()+ "\n");

        // Ordenar descendente
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }
}
