package controller;

import model.agencia.Agencia;
import model.aluguel.Aluguel;
import model.aluguel.Devolucao;
import model.exception.DadoInvalidoException;
import model.exception.OpcaoInvalidaException;
import model.pessoa.Pessoa;
import model.veiculo.Veiculo;
import service.*;
import util.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MenuAluguel extends Menu {
    private PessoaService pessoaService = new PessoaServiceImpl();
    private VeiculoService veiculoService = new VeiculoServiceImpl();
    private AgenciaService agenciaService = new AgenciaServiceImpl();
    private final AluguelService aluguelService = new AluguelServiceImpl();

    int opcaoSelecionada;

    @Override

    public void selecionaOpcao() throws OpcaoInvalidaException {
        String menu = Menu.geraMenuComOpcoes("Aluguel", List.of("Aluguel", "Devolução", "Sair"));

        try {
            do {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("Digite a opção desejada: ");

                switch (opcaoSelecionada) {
                    case 1:
                        try {
                            System.out.println("Aluguel");

                            String tipoPessoa = Util.lerTexto("Deseja alugar para pessoa fisica ou juridica?").toLowerCase();
                            String nomeClienteParaAluguel = Util.lerTexto("Digite o nome da Pessoa: ");
                            Pessoa cliente = pessoaService.buscarPorNome(nomeClienteParaAluguel);

                            String agenciaEscolhida = Util.lerTexto("Digite o nome ou endereço da Agência: ");
                            List<Agencia> agenciasEncontradas = agenciaService.buscarPorNomeOuEndereco(agenciaEscolhida);

                            if (agenciasEncontradas.isEmpty()) {
                                System.out.println("Nenhuma agência encontrada.");
                                return;
                            }

                            Agencia agenciaSelecionada;
                            if (agenciasEncontradas.size() == 1) {
                                agenciaSelecionada = agenciasEncontradas.get(0);
                            } else {
                                System.out.println("Agências encontradas:");
                                for (int i = 0; i < agenciasEncontradas.size(); i++) {
                                    System.out.println((i + 1) + ". " + agenciasEncontradas.get(i));
                                }

                                int opcao = Util.lerNumeroInteiro("Escolha o número da agência desejada: ");
                                if (opcao < 1 || opcao > agenciasEncontradas.size()) {
                                    throw new DadoInvalidoException();
                                }
                                agenciaSelecionada = agenciasEncontradas.get(opcao - 1);
                            }

                            String veiculoEscolhido = Util.lerTexto("Digite a placa do Veículo: ");
                            Veiculo veiculo = veiculoService.buscarPorPlaca(veiculoEscolhido);

                            LocalDate dataInicial = aluguelService.definirDataInicial();

                            int quantidadeDias = Util.lerNumeroInteiro("Digite a quantidade de dias que você deseja alugar o veículo: ");
                            LocalDate dataDevolucaoPrevista = aluguelService.definirDataDeDevolucaoPrevista(dataInicial, quantidadeDias);

                            Aluguel aluguel = new Aluguel(cliente, agenciaSelecionada, veiculo, dataInicial, dataDevolucaoPrevista);
                            aluguelService.criarAluguel(aluguel);
                            aluguel.imprimirComprovanteAluguel(quantidadeDias, tipoPessoa);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            System.out.println("Devolução");
                            String tipoPessoa = Util.lerTexto("Pessoa física ou jurídica? ").toLowerCase();

                            String placaParaDevolucao = Util.lerTexto("Digite a placa do veículo: ");
                            Aluguel aluguel = aluguelService.buscarAluguel(placaParaDevolucao);
                            if (aluguel == null) {
                                System.out.println("Aluguel não encontrado para a placa informada.");
                                break;
                            }
                            Devolucao devolucao = new Devolucao(aluguel);

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate dataFinal = null;

                            while (dataFinal == null) {
                                try {
                                    String inputDataDevolucao = Util.lerTexto("Digite a data da devolução (ex: 03/10/2024): ");
                                    dataFinal = LocalDate.parse(inputDataDevolucao, formatter);
                                } catch (Exception e) {
                                    System.out.println("Data inválida. Por favor, use o formato dd/MM/yyyy.");
                                }
                            }
                            devolucao.devolver(dataFinal, tipoPessoa);

                            Veiculo veiculoAlugado = aluguel.getVeiculo();
                            devolucao.disponibilizarVeiculo(veiculoAlugado);
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro: " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.println("Saindo do menu de Aluguel...");
                        break;
                }
            } while (opcaoSelecionada != 3);

        } catch (OpcaoInvalidaException e) {
            System.err.println(e.getMessage());
        }
    }
}

