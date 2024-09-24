package model.veiculo;

public abstract class Veiculo {

    protected String placa;
    protected String modelo;
    protected String marca;
    protected Boolean disponivel;

    public Veiculo(String placa, String modelo, String marca, Boolean disponivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.disponivel = disponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
