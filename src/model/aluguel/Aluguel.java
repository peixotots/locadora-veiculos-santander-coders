package model.aluguel;

import model.agencia.Agencia;
import model.pessoa.Pessoa;
import model.veiculo.Veiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluguel {
    protected Pessoa cliente;
    protected Agencia agencia;
    protected Veiculo veiculo;
    protected LocalDate dataInicio;
    protected LocalDate dataDevolucaoPrevista;

    public Aluguel(Pessoa cliente, Agencia agencia, Veiculo veiculo, LocalDate dataInicio, LocalDate dataDevolucaoPrevista) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public void imprimirComprovanteAluguel(int quantidadeDias, String tipoPessoa) {
        System.out.println("=== COMPROVANTE DE ALUGUEL ===");
        System.out.println("Tipo: Pessoa " + tipoPessoa);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Agência: " + agencia.getNome());
        System.out.println("Veículo: " + veiculo.getPlaca() + " | " + veiculo.getModelo());
        System.out.println("Data de inicio: " + dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data de devolução prevista: " + dataDevolucaoPrevista.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("A quantidade de dias do aluguel é: " + quantidadeDias + " dias.");
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

}
