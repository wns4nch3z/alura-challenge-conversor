package com.conversor.model;

public enum CodigoMoneda {
    USD("Dólar Estadounidense", "$", "Estados Unidos"),
    EUR("Euro", "€", "Unión Europea"),
    PEN("Sol Peruano", "S/", "Perú"),
    JPY("Yen Japonés", "¥", "Japón"),
    GBP("Libra Esterlina", "£", "Reino Unido"),
    BRL("Real brasileño", "R$", "Brasil"),
    PLN("Zloty", "zł", "Polonia"),
    VES("Bolívar", "Bs.", "Venezuela"),
    COP("Peso colombiano", "$", "Colombia"),
    ARS("Peso argentino", "$", "Argentina"),
    CLP("Peso chileno", "$", "Chile"),
    PYG("Guarani", "Gs.", "Paraguay"),
    MXN("Unidad de Inversión Mexicana", "MX$", "México");

    private final String nombre;
    private final String simbolo;
    private final String pais;

    CodigoMoneda(String codigo, String simbolo, String pais) {
        this.nombre = codigo;
        this.simbolo = simbolo;
        this.pais = pais;
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
}
