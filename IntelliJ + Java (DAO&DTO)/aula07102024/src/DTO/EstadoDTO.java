package src.DTO;

public class EstadoDTO {
    private String sigla;
    private String descricao;

    // Construtor
    public EstadoDTO(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    // Getters and Setters
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
