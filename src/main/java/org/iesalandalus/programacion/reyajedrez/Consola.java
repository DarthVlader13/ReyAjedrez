package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    //Creo el constructor de la clase Consola
    private Consola() {
        // No se permiten instanciar objetos de esta clase
    }

    //Creo el método estático mostrarMenu que nos dará las opciones de nuestra aplicación.
    public static void mostrarMenu() {
        System.out.println("1. Crear rey por defecto");
        System.out.println("2. Crear rey eligiendo el color");
        System.out.println("3. Mover");
        System.out.println("4. Salir");
    }

    //Creo el método estático elegirOpcionMenu para elegir entre las opciones del menú mostradas
    public static int elegirOpcionMenu() {
        int opcion;
        do {
            System.out.print("Elige una opción: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    //Creo el método estático elegirOpcion para elegir el color de nuestra ficha.
    public static Color elegirOpcion() {
        int opcion;
        do {
            System.out.println("1. Blanco");
            System.out.println("2. Negro");
            System.out.print("Elige un color: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 2);
        return (opcion == 1) ? Color.BLANCO : Color.NEGRO;
    }

    //Creo el método estático mostrarMenuDirecciones para identificar que dirección está asociada con los números del 1 al 10.
    public static void mostrarMenuDirecciones() {
        System.out.println("1. NORTE");
        System.out.println("2. NORESTE");
        System.out.println("3. ESTE");
        System.out.println("4. SURESTE");
        System.out.println("5. SUR");
        System.out.println("6. SUROESTE");
        System.out.println("7. OESTE");
        System.out.println("8. NOROESTE");
        System.out.println("9. ENROQUE_CORTO");
        System.out.println("10. ENROQUE_LARGO");
    }

    //Creo el método estático elegirDireccion para elegir hacia donde nos vamos a dirigir.
    public static Direccion elegirDireccion() {
        int opcion;
        do {
            System.out.print("Elige una dirección: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 10);
        return Direccion.values()[opcion - 1];
    }

    //Creo un método despedirse para que muestre un mensaje en caso de salir de la aplicación.
    public static void despedirse() {
        System.out.println("¡Hasta la próxima!");
    }
}
