package model;

/**
 *
 * @author Rafael Becsei
 */

public class Ripple extends Moedas implements Tarifa{
    private static final double cotacao = 0.38121;
    private static final double taxa = 0.01;

    public Ripple() {
        this(0); 
    }

    public Ripple(double saldo) {
        super(saldo);
    }

    public double getCotacao() {
        return cotacao;
    }

    @Override
    public double getTaxaCompra() {
        return taxa;
    }

    @Override
    public double getTaxaVenda() {
        return taxa;
    }
}

