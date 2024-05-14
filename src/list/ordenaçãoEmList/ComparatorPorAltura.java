package list.ordenaçãoEmList;

import java.util.Comparator;

public class ComparatorPorAltura implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa pessoa1, Pessoa pessoa2) {
        // Compara as idades dos dois objetos pessoas que estão sendo
        // passados como parâmetro
        return Double.compare(pessoa1.getAltura(), pessoa2.getAltura());
    }
}
