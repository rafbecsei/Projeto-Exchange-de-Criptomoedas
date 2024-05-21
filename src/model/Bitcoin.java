package model;

/**
 *
 * @author Rafael Becsei
 */

public class Bitcoin extends Moedas implements Tarifação {
    private static final double taxaCompra = 0.02;
    private static final double taxaVenda = 0.03;
    

    public Bitcoin(double saldo, double cotacao, double taxaC, double taxaV) {
        super(saldo, cotacao, taxaC, taxaV);
    }

    public Bitcoin(double saldo) {
        super(saldo);
    }
    
    public Bitcoin(double saldo, double cotacao) {
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



