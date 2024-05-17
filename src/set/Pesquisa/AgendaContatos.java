package set.Pesquisa;

import javax.sound.midi.Soundbank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> conjuntoContatos;

    public AgendaContatos() {
        this.conjuntoContatos = new HashSet<>();
    }

    // Adiciona um contato à agenda.
    public void adicionarContato(String nome, int numero) {
        this.conjuntoContatos.add(new Contato(nome, numero));
    }

    // Exibe todos os contatos da agenda.
    public void exibirContatos() {
        System.out.println(this.conjuntoContatos);
    }

    // Pesquisa contatos pelo nome e retorna uma conjunto com os contatos encontrados.
    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();

        for (Contato c: this.conjuntoContatos) {
            if(c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }

        return contatosPorNome;
    }

    // Atualiza o número de telefone de um contato específico.
    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        for (Contato c: this.conjuntoContatos) {
            if(c.getNome().equalsIgnoreCase(nome)) {
                c.setTelefone(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        // Adicionar contatos
        agendaContatos.adicionarContato("Jhonny", 12332121);
        agendaContatos.adicionarContato("Miguel", 54444987);
        agendaContatos.adicionarContato("Jhonny Azevedo", 65456564);
        agendaContatos.adicionarContato("Jhonny Dio", 878798);
        agendaContatos.adicionarContato("Mylena Moraes", 78789979);

        // Exibir contatos
        agendaContatos.exibirContatos();

        // Pesquizar por Nome
        System.out.println(agendaContatos.pesquisarPorNome("Miguel"));

        // Atualizar contato
        System.out.println("Contato Atualizado" + agendaContatos.atualizarNumeroContato(
                "Mylena Moraes", 55555));

        // Exibir contatos
        agendaContatos.exibirContatos();
    }
}
