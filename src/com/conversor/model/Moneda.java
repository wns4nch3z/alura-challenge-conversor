package com.conversor.model;

public class Moneda {

    private final CodigoMoneda codigo;
    private final String nombre;
    private final String simbolo;
    private final String pais;


    // Constructor
    public Moneda(CodigoMoneda codigo, String nombre, String simbolo, String pais) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.pais = pais;
    }

    // Getters y Setters


    public Moneda(CodigoMoneda codigo) {
        this.codigo = codigo;
        this.nombre = codigo.getNombre();
        this.simbolo = codigo.getSimbolo();
        this.pais = codigo.getPais();
    }

    // Getters
    public CodigoMoneda getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return String.format("Moneda[codigo=%s, nombre=%s, simbolo=%s, pais=%s]",
                codigo, nombre, simbolo, pais);
    }
}
