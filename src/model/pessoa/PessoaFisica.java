package model.pessoa;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    // Getter e Setter para CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String gerarComprovanteAluguel() {
        // Implementação da geração de comprovante de aluguel para pessoa física
        return "Comprovante de Aluguel - Pessoa Física: " + getNome() + ", CPF: " + cpf;
    }

    @Override
    public String gerarComprovanteDevolucao() {
        // Implementação da geração de comprovante de devolução para pessoa física
        return "Comprovante de Devolução - Pessoa Física: " + getNome() + ", CPF: " + cpf;
    }
}

