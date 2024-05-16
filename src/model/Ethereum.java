package model;

/**
 *
 * @author Rafael Becsei
 */
public class Ethereum extends Moedas implements Tarifação {
    private static final double cotacao = 0.000060;
    private static final double taxaCompra = 0.01;
    private static final double taxaVenda = 0.02;

    public Ethereum() {
        this(0);
    }

    public Ethereum(double saldo) {
        super(saldo);
    }

    public double getCotacao() {
        return cotacao;
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

