package src.DAO;
import src.CONNECTION.ConexaoDB;
import src.DTO.EstadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    public boolean adicionarEstado(EstadoDTO estadoDTO){
        String query = "INSERT INTO tbestado (sigla, descricao) VALUES (?,?)";
        try(Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, estadoDTO.getSigla());
            stmt.setString(2, estadoDTO.getDescricao());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(SQLException e){
            System.out.println("erro estado: "+e);
            return false;
        }
    }
    public List<EstadoDTO> listarEstados(){
        List<EstadoDTO> estadoDTOS = new ArrayList<>();
        String query = "SELECT * FROM tbestado";
        try(Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                EstadoDTO estadoDTO = new EstadoDTO("","");
                estadoDTO.setSigla(rs.getString("sigla"));
                estadoDTO.setDescricao(rs.getString("descricao"));
                estadoDTOS.add(estadoDTO);
            }
            return estadoDTOS;

        }catch (SQLException e){
            System.out.println("Erro listar estado: "+e);
            return null;
        }
    }
    public boolean atualizaEstado(EstadoDTO estadoDTO){
        String query = "QUERY tbestado SET descricao = ? WHERE sigla ?";
        try(Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, estadoDTO.getDescricao());
            stmt.setString(2, estadoDTO.getSigla());
            stmt.executeUpdate();
            System.out.println("Estado de sigla '"+ estadoDTO.getSigla()+"' atualizado com sucesso!");
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao atualizar: "+e);
            return false;
        }
    }
    public void deletarEstado(String sigla){
        String query = "DELETE FROM tbestado WHERE sigla = ?";
        try(Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1,sigla);
            stmt.executeUpdate();
            System.out.println("Estado de sigla '"+sigla+"' excluido com sucesso!");
        }catch (SQLException e){
            System.out.println("Erro ao excluir: "+e);
        }
    }
    public EstadoDTO getEstadoBySigla(String sigla){
        String query = "SELECT * FROM tbestado WHERE sigla = ?";
        try(Connection connection = ConexaoDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1,sigla);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                EstadoDTO estadoDTO = new EstadoDTO(rs.getString("sigla"),rs.getString("descricao"));
                return estadoDTO;
            }
            return null;
        }catch (SQLException e){
            System.out.println("erro ao pegar estado: "+e);
            return null;
        }
    }
}
