package controller;

import exception.DadoInvalidoException;
import exception.OpcaoInvalidaException;
import model.agencia.Agencia;
import service.AgenciaService;
import service.AgenciaServiceImpl;
import util.Util;
import java.util.List;

public class MenuAgencia extends Menu {

    private final AgenciaService agenciaService = new AgenciaServiceImpl();

    @Override
    public void selecionaOpcao() {
        int opcaoSelecionada = 0;

        String menu = Menu.geraMenuComOpcoes("CADASTRO DE AGÊNCIAS", List.of("Cadastrar Agência", "Buscar Agência", "Alterar Agência", "Voltar"));

        do {
            try {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("Digite a opção desejada: ");

                switch (opcaoSelecionada) {
                    case 1:
                        String nome = Util.lerTexto("Digite o nome da agência: ");
                        String endereco = Util.lerTexto("Digite o endereço da agência: ");
                        int identificador = 0;
                        boolean identificadorValido = false;
                        while (!identificadorValido) {
                            try {
                                identificador = Util.lerNumeroInteiro("Digite o identificador (código numérico) da agência: ");
                                identificadorValido = true;
                            } catch (OpcaoInvalidaException e) {
                                System.err.println("Identificador inválido. Por favor, digite um identificador válido (código numérico).");
                            }
                        }
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
                        int idAlterar = 0;
                        boolean idAlterarValido = false;
                        while (!idAlterarValido) {
                            try {
                                idAlterar = Util.lerNumeroInteiro("Digite o identificador da agência que deseja alterar: ");
                                idAlterarValido = true;
                            } catch (OpcaoInvalidaException e) {
                                System.err.println("Identificador inválido. Por favor, digite um identificador válido (código numérico).");
                            }
                        }
                        final int finalIdAlterar = idAlterar;


                        List<Agencia> agenciasListadas = agenciaService.listar();

                        Agencia agenciaAlterar = agenciasListadas.stream()
                                .filter(a -> a.getIdentificador() == finalIdAlterar)
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
                    default:
                        throw new OpcaoInvalidaException();
                }
            } catch (OpcaoInvalidaException e) {
                System.err.println("Opção inválida! Por favor, digite uma opção válida.");
            } catch (DadoInvalidoException e) {
                System.err.println("Dado inválido! " + e.getMessage());
            }
        } while (opcaoSelecionada != 4);
    }
}