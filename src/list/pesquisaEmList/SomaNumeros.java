package list.pesquisaEmList;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> listaNumeros;

    public SomaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    // Adiciona um número à lista de números.
    public void adicionarNumero(int numero) {
        this.listaNumeros.add(numero);
    }

    // Calcula a soma de todos os números na lista e retorna o resultado.
    public int calcularSoma() {
        int soma = 0;

        for (int n: this.listaNumeros) {
            soma += n;
        }

        return soma;
    }

    public int encontrarMaiorNumero() {
       List<Integer> numerosOrdenados = this.listaNumeros;
       numerosOrdenados.sort(null);

       int maiorNumero = numerosOrdenados.get(numerosOrdenados.size() - 1);

       return  maiorNumero;
    }

    // Encontra o menor número na lista e retorna o valor.
    public int encontrarMenorNumero() {
        List<Integer> numerosOrdenados = this.listaNumeros;
        numerosOrdenados.sort(null);

        int menorNumero = numerosOrdenados.get(0);

        return  menorNumero;
    }

    public void exibirNumeros() {
        System.out.println(this.listaNumeros.toString());
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        // Adicionar números a lista
        somaNumeros.adicionarNumero(20);
        somaNumeros.adicionarNumero(19);
        somaNumeros.adicionarNumero(18);
        somaNumeros.adicionarNumero(17);
        somaNumeros.adicionarNumero(16);
        somaNumeros.adicionarNumero(15);
        somaNumeros.adicionarNumero(14);

        // calcular soma
        System.out.println("A soma dos números a lista é = "+ somaNumeros.calcularSoma());

        // Encontrar maior número
        System.out.println("O maior número é = "+ somaNumeros.encontrarMaiorNumero());

        // Encontrar menor número
        System.out.println("O menor número é = "+ somaNumeros.encontrarMenorNumero());

        // Imprimir os números da lista
        somaNumeros.exibirNumeros();
    }

}
