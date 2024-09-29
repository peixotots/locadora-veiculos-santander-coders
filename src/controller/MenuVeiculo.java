package controller;

import model.veiculo.Caminhao;
import model.veiculo.Carro;
import model.veiculo.Moto;
import model.veiculo.Veiculo;
import service.VeiculoService;
import service.VeiculoServiceImpl;
import util.Util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class MenuVeiculo extends Menu {

    private final VeiculoService veiculoService = new VeiculoServiceImpl();

    @Override
    public void selecionaOpcao() {

        int opcaoSelecionada;

        String menu = Menu.geraMenuComOpcoes("CADASTRO DE VEÍCULOS", List.of("Cadastrar Veículo", "Buscar Veículo Cadastrado", "Alterar dados de veículo", "Voltar"));


        try {
            do {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("Digite a opção desejada: ");

                switch (opcaoSelecionada) {
                    case 1:
                        int opcaoVeiculo;

                        do {
                            opcaoVeiculo = Util.lerNumeroInteiro("Digite a opção de veículo\n1 - Carro\n2 - Moto\n3 - Caminhão");
                        } while (opcaoVeiculo < 1 || opcaoVeiculo > 3);

                        String placa;
                        do {
                            placa = Util.lerTexto("Digite a placa do veículo (XXX000)");
                        } while (!Util.validaPlaca(placa));

                        String modelo = Util.lerTexto("Digite o modelo do veículo: ");
                        String marca = Util.lerTexto("Digite a marca do veículo: ");

                        Veiculo veiculo;

                        if (opcaoVeiculo == 1) {
                            veiculo = new Carro(placa, modelo, marca);
                        } else if (opcaoVeiculo == 2) {
                            veiculo = new Moto(placa, modelo, marca);
                        } else {
                            veiculo = new Caminhao(placa, modelo, marca);
                        }

                        this.veiculoService.cadastrar(veiculo);

                        break;
                    case 2:
                        String placaBuscar;
                        placaBuscar = Util.lerTexto("Digite a placa do veículo: ");
                        System.out.println(veiculoService.buscarPorPlaca(placaBuscar));
                        break;
                    case 3:
                        String placaAlterar;
                        placaAlterar = Util.lerTexto("Digite a placa do veículo que deseja alterar: ");
                        Veiculo veiculoAlterar = (veiculoService.buscarPorPlaca(placaAlterar));
                        int atributoAlterar;
                        atributoAlterar = Util.lerNumeroInteiro("Digite o atributo que deseja alterar: \n1 - marca\n2 - modelo\n");

                        Veiculo veiculoAlterado;
                        if (Objects.equals(veiculoAlterar.getValor(), BigDecimal.valueOf(150))) {
                            veiculoAlterado = new Carro();
                        } else if (Objects.equals(veiculoAlterar.getValor(), BigDecimal.valueOf(100))) {
                            veiculoAlterado = new Moto();
                        } else {
                            veiculoAlterado = new Caminhao();
                        }

                    veiculoAlterado.setPlaca(veiculoAlterar.getPlaca());
                    veiculoAlterado.setDisponivel(veiculoAlterar.getDisponivel());
                    if (atributoAlterar == 1) {
                        String novaMarca = Util.lerTexto("Digite a nova marca: ");
                        veiculoAlterado.setMarca(novaMarca);
                        veiculoAlterado.setModelo(veiculoAlterar.getModelo());
                    } else if (atributoAlterar == 2) {
                        String novoModelo = Util.lerTexto("Digite o novo modelo: ");
                        veiculoAlterado.setModelo(novoModelo);
                        veiculoAlterado.setMarca(veiculoAlterar.getMarca());
                    }
                        System.out.println(this.veiculoService.alterar(veiculoAlterado));
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

