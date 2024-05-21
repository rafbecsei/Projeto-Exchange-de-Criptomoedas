package model;

import java.util.ArrayList;

/**
 *
 * @author Rafael Becsei
 */

public class Carteira {
    private ArrayList<Moedas> moedas;

    public Carteira() {
        moedas = new ArrayList<>();
        moedas.add(new Real());
        moedas.add(new Bitcoin(0, 0));
        moedas.add(new Ethereum(0, 0));
        moedas.add(new Ripple(0, 0));
    }

    public Carteira(ArrayList<Moedas> moedas) {
        this.moedas = moedas;
    }

    public ArrayList<Moedas> getMoedas() {
        return moedas;
    }
    
    public void setMoedas(ArrayList<Moedas> moedas) {
        this.moedas = moedas;
    }

    @Override
    public String toString() {
        return "Carteira{" + "moedas=" + moedas + '}';
    }
}

