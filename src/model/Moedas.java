package model;

/**
 *
 * @author Rafael Becsei
 */

public class Moedas {
    private double saldo;
    private double cotacao;
    private double taxaC;
    private double taxaV;
   

    public Moedas() {
        this(0); 
    }

    public Moedas(double saldo, double cotacao, double taxaC, double taxaV) {
        this.saldo = saldo;
        this.cotacao = cotacao;
        this.taxaC = taxaC;
        this.taxaV = taxaV;
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

    public double getTaxaCompra() {
        return taxaC;
    }

    public void setTaxaCompra(double taxaC) {
        this.taxaC = taxaC;
    }

    public double getTaxaVenda() {
        return taxaV;
    }

    public void setTaxaVenda(double taxaV) {
        this.taxaV = taxaV;
    }

    @Override
    public String toString() {
        return "Moedas{" + "saldo=" + saldo + ", cotacao=" + cotacao + 
                                ", taxaC=" + taxaC + ", taxaV=" + taxaV + '}';
    }
    
    
}

