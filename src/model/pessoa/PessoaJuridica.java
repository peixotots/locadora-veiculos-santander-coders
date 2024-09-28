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
    public String gerarComprovanteAluguel() {
        // Implementação da geração de comprovante de aluguel para pessoa jurídica
        return "Comprovante de Aluguel - Pessoa Jurídica: " + getNome() + ", CNPJ: " + cnpj;
    }

    @Override
    public String gerarComprovanteDevolucao() {
        // Implementação da geração de comprovante de devolução para pessoa jurídica
        return "Comprovante de Devolução - Pessoa Jurídica: " + getNome() + ", CNPJ: " + cnpj;
    }

    @Override
    public String toString() {
        return "Pessoa Juridica: " + getNome() +
                "cnpj= " + cnpj;
    }
}

