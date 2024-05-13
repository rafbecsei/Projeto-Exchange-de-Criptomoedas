package model;

/**
 *
 * @author Rafael Becsei
 */

public class Bitcoin extends Moedas implements Tarifa {
    private static final double cotacao = 0.0000031;
    private static final double taxaCompra = 0.02;
    private static final double taxaVenda = 0.03;

    public Bitcoin() {
        this(0); 
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

    public double getCotacao() {
        return cotacao;
    }
}



