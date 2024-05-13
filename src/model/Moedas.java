package model;

/**
 *
 * @author Rafael Becsei
 */

public class Moedas {
    private double saldo;
   

    public Moedas() {
        this(0); 
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

    @Override
    public String toString() {
        return "Moedas{" + "saldo=" + saldo + '}';
    }
}

