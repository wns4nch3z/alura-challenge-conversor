package com.conversor.view;

import com.conversor.model.CodigoMoneda;
import com.conversor.model.GuardarConversion;
import com.conversor.model.Moneda;
import com.conversor.model.TipoDeCambio;
import com.conversor.service.TasaReal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        List<GuardarConversion> conversiones = new ArrayList<>();

        int opcion = 0;
        String monedasAElegir = """
                
                xxxx
                
                """;

        do {
            System.out.println("***********************************");
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("1. Realizar conversion");
            System.out.println("2. Ver conversiones");
            System.out.println("3. Guardar conversiones");
            System.out.println("4. Salir");
            System.out.println("Eliga una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la moneda que desea convertir:");
                    String monedaOrigen = scanner.next().toUpperCase();
                    System.out.println("Ingrese la moneda a la que desea convertir:");
                    String monedaDestino = scanner.next().toUpperCase();
                    System.out.println("Ingrese la cantidad a convertir: ");
                    double cantidad = scanner.nextDouble();

                    // Creación de las monedas usando el enum
                    Moneda origen = new Moneda(CodigoMoneda.valueOf(monedaOrigen));
                    Moneda destino = new Moneda(CodigoMoneda.valueOf(monedaDestino));

                    TasaReal tasaReal = new TasaReal();
                    try {
                        String resultado = tasaReal.tasaDeApi(origen, destino, cantidad);
                        System.out.println(resultado);
                        conversiones = tasaReal.getConversiones();
                    } catch (InterruptedException | IOException e) {
                        System.out.println("Error al obtener la tasa de cambio.");
                    }
                    break;

                case 2:
                    if (conversiones.isEmpty()) {
                        System.out.println("No ha realizado ninguna conversión.");
                    } else {
                        System.out.println("Estas son sus conversiones: ");
                        for (GuardarConversion conversion : conversiones) {
                            System.out.println(conversion);
                        }
                    }
                    break;

                case 3:
                    if (conversiones.isEmpty()) {
                        System.out.println("No hay conversiones para guardar.");
                    } else {
                        System.out.println("Ingrese un nombre para su archivo: ");
                        String nombreArchivo = scanner.next();

                        if (!nombreArchivo.endsWith(".txt")) {
                            nombreArchivo += ".txt";
                        }

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
                            for (GuardarConversion conversion : conversiones) {
                                writer.write(conversion.toString());
                                writer.newLine();
                            }
                            System.out.println("Conversiones guardadas en el archivo " + nombreArchivo);
                        } catch (IOException e) {
                            System.out.println("Error al guardar las conversiones.");
                        }
                    }
                    break;
                case 4:
                        System.out.println("Saliendo...");
                        break;
                default:
                    System.out.println("Opción no válida.");


            }


        } while (opcion != 4);




    }
}
