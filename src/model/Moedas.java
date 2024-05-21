package model;

/**
 *
 * @author Rafael Becsei
 */

public class Moedas {
    private double saldo;
    private double cotacao;
   

    public Moedas() {
        this(0); 
    }

    public Moedas(double saldo, double cotacao) {
        this.saldo = saldo;
        this.cotacao = cotacao;
    }

    public Moedas(double saldo) {
        this.saldo = saldo;
    }
    
     public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    @Override
    public String toString() {
        return "Moedas{" + "saldo=" + saldo + ", cotacao=" + cotacao + '}';
    }
}

