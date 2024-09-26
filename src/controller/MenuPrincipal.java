package controller;

import java.util.List;

public class MenuPrincipal extends Menu{
    @Override
    public void selecionaOpcao() {
        System.out.println(Menu.geraMenuComOpcoes("SISTEMA DE LOCADORA", List.of("Cadastro de veículos", "Cadastro de agências", "Cadastro de clientes", "Aluguéis", "Comprovantes")));
    }
}
