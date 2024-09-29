package model.pessoa;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String nome, String endereco, String telefone, String cnpj) {
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
    }

    // Getter e Setter para CNPJ
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Pessoa Jurídica: " + getNome() +
                "  cnpj= " + cnpj;
    }
}

