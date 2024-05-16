package model;

/**
 *
 * @author Rafael Becsei
 */

public class Real extends Moedas implements Tarifação{
    private static final double taxaCompra = 0.00;
    private static final double taxaVenda = 0.00;
        
    public Real() {
        
    }
    
    public Real(double saldo) {
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
