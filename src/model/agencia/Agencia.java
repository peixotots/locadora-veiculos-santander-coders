package model.agencia;

import model.veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

    String nome;
    String endereco;
    int identificador;
    List<Veiculo> veiculos;

    public Agencia(String nome, String endereco, int identificador, List<Veiculo> veiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.identificador = identificador;
        this.veiculos = new ArrayList<>();
    }

}