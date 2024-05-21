package model;

/**
 *
 * @author Rafael Becsei
 */

public class Ripple extends Moedas implements Tarifação{
    private static final double taxa = 0.01;

    public Ripple(double saldo, double cotacao) {
        super(saldo, cotacao); 
    }

    public Ripple(double saldo) {
        super(saldo);
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

