package src.DAO;

import src.CONNECTION.ConexaoDB;
import src.DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public boolean adicionarCliente(ClienteDTO clienteDTO) {
        String query = "INSERT INTO tbcliente (bairro, cep, cidade, cpf, dataNascimento, endereco1, endereco2, estado, idade, nome, primeiraCompra) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, clienteDTO.getBairro());
            stmt.setString(2, clienteDTO.getCep());
            stmt.setString(3, clienteDTO.getCidade());
            stmt.setString(4, clienteDTO.getCpf());
            stmt.setString(5, clienteDTO.getDataNascimento());
            stmt.setString(6, clienteDTO.getEndereco1());
            stmt.setString(7, clienteDTO.getEndereco2());
            stmt.setString(8, clienteDTO.getEstado());
            stmt.setInt(9, clienteDTO.getIdade());
            stmt.setString(10, clienteDTO.getNome());
            stmt.setInt(11, clienteDTO.getPrimeiraCompra());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar cliente: " + e);
            return false;
        }
    }

    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        String query = "SELECT * FROM tbcliente";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ClienteDTO clienteDTO = new ClienteDTO(
                        rs.getString("bairro"),
                        rs.getString("cep"),
                        rs.getString("cidade"),
                        rs.getString("cpf"),
                        rs.getString("data_nascimento"),
                        rs.getString("endereco1"),
                        rs.getString("endereco2"),
                        rs.getString("estado"),
                        rs.getInt("idade"),
                        rs.getString("nome"),
                        rs.getInt("primeira_compra")
                );
                clienteDTOS.add(clienteDTO);
            }
            return clienteDTOS;
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e);
            return null;
        }
    }

    public void atualizaCliente(ClienteDTO clienteDTO) {
        String query = "UPDATE tbcliente SET bairro = ?, cep = ?, cidade = ?, dataNascimento = ?, endereco1 = ?, endereco2 = ?, estado = ?, idade = ?, nome = ?, primeiraCompra = ? WHERE cpf = ?";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, clienteDTO.getBairro());
            stmt.setString(2, clienteDTO.getCep());
            stmt.setString(3, clienteDTO.getCidade());
            stmt.setString(4, clienteDTO.getDataNascimento());
            stmt.setString(5, clienteDTO.getEndereco1());
            stmt.setString(6, clienteDTO.getEndereco2());
            stmt.setString(7, clienteDTO.getEstado());
            stmt.setInt(8, clienteDTO.getIdade());
            stmt.setString(9, clienteDTO.getNome());
            stmt.setInt(10, clienteDTO.getPrimeiraCompra());
            stmt.setString(11, clienteDTO.getCpf());
            stmt.executeUpdate();
            System.out.println("Cliente com CPF '" + clienteDTO.getCpf() + "' atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e);
        }
    }

    public void deletarCliente(String cpf) {
        String query = "DELETE FROM tbcliente WHERE cpf = ?";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            System.out.println("Cliente com CPF '" + cpf + "' excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e);
        }
    }

    public ClienteDTO getClienteByCpf(String cpf) {
        String query = "SELECT * FROM tbcliente WHERE cpf = ?";
        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ClienteDTO(
                        rs.getString("bairro"),
                        rs.getString("cep"),
                        rs.getString("cidade"),
                        rs.getString("cpf"),
                        rs.getString("dataNascimento"),
                        rs.getString("endereco1"),
                        rs.getString("endereco2"),
                        rs.getString("estado"),
                        rs.getInt("idade"),
                        rs.getString("nome"),
                        rs.getInt("primeiraCompra")
                );
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Erro ao pegar cliente: " + e);
            return null;
        }
    }
}
