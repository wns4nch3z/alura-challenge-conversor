package com.conversor.model;

public class GuardarConversion {

    private final Moneda monedaOrigen;
    private final Moneda monedaDestino;
    private final double cantidad;
    private final double cantidadConvertida;
    private final double tasa;

    // Constructor
    public GuardarConversion(Moneda monedaOrigen, Moneda monedaDestino, double cantidad, double cantidadConvertida, double tasa) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        this.cantidadConvertida = cantidadConvertida;
        this.tasa = tasa;
    }

    @Override
    public String toString() {
        return String.format("De: %s %s a %s %s | Tasa: %.4f | Cantidad Convertida: %.2f",
                monedaOrigen.getSimbolo(), cantidad, monedaDestino.getSimbolo(), cantidadConvertida, tasa, cantidadConvertida);
    }

    public double getCantidadConvertida() {
        return cantidadConvertida;
    }

    public double getTasa() {
        return tasa;
    }
}
