package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ListaTarefas {

    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        this.tarefaSet.add(new Tarefa(descricao, false));
    }

    // Remove uma tarefa do Set de acordo com a descrição, se estiver presente.
    public Tarefa removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = this.tarefaSet.stream().filter(t -> t.getDescricao() == descricao)
                                               .findFirst().orElse(null);

        if (!tarefaParaRemover.equals(null)) {
            this.tarefaSet.remove(tarefaParaRemover);
        }

        return tarefaParaRemover;
    }

    // Exibe todas as tarefas da lista de tarefas.
    public void exibirTarefas() {
        System.out.println(this.tarefaSet);
    }

    // Conta o número total de tarefas na lista de tarefas.
    public int contarTarefas() {
        return this.tarefaSet.size();
    }

    // Retorna um Set com as tarefas concluídas.
    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluídas = this.tarefaSet.stream().filter(t -> t.isConcluida() == true)
                .collect(Collectors.toSet());


        return  tarefasConcluídas;
    }


    // Retorna um Set com as tarefas pendentes.
    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = this.tarefaSet.stream().filter(t -> t.isConcluida() == false)
                .collect(Collectors.toSet());


        return  tarefasPendentes;
    }

    // Marca uma tarefa como concluída de acordo com a descrição.
    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa t: this.tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(true);
                break;
            }
        }
    }

    // Marca uma tarefa como pendente de acordo com a descrição.
    public void marcarTarefaPendente(String descricao) {
        for (Tarefa t: this.tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(false);
                break;
            }
        }
    }

    // Remove todas as tarefas da lista de tarefas.
    public void limparListaTarefas() {
        this.tarefaSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionar Tarefas
        listaTarefas.adicionarTarefa("Correr");
        listaTarefas.adicionarTarefa("banho");
        listaTarefas.adicionarTarefa("estudar");
        listaTarefas.adicionarTarefa("Malhar");
        listaTarefas.adicionarTarefa("Dormir");

        // Exibir tarefas
        listaTarefas.exibirTarefas();

        // Remover tarefa
        listaTarefas.removerTarefa("Dormir");

        // Exibir tarefas
        listaTarefas.exibirTarefas();

        // Contar tarefas
        System.out.println("Há um total de "+ listaTarefas.contarTarefas() +" tarefas." );

        // Marcar tarefa concluída
        listaTarefas.marcarTarefaConcluida("Correr");
        listaTarefas.marcarTarefaConcluida("banho");

        // obter tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        // Obter tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        // limpar lista de tarefas
        listaTarefas.limparListaTarefas();

        // Exibir tarefas
        listaTarefas.exibirTarefas();

    }

}
