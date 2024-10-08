package src.APP;
import src.DAO.ClienteDAO;
import src.DAO.EstadoDAO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        EstadoDAO estadoDAO = new EstadoDAO();
        EntradaSaida entradaSaida = new EntradaSaida(scanner);
        int opcao;

        do {
            System.out.println("\n*** MENU PRINCIPAL ***");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Estados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    entradaSaida.gerenciarClientes(clienteDAO);
                    break;
                case 2:
                    entradaSaida.gerenciarEstados(estadoDAO);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
