package controller;

import model.exception.OpcaoInvalidaException;
import util.Util;

import java.util.List;

public class MenuPrincipal extends Menu {
    @Override
    public void selecionaOpcao() throws OpcaoInvalidaException {
        String menu = Menu.geraMenuComOpcoes("LOCADORA DE VEÍCULOS", List.of("Cadastro de veículos", "Cadastro de agências", "Cadastro de clientes", "Aluguéis", "Comprovantes", "Sair"));

        int opcaoSelecionada = 0;

        do {
            try {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("DIGITE UMA OPÇÃO:");
                switch (opcaoSelecionada) {
                    case 1:
                        MenuVeiculo menuVeiculo = new MenuVeiculo();
                        menuVeiculo.selecionaOpcao();
                        break;
                    case 2:
                        MenuAgencia menuAgencia = new MenuAgencia();
                        menuAgencia.selecionaOpcao();
                        break;
                    case 3:
                        MenuPessoa menuPessoa = new MenuPessoa();
                        menuPessoa.selecionaOpcao();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.err.println("Encerrando o programa...");
                        break;
                    default:
                        throw new OpcaoInvalidaException();
                }
            } catch (OpcaoInvalidaException e) {
                System.err.println("Opção inválida! Por favor, digite uma opção válida.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (opcaoSelecionada != 6);
    }
}