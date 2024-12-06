package com.conversor.model;

public class TipoDeCambio {
    private Moneda monedaOrigen;
    private Moneda monedaDestino;
    private double tasa;

    // Constructor


    public TipoDeCambio(Moneda monedaOrigen, Moneda monedaDestino, double tasa) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tasa = tasa;
    }

    // Getter y Setter


    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(Moneda monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(Moneda monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    @Override
    public String toString() {
        return "TipoDeCambio{" +
                "monedaOrigen=" + monedaOrigen +
                ", monedaDestino=" + monedaDestino +
                ", tasa=" + tasa +
                '}';
    }
}
