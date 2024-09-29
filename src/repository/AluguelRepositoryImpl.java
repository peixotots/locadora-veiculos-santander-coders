package repository;
import model.aluguel.Aluguel;
import model.pessoa.Pessoa;
import model.veiculo.Veiculo;
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
        return LocalDate.now();
    }

    @Override
    public LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias) {
        return dataInicial.plusDays(quantidadeDias);
    }

    @Override
    public Aluguel salvar(Aluguel aluguel) {
        bancoDados.add(aluguel);
        return aluguel;
    }

    public List<Aluguel> getBancoDados() {
        return bancoDados;
    }

    public Aluguel buscarAluguel(String placa) {
        for (Aluguel aluguel : bancoDados) {
            if (aluguel.getVeiculo().getPlaca().equals(placa)) {
                return aluguel;
            }
        }
        return null;
    }

    @Override
    public void deletarAluguel(Aluguel aluguel) {
        if (bancoDados.contains(aluguel)) {
            bancoDados.remove(aluguel);
        }
    }

    @Override
    public boolean verificarDisponibilidade(Veiculo veiculo) {
        if(veiculo.getDisponivel() == false) {
            return false;
        } else {
            return true;
        }
    }
}
