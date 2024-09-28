package controller;

import model.agencia.Agencia;
import model.aluguel.Aluguel;
import model.exception.OpcaoInvalidaException;
import model.pessoa.Pessoa;
import model.pessoa.PessoaFisica;
import model.pessoa.PessoaJuridica;
import model.veiculo.Veiculo;
import service.*;
import util.Util;

import java.time.LocalDate;
import java.util.List;

public class MenuAluguel extends Menu {
    private PessoaService pessoaService = new PessoaServiceImpl();
    private VeiculoService veiculoService = new VeiculoServiceImpl();
    private AgenciaService agenciaService = new AgenciaServiceImpl();
    private final AluguelService<Aluguel> aluguelService = new AluguelServiceImpl<>();

    int opcaoSelecionada;

    @Override

    public void selecionaOpcao() throws OpcaoInvalidaException {
        String menu = Menu.geraMenuComOpcoes("Aluguel", List.of("1-Aluguel para pessoa fisica", "2-Aluguel para pessoa juridica", "3-Devolução", "4-Sair"));

        try {
            do {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("Digite a opção desejada: ");

                switch (opcaoSelecionada) {
                    case 1:
                        try {
                            System.out.println("Aluguel pessoa fisica");
                            String nomeClienteParaAluguel = Util.lerTexto("Digite o nome da Pessoa: ");
                            Pessoa cliente = pessoaService.buscarPorNome(nomeClienteParaAluguel);

                            String agenciaEscolhida = Util.lerTexto("Digite o nome ou endereço da Agencia: ");
                            Agencia agencia = (Agencia) agenciaService.buscarPorNomeOuEndereco(agenciaEscolhida);

                            String veiculoEscolhido = Util.lerTexto("Digite a placa do Veículo: ");
                            Veiculo veiculo = veiculoService.buscarPorPlaca(veiculoEscolhido);

                            LocalDate dataInicial = aluguelService.definirDataInicial();
                            int quantidadeDias = Util.lerNumeroInteiro("Digite a quantidade de dias que você deseja alugar o veículo: ");
                            LocalDate dataDevolucaoPrevista = aluguelService.definirDataDeDevolucaoPrevista(dataInicial, quantidadeDias);

                            Aluguel aluguel = new Aluguel(cliente, agencia, veiculo, dataInicial.atStartOfDay(), dataDevolucaoPrevista.atStartOfDay());
                            aluguelService.criarAluguel(aluguel);
                            cliente.gerarComprovanteAluguel(); // falta colocar outras info

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Aluguel para Pessoa Jurídica selecionado.");
                        // quase msm coisa de P fisica
                        break;

                    case 3:
                        // devol
                        break;
                    case 4:
                        System.out.println("Saindo do menu de Aluguel...");
                        break;
                }
            } while (opcaoSelecionada != 4);

        } catch (OpcaoInvalidaException e) {
            System.err.println(e.getMessage());
        }
    }
}

