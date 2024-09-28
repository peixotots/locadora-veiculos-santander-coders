package repository;
import model.aluguel.Aluguel;
import model.pessoa.Pessoa;
import service.AluguelService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AluguelRepositoryImpl extends AluguelRepository {

    private static AluguelRepositoryImpl instancia;
    private List<Aluguel> bancoDados;

    private AluguelRepositoryImpl() {
        bancoDados = new ArrayList<>();
    }

    public static AluguelRepositoryImpl getInstancia() {
        if (instancia == null) {
            instancia = new AluguelRepositoryImpl();
        }
        return instancia;
    }


    @Override
    public LocalDate definirDataInicial() {
        LocalDate dataInicial = LocalDate.now();
        return formatarData(dataInicial);
    }

    @Override
    public LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias) {
        return dataInicial.plusDays(quantidadeDias);
    }

    @Override
    public Aluguel salvar(Aluguel aluguel) {
        bancoDados.add((Aluguel) aluguel);
        return aluguel;
    }

    private LocalDate formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatter);
        return LocalDate.parse(dataFormatada, formatter);
    }
}
