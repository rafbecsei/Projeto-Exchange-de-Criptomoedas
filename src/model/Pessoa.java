package model;

/**
 *
 * @author Rafael Becsei
 */

public class Pessoa {
    private String nome, cpf, senha;
    private int id;

    public Pessoa() {
        
    }

    public Pessoa(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
//        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + '}';
    }

    
}
