package model;

/**
 *
 * @author Rafael Becsei
 */

public class Bitcoin extends Moedas implements Tarifação {
    private static final double taxaCompra = 0.02;
    private static final double taxaVenda = 0.03;

    public Bitcoin(double saldo, double cotacao) {
        super(saldo, cotacao);
    }

    public Bitcoin(double saldo) {
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



