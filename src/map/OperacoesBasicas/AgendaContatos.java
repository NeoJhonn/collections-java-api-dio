package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    private Map<String, Integer> agendaContatosMap;

    public AgendaContatos() {
        this.agendaContatosMap = new HashMap<>();
    }

    // Adiciona um contato à agenda, associando o nome do contato ao
    // número de telefone correspondente.
    public void adicionarContato(String nome, Integer telefone) {
        // Em Map o método put(K, V) serve tanto para adicionar quanto
        // para atualizar
        this.agendaContatosMap.put(nome, telefone);
    }

    // Remove um contato da agenda, dado o nome do contato.
    public void removerContato(String nome) {
        if (!this.agendaContatosMap.isEmpty()) {
            this.agendaContatosMap.remove(nome);
        }
    }

    // Exibe todos os contatos da agenda, mostrando o nome
    // e o número de telefone de cada contato.
    public void exibirContatos() {
        System.out.println(this.agendaContatosMap);
    }

    // Pesquisa um contato pelo nome e retorna o número de telefone
    // correspondente.
    public Integer pesquisarPorNome(String nome) {
        Integer telefone = null;

        if (!this.agendaContatosMap.isEmpty()) {
            telefone =  this.agendaContatosMap.get(nome);
        }

        return telefone;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        // Adicionar contatos
        agendaContatos.adicionarContato("Jhonny", 78978789);
        agendaContatos.adicionarContato("Mylena", 71741722);
        agendaContatos.adicionarContato("Letícia", 2852828);
        agendaContatos.adicionarContato("Miguel", 39369944);
        agendaContatos.adicionarContato("Whitney", 7575757);
        agendaContatos.adicionarContato("Ronaldo", 37532537);

        // Exibir contatos
        agendaContatos.exibirContatos();

        System.out.println();

        // Atulalizar o telefone de "Jhonny"
        // Em Map o método put(K, V) serve tanto
        // para adicionar quanto para atualizar.
        agendaContatos.adicionarContato("Jhonny", 5555555);


        // Exibir contatos
        agendaContatos.exibirContatos();

        System.out.println();


        // Remover contato
        agendaContatos.removerContato("Ronaldo");

        System.out.println();


        // Exibir contatos
        agendaContatos.exibirContatos();

        System.out.println();


        // Pesquisar por nome
        System.out.println("Jhonny = " + agendaContatos.pesquisarPorNome("Jhonny"));
    }
}
