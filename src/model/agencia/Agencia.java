package model.agencia;

import java.util.ArrayList;
import java.util.List;

public class Agencia<T> {

    String nome;
    String endereco;
    int identificador;
    List<T> veiculos;

    public Agencia(String nome, String endereco, int identificador) {
        this.nome = nome;
        this.endereco = endereco;
        this.identificador = identificador;
        this.veiculos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "AGÊNCIA ENCONTRADA:" +
                "\nNome: " + nome +
                "\nEndereço: " + endereco +
                "\nIdentificador: " + identificador +
                "\n";
    }
}