package model;

/**
 *
 * @author Rafael Becsei
 */

public class Usuario {
    private String cpf, senha;

    public Usuario() {
    }

    public Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
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

    @Override
    public String toString() {
        return "Usuario{" + "cpf=" + cpf + ", senha=" + senha + '}';
    }
}
