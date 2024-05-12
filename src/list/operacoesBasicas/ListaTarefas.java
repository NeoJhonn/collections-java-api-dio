package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {

    private List<Tarefa> listaTarefas;

    public ListaTarefas() {
        listaTarefas = new ArrayList<Tarefa>();
    }

    // Adiciona uma nova tarefa à lista com a descrição fornecida.
    public void adicionarTarefa(String descricao) {
        this.listaTarefas.add(new Tarefa(descricao));
    }

    //Remove uma tarefa da lista com base em sua descrição.
    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = this.listaTarefas.stream().filter(t ->
                        t.getDecricao().equalsIgnoreCase(descricao))
                        .toList();

        if (tarefasParaRemover != null)
        this.listaTarefas.removeAll(tarefasParaRemover);
    }

    // Retorna o número total de tarefas na lista.
    public int obterNumeroTotalTarefas() {
        return this.listaTarefas.size();
    }

    // Retorna uma lista contendo a descrição de todas as tarefas na lista.
    public void obterDescricoesTarefas() {
        System.out.println(this.listaTarefas);
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        // imprimir tamanho da lista
        System.out.println("Número de tarefas = "+ listaTarefas.obterNumeroTotalTarefas());

        // adicionar tarefa
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 3");
        System.out.println("Número de tarefas = "+ listaTarefas.obterNumeroTotalTarefas());

        // remover tarefas
        listaTarefas.removerTarefa("Tarefa 3");
        System.out.println("Número de tarefas = "+ listaTarefas.obterNumeroTotalTarefas());

        // imprimir tarefas
        listaTarefas.obterDescricoesTarefas();
    }



}
