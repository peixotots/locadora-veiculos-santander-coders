package controller;

import model.pessoa.PessoaFisica;
import model.pessoa.PessoaJuridica;
import model.pessoa.Pessoa;
import service.PessoaService;
import service.PessoaServiceImpl;
import util.Util;

import java.util.List;
import java.util.Objects;

public class MenuPessoa extends Menu {

    private final PessoaService<Pessoa> pessoaService = new PessoaServiceImpl<>();

    @Override
    public void selecionaOpcao() {

        int opcaoSelecionada;

        String menu = Menu.geraMenuComOpcoes("CADASTRO DE PESSOAS", List.of("Cadastrar Pessoa", "Buscar Pessoa Cadastrada", "Alterar dados de Pessoa", "Voltar"));


        try {
            do {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("Digite a opção desejada: ");

                switch (opcaoSelecionada) {
                    case 1:
                        int opcaoPessoa;

                        do {
                            opcaoPessoa = Util.lerNumeroInteiro("Digite a opção de pessoa\n1 - Pessoa Física\n2 - Pessoa Jurídica");
                        } while (opcaoPessoa < 1 || opcaoPessoa > 2);

                        String nome = Util.lerTexto("Digite o nome: ");
                        String endereco = Util.lerTexto("Digite o endereço: ");
                        String telefone = Util.lerTexto("Digite o telefone: ");

                        Pessoa pessoa;

                        if (opcaoPessoa == 1) {
                            String cpf = Util.lerTexto("Digite o CPF: ");
                            pessoa = new PessoaFisica(nome, endereco, telefone, cpf);
                        } else {
                            String cnpj = Util.lerTexto("Digite o CNPJ: ");
                            pessoa = new PessoaJuridica(nome, endereco, telefone, cnpj);
                        }

                        this.pessoaService.cadastrar(pessoa);

                        break;
                    case 2:
                        String nomeBuscar;
                        nomeBuscar = Util.lerTexto("Digite o nome da pessoa: ");
                        System.out.println(pessoaService.buscarPorNome(nomeBuscar));
                        break;
                    case 3:
                        String nomeAlterar;
                        nomeAlterar = Util.lerTexto("Digite o nome da pessoa que deseja alterar: ");
                        Pessoa pessoaAlterar = (pessoaService.buscarPorNome(nomeAlterar));

                        int atributoAlterar = Util.lerNumeroInteiro("Digite o atributo que deseja alterar: \n1 - Endereço\n2 - Telefone\n");

                        Pessoa pessoaAlterada;
                        if (pessoaAlterar instanceof PessoaFisica) {
                            pessoaAlterada = new PessoaFisica(
                                    pessoaAlterar.getNome(),
                                    pessoaAlterar.getEndereco(),
                                    pessoaAlterar.getTelefone(),
                                    ((PessoaFisica) pessoaAlterar).getCpf()  // CPF deve ser obtido
                            );
                        } else {pessoaAlterada = new PessoaJuridica(
                                pessoaAlterar.getNome(),
                                pessoaAlterar.getEndereco(),
                                pessoaAlterar.getTelefone(),
                                ((PessoaJuridica) pessoaAlterar).getCnpj()  // CNPJ deve ser obtido
                        );}

                        pessoaAlterada.setNome(pessoaAlterar.getNome());

                        if (atributoAlterar == 1) {
                            String novoEndereco = Util.lerTexto("Digite o novo endereço: ");
                            pessoaAlterada.setEndereco(novoEndereco);
                            pessoaAlterada.setTelefone(pessoaAlterar.getTelefone());
                        } else if (atributoAlterar == 2) {
                            String novoTelefone = Util.lerTexto("Digite o novo telefone: ");
                            pessoaAlterada.setTelefone(novoTelefone);
                            pessoaAlterada.setEndereco(pessoaAlterar.getEndereco());
                        }

                        System.out.println(this.pessoaService.alterar(pessoaAlterada));
                        break;
                    case 4:
                        System.out.println("Voltando...");
                        break;
                }
            } while (opcaoSelecionada != 4);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
