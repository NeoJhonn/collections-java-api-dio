package list.operacoesBasicas;

public class Tarefa {

    private String decricao;

    public Tarefa(String decricao) {
        this.decricao = decricao;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    @Override
    public String toString() {
        return decricao;
    }
}
