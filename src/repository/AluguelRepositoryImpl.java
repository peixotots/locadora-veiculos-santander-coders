package repository;
import model.aluguel.Aluguel;
import service.AluguelService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AluguelRepositoryImpl<T extends Aluguel> implements AluguelService {

    public List<T> bancoDados;

    @Override
    public void criarAluguel(Aluguel aluguel) {
       bancoDados = new ArrayList<>();
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
        bancoDados.add((T) aluguel);
        return aluguel;
    }

    private LocalDate formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatter);
        return LocalDate.parse(dataFormatada, formatter);
    }
}
