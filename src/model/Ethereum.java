package model;

/**
 *
 * @author Rafael Becsei
 */

public class Ethereum extends Moedas implements Tarifação {
    private static final double taxaCompra = 0.01;
    private static final double taxaVenda = 0.02;

    public Ethereum(double saldo, double cotacao, double taxaC, double taxaV) {
        super(saldo, cotacao, taxaC, taxaV);
    }

    public Ethereum(double saldo) {
        super(saldo);
    }
    
    public Ethereum(double saldo, double cotacao) {
        super(saldo, cotacao);
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

