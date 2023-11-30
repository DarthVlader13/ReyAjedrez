package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    //Creo el atributo de clase rey
    private static Rey rey;

    //Creo el método ejecutarOpcion asignará al atributo de clase rey una nueva instancia de un rey creado con el constructor por defecto
    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearReyDefecto();
                break;
            case 2:
                Color color = Consola.elegirOpcion();
                crearReyColor(color);
                break;
            case 3:
                if (rey == null) {
                    System.out.println("Primero debes crear un rey.");
                } else {
                    Consola.mostrarMenuDirecciones();
                    Direccion direccion = Consola.elegirDireccion();
                    mover(direccion);
                }
                break;
            case 4:
                Consola.despedirse();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    //Creo el método crearReyDefecto asignará al atributo de clase rey una nueva instancia de un rey creado con el constructor por defecto.
    public static void crearReyDefecto() {
        rey = new Rey();
    }

    //Creo el método crearReyColor que asignará al atributo de clase rey una nueva instancia de un rey creado con el constructor al que le pasamos el color
    public static void crearReyColor(Color color) {
        rey = new Rey(color);
    }

    //Creo el método mover que mostrará un menú con las posibles direcciones. Nos preguntará por la dirección a mover y moverá el rey a la nueva posición, si es posible
    public static void mover(Direccion direccion) {
        try {
            rey.mover(direccion);
            mostrarRey();
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }


    //Creo el método mostrarRey que nos mostrará la información del rey si éste está creado. De lo contrario nos informará de ello.
    public static void mostrarRey() {
        if (rey != null) {
            System.out.println(rey);
        } else {
            System.out.println("El rey aún no ha sido creado.");
        }
    }

    //Creo el método main que será el método principal de nuestra aplicación y deberá iterar mostrando el menú principal, pidendo la opción y ejecutándola mientras no elijamos salir, en cuyo caso mostrará un mensaje de despedida y nuestra aplicación finalizará
    public static void main(String[] args) {
        int opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 4);

    }
}
