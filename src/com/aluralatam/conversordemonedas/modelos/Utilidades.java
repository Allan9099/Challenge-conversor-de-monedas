package com.aluralatam.conversordemonedas.modelos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {
    public static int leerEnteroValidado(Scanner lectura, int min, int max) {
        int numero = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                numero = lectura.nextInt();
                if (numero >= min && numero <= max) {
                    entradaValida = true;
                } else {
                    System.out.println("Error, ingrese un numero valido");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. ingrese un numero valido.");
                lectura.next();
            }
        }
        return numero;
    }
    public static double leerDoubleValidado(Scanner lectura, double min, double max) {
        double numeroDouble = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                numeroDouble = lectura.nextDouble();
                if (numeroDouble >= min && numeroDouble <= max) {
                    entradaValida = true;
                } else {
                    System.out.println("Error, ingrese un numero valido");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. ingrese un numero valido.");
                lectura.next();
            }
        }
        return numeroDouble;
    }
    public static String leerNombreMoneda(Scanner lectura) {
        String moneda;
        boolean esValido = false;

        do {
            moneda = lectura.nextLine().toUpperCase();

            if (moneda.matches("[A-Za-z]+")) {
                esValido = true;
            } else {
                System.out.println("Nombre de moneda inválido, solo se aceptan letras.");
            }
        } while (!esValido);
        return moneda;
    }
    public static boolean continuarOpcion(Scanner lectura) {
        System.out.println("**********************************************************\nContinuar?\n1 - Continuar     2 - Salir");
        int opcion = leerEnteroValidado(lectura, 1, 2);
        return opcion == 1;
    }
}