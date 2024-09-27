package controller;

import model.exception.OpcaoInvalidaException;
import util.Util;

import java.util.List;

public class MenuPrincipal extends Menu {
    @Override
    public void selecionaOpcao() throws OpcaoInvalidaException {
        String menu = Menu.geraMenuComOpcoes("SISTEMA DE LOCADORA", List.of("Cadastro de veículos", "Cadastro de agências", "Cadastro de clientes", "Aluguéis", "Comprovantes", "Sair"));

        int opcaoSelecionada = 0;

        try {
            do {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("Digite uma opção");
                switch (opcaoSelecionada) {
                    case 1:
                        MenuVeiculo menuVeiculo = new MenuVeiculo();
                        menuVeiculo.selecionaOpcao();
                        break;
                    case 2:
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
                        break;

                }
            } while (opcaoSelecionada != 6);

        } catch (
                Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
