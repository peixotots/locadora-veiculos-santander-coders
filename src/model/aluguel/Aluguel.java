package model.aluguel;
import model.agencia.Agencia;
import model.pessoa.Pessoa;
import model.veiculo.Veiculo;

import java.time.LocalDateTime;

public class Aluguel {
    protected Pessoa cliente;
    protected Agencia agencia;
    protected Veiculo veiculo;
    protected LocalDateTime dataInicio;
    protected LocalDateTime dataDevolucaoPrevista;

    public Aluguel(Pessoa cliente, Agencia agencia, Veiculo veiculo, LocalDateTime dataInicio, LocalDateTime dataDevolucaoPrevista) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }
}
