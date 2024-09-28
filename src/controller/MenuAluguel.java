package controller;
import model.exception.OpcaoInvalidaException;
import service.*;
import util.Util;

import java.time.LocalDate;
import java.util.List;
public class MenuAluguel extends Menu {
    private PessoaService pessoaService = new PessoaServiceImpl();
    private VeiculoService veiculoService = new VeiculoServiceImpl();
    private AluguelService aluguelService = new AluguelService();

    int opcaoSelecionada;

    @Override
    public void selecionaOpcao() throws OpcaoInvalidaException {
        String menu = Menu.geraMenuComOpcoes("Aluguel", List.of("Aluguel para P.fisica", "Aluguel para P.juridica", "Sair"));

        try {
            do {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("Digite a opção desejada: ");

                switch (opcaoSelecionada) {
                    case 1:
                        try {
                            System.out.println("Aluguel.");
                            String nomeClienteParaAluguel;
                            nomeClienteParaAluguel = Util.lerTexto("Digite o nome do cliente: ");
                          //  pessoaService.buscarPorNome(nomeClienteParaAluguel);


                            String agenciaEscolhida = Util.lerTexto("Digite o nome da Agencia: ");
                            String veiculoEscolhido = Util.lerTexto("Digite a placa do Veículo: ");
                            veiculoService.buscarPorPlaca(veiculoEscolhido);

                            LocalDate dataInicial = aluguelService.definirDataInicial();
                            int quantidadeDias = Util.lerNumeroInteiro("Digite a quantidade de dias que você deseja alugar o veículo: ");
                            LocalDate dataDevolucaoPrevista = aluguelService.definirDataDeDevolucaoPrevista(dataInicial, quantidadeDias);

                            // Aluguel aluguel = new Aluguel(nomeClienteParaAluguel,agenciaEscolhida, veiculoEscolhido, dataInicial, dataDevolucaoPrevista)
                            //aluguelService.criarAluguel();

                        }catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Aluguel para Pessoa Jurídica selecionado.");
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

