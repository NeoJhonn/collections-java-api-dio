package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double nota) {
        this.alunoSet.add(new Aluno(nome, matricula, nota));
    }

    public Aluno removerAluno(long matricula) {
        Aluno alunoParaRemover = this.alunoSet.stream().filter(a -> a.getMatricula() == matricula)
                .findFirst().orElse(null);

        if (!alunoParaRemover.equals(null)) {
            this.alunoSet.remove(alunoParaRemover);
        }

        return alunoParaRemover;
    }

    // Exibe todos os alunos do conjunto em ordem alfabética pelo nome.
    public Set<Aluno> exibirAlunosPorNome() {
        return new TreeSet<>(this.alunoSet);
    }

    // Exibe todos os alunos do conjunto em ordem crescente de nota.
    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNotaSet = new TreeSet<>(new ComparatorPorNota());

        alunosPorNotaSet.addAll(this.alunoSet);

        return alunosPorNotaSet;
    }

    // Exibir todos os alunos do conjunto
    public void exibirAlunos() {
        System.out.println("Alunos Cadastrados: "+ "\n" + this.alunoSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionar alunos
        gerenciadorAlunos.adicionarAluno("Jhonny", 31231231l, 9.5);
        gerenciadorAlunos.adicionarAluno("Carolina", 35757557l, 8.5);
        gerenciadorAlunos.adicionarAluno("Maria", 8787878l, 7.5);
        gerenciadorAlunos.adicionarAluno("Whitney", 7897987l, 6.5);
        gerenciadorAlunos.adicionarAluno("Ronaldo", 393399639l, 5.5);
        gerenciadorAlunos.adicionarAluno("Letícia", 2885822l, 3.5);
        gerenciadorAlunos.adicionarAluno("Bruna", 4117147147l, 1.5);
        gerenciadorAlunos.adicionarAluno("Shirlei", 195515919519l, 2.5);

        // Exibir todos os alunos
        gerenciadorAlunos.exibirAlunos();

        // Exibir Alunos por nome
        System.out.println("\n" + "Alunos por nome: "+ "\n" + gerenciadorAlunos.exibirAlunosPorNome());

        // Exibir Alunos por nota
        System.out.println("\n" + "Alunos por nota: "+ "\n" + gerenciadorAlunos.exibirAlunosPorNota());
    }


}
