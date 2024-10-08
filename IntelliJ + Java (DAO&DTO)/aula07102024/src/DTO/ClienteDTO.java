package src.DTO;

public class ClienteDTO {
    private String bairro;
    private String cep;
    private String cidade;
    private String cpf;
    private String dataNascimento;
    private String endereco1;
    private String endereco2;
    private String estado;
    private int idade;
    private String nome;
    private int primeiraCompra;

    //Construtor
    public ClienteDTO(String bairro, String cep, String cidade, String cpf,
                      String dataNascimento, String endereco1, String endereco2,
                      String estado, int idade, String nome, int primeiraCompra) {
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco1 = endereco1;
        this.endereco2 = endereco2;
        this.estado = estado;
        this.idade = idade;
        this.nome = nome;
        this.primeiraCompra = primeiraCompra;
    }

    // Getters and Setters
    public int getPrimeiraCompra() {
        return primeiraCompra;
    }

    public void setPrimeiraCompra(int primeiraCompra) {
        this.primeiraCompra = primeiraCompra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco2() {
        return endereco2;
    }

    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }

    public String getEndereco1() {
        return endereco1;
    }

    public void setEndereco1(String endereco1) {
        this.endereco1 = endereco1;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
