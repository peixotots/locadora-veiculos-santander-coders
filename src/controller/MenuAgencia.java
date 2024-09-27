package controller;

import model.agencia.Agencia;
import service.AgenciaService;
import service.AgenciaServiceImpl;
import util.Util;

import java.util.List;

public class MenuAgencia extends Menu {

    private final AgenciaService agenciaService = new AgenciaServiceImpl();

    @Override
    public void selecionaOpcao() {
        int opcaoSelecionada;

        String menu = Menu.geraMenuComOpcoes("CADASTRO DE AGÊNCIAS", List.of("Cadastrar Agência", "Buscar Agência", "Alterar Agência", "Voltar"));

        try {
            do {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("Digite a opção desejada: ");

                switch (opcaoSelecionada) {
                    case 1:
                        String nome = Util.lerTexto("Digite o nome da agência: ");
                        String endereco = Util.lerTexto("Digite o endereço da agência: ");
                        int identificador = Util.lerNumeroInteiro("Digite o identificador da agência: ");
                        Agencia agencia = new Agencia(nome, endereco, identificador);
                        agenciaService.cadastrar(agencia);
                        System.out.println("Agência cadastrada com sucesso!");
                        break;
                    case 2:
                        String termoBusca = Util.lerTexto("Digite parte do nome ou do endereço: ");
                        List<Agencia> agenciasEncontradas = agenciaService.buscarPorNomeOuEndereco(termoBusca);
                        if (!agenciasEncontradas.isEmpty()) {
                            agenciasEncontradas.forEach(System.out::println);
                        } else {
                            System.err.println("Nenhuma agência encontrada.");
                        }
                        break;
                    case 3:
                        int idAlterar = Util.lerNumeroInteiro("Digite o identificador da agência que deseja alterar: ");
                        Agencia agenciaAlterar = agenciaService.listar().stream()
                                .filter(a -> a.getIdentificador() == idAlterar)
                                .findFirst()
                                .orElse(null);
                        if (agenciaAlterar != null) {
                            String novoNome = Util.lerTexto("Digite o novo nome da agência: ");
                            String novoEndereco = Util.lerTexto("Digite o novo endereço da agência: ");
                            agenciaAlterar.setNome(novoNome);
                            agenciaAlterar.setEndereco(novoEndereco);
                            agenciaService.alterar(agenciaAlterar);
                            System.out.println("Agência alterada com sucesso!");
                        } else {
                            System.err.println("Agência não encontrada.");
                        }
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