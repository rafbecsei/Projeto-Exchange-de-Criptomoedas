package model;

/**
 *
 * @author Rafael Becsei
 */

public class Ripple extends Moedas implements Tarifação{
    private static final double taxaCompra = 0.01;
    private static final double taxaVenda = 0.01;

    public Ripple(double saldo, double cotacao, double taxaC, double taxaV) {
        super(saldo, cotacao, taxaC, taxaV);
    }
    
    public Ripple(double saldo, double cotacao) {
        super(saldo, cotacao);
    }

    public Ripple(double saldo) {
        super(saldo);
    }

    @Override
    public double getTaxaCompra() {
        return taxaCompra;
    }

    @Override
    public double getTaxaVenda() {
        return taxaVenda;
    }
}

