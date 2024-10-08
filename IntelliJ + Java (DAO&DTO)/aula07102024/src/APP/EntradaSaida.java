package src.APP;
import src.DAO.ClienteDAO;
import src.DAO.EstadoDAO;
import src.DTO.ClienteDTO;
import src.DTO.EstadoDTO;
import java.util.List;
import java.util.Scanner;

public class EntradaSaida {
    private final Scanner scanner;

    public EntradaSaida(Scanner scanner) {
        this.scanner = scanner;
    }

    public void gerenciarClientes(ClienteDAO clienteDAO) {
        int opcaoCliente;

        do {
            Utils.limparConsole();
            System.out.println("\n*** GERENCIAR CLIENTES ***");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("5. Buscar Cliente por CPF");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcaoCliente = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcaoCliente) {
                case 1:
                    ClienteDTO novoCliente = criarCliente();
                    if (clienteDAO.adicionarCliente(novoCliente)) {
                        System.out.println("Cliente adicionado com sucesso!");
                    }
                    break;
                case 2:
                    listarClientes(clienteDAO);
                    break;
                case 3:
                    atualizarCliente(clienteDAO);
                    break;
                case 4:
                    deletarCliente(clienteDAO);
                    break;
                case 5:
                    buscarClientePorCpf(clienteDAO);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if (opcaoCliente != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcaoCliente != 0);
    }

    public void gerenciarEstados(EstadoDAO estadoDAO) {
        int opcaoEstado;

        do {
            Utils.limparConsole();
            System.out.println("\n*** GERENCIAR ESTADOS ***");
            System.out.println("1. Adicionar Estado");
            System.out.println("2. Listar Estados");
            System.out.println("3. Atualizar Estado");
            System.out.println("4. Deletar Estado");
            System.out.println("5. Buscar Estado por Sigla");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcaoEstado = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoEstado) {
                case 1:
                    EstadoDTO novoEstado = criarEstado();
                    if (estadoDAO.adicionarEstado(novoEstado)) {
                        System.out.println("Estado adicionado com sucesso!");
                    }
                    break;
                case 2:
                    listarEstados(estadoDAO);
                    break;
                case 3:
                    atualizarEstado(estadoDAO);
                    break;
                case 4:
                    deletarEstado(estadoDAO);
                    break;
                case 5:
                    buscarEstadoPorSigla(estadoDAO);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if (opcaoEstado != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcaoEstado != 0);
    }

    private ClienteDTO criarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Endereço 1: ");
        String endereco1 = scanner.nextLine();
        System.out.print("Endereço 2: ");
        String endereco2 = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Primeira Compra (1 para sim, 0 para não): ");
        int primeiraCompra = scanner.nextInt();
        scanner.nextLine();

        return new ClienteDTO(bairro, cep, cidade, cpf, dataNascimento, endereco1, endereco2, estado, idade, nome, primeiraCompra);
    }

    private EstadoDTO criarEstado() {
        System.out.print("Sigla: ");
        String sigla = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        return new EstadoDTO(sigla, descricao);
    }

    private void listarClientes(ClienteDAO clienteDAO) {
        Utils.limparConsole();
        List<ClienteDTO> clientes = clienteDAO.listarClientes();

        if (clientes == null || clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            System.out.println("Lista de Clientes:");
            for (ClienteDTO cliente : clientes) {
                System.out.println(cliente.getNome() + " - CPF: " + cliente.getCpf());
            }
        }
    }

    private void listarEstados(EstadoDAO estadoDAO) {
        Utils.limparConsole();
        List<EstadoDTO> estados = estadoDAO.listarEstados();
        System.out.println("Lista de Estados:");
        for (EstadoDTO estado : estados) {
            System.out.println(estado.getSigla() + " - " + estado.getDescricao());
        }
    }

    private void atualizarCliente(ClienteDAO clienteDAO) {
        System.out.print("Digite o CPF do cliente a ser atualizado: ");
        String cpfAtualizar = scanner.nextLine();
        ClienteDTO clienteParaAtualizar = clienteDAO.getClienteByCpf(cpfAtualizar);
        if (clienteParaAtualizar != null) {
            System.out.println("Atualizando informações do cliente...");
            ClienteDTO clienteAtualizado = criarCliente();
            clienteAtualizado.setCpf(cpfAtualizar);
            clienteDAO.atualizaCliente(clienteAtualizado);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private void deletarCliente(ClienteDAO clienteDAO) {
        System.out.print("Digite o CPF do cliente a ser deletado: ");
        String cpfDeletar = scanner.nextLine();
        clienteDAO.deletarCliente(cpfDeletar);
    }

    private void buscarClientePorCpf(ClienteDAO clienteDAO) {
        System.out.print("Digite o CPF do cliente: ");
        String cpfBuscar = scanner.nextLine();
        ClienteDTO clienteBuscado = clienteDAO.getClienteByCpf(cpfBuscar);
        if (clienteBuscado != null) {
            System.out.println("Cliente encontrado: " + clienteBuscado.getNome());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private void atualizarEstado(EstadoDAO estadoDAO) {
        System.out.print("Digite a sigla do estado a ser atualizado: ");
        String siglaAtualizar = scanner.nextLine();
        EstadoDTO estadoParaAtualizar = estadoDAO.getEstadoBySigla(siglaAtualizar);
        if (estadoParaAtualizar != null) {
            System.out.println("Atualizando informações do estado...");
            EstadoDTO estadoAtualizado = criarEstado();
            estadoAtualizado.setSigla(siglaAtualizar);
            estadoDAO.atualizaEstado(estadoAtualizado);
        } else {
            System.out.println("Estado não encontrado!");
        }
    }

    private void deletarEstado(EstadoDAO estadoDAO) {
        System.out.print("Digite a sigla do estado a ser deletado: ");
        String siglaDeletar = scanner.nextLine();
        estadoDAO.deletarEstado(siglaDeletar);
    }

    private void buscarEstadoPorSigla(EstadoDAO estadoDAO) {
        System.out.print("Digite a sigla do estado: ");
        String siglaBuscar = scanner.nextLine();
        EstadoDTO estadoBuscado = estadoDAO.getEstadoBySigla(siglaBuscar);
        if (estadoBuscado != null) {
            System.out.println("Estado encontrado: " + estadoBuscado.getDescricao());
        } else {
            System.out.println("Estado não encontrado!");
        }
    }
}
