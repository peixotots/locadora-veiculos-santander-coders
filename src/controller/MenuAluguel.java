package controller;

import model.agencia.Agencia;
import model.aluguel.Aluguel;
import model.aluguel.Devolucao;
import exception.DadoInvalidoException;
import exception.OpcaoInvalidaException;
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

                            String tipoPessoa = Util.lerTexto("Deseja alugar para pessoa física ou jurídica?").toLowerCase();
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

                            String veiculo;
                            Veiculo veiculoEscolhido;
                            boolean disponibilidade;

                            do {
                                veiculo = Util.lerTexto("Digite a placa do Veículo: ");
                                veiculoEscolhido = veiculoService.buscarPorPlaca(veiculo);
                                disponibilidade = aluguelService.verificarDisponibilidade(veiculoEscolhido);

                                if (!disponibilidade) {
                                    System.out.println("Esse veículo não está disponível. Tente outra placa.");
                                }
                            } while (!disponibilidade);

                            LocalDate dataInicial = aluguelService.definirDataInicial();

                            int quantidadeDias = Util.lerNumeroInteiro("Digite a quantidade de dias que você deseja alugar o veículo: ");
                            LocalDate dataDevolucaoPrevista = aluguelService.definirDataDeDevolucaoPrevista(dataInicial, quantidadeDias);

                            Aluguel aluguel = new Aluguel(cliente, agenciaSelecionada, veiculoEscolhido, dataInicial, dataDevolucaoPrevista);
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

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
                            LocalDate dataFinal = null;

                            while (dataFinal == null) {
                                try {
                                    String inputDataDevolucao = Util.lerTexto("Digite a data da devolução (ex: dd/mm/yyyy): ");
                                    dataFinal = LocalDate.parse(inputDataDevolucao, formatter);
                                } catch (Exception e) {
                                    System.out.println("Data inválida. Por favor, use o formato dd/mm/yyyy.");
                                }
                            }
                            double valorTotalAluguel = devolucao.calcularDevolucao(dataFinal, tipoPessoa);
                            devolucao.imprimirComprovanteDevolucao(tipoPessoa, dataFinal, valorTotalAluguel);
                            Veiculo veiculoAlugado = aluguel.getVeiculo();
                            devolucao.disponibilizarVeiculo(veiculoAlugado);
                            aluguelService.deletarAluguel(aluguel);
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

