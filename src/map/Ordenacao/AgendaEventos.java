package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        this.eventosMap.put(data, new Evento(nome, atracao));
    }

    public Map<LocalDate, Evento> exibirAgendaPorData() {
        // retornando um TreeMap ele já ordena automaticamente por LocalDate
        return new TreeMap<>(this.eventosMap);
    }

    public void obterProximoEvento() {
        Evento proximoEvento = null;
        LocalDate proximaData = null;

        // Date de hoje
        LocalDate dataDeHoje = LocalDate.now();
        // Evento ordenados por data
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(this.eventosMap);

        for (Map.Entry<LocalDate, Evento> entry: eventosTreeMap.entrySet()) {
            proximoEvento = entry.getValue();
            proximaData = entry.getKey();

            if (proximaData.isEqual(dataDeHoje) || proximaData.isAfter(dataDeHoje)) {
                System.out.println("O próximo evento: " + proximoEvento +
                        " acontecerá na data " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        // Adicionar eventos
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JANUARY, 15),"Evento1", "atração1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.MAY, 12),"Evento2", "atração2");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JUNE, 8),"Evento3", "atração3");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.AUGUST, 7),"Evento4", "atração4");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.DECEMBER, 30),"Evento5", "atração5");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.SEPTEMBER, 22),"Evento6", "atração6");

        // Exibir agenda por Data
        System.out.println(agendaEventos.exibirAgendaPorData());

        System.out.println();

        // Obter o próximo evento
        agendaEventos.obterProximoEvento();
    }
}
