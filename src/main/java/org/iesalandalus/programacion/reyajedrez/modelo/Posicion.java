package org.iesalandalus.programacion.reyajedrez.modelo;

import java.util.Objects;

//Creamos la clase Posición con los atributos fila (int) y columna (char).
public class Posicion {
    private int fila;
    private char columna;

    //Constructor copia
    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    //Constructor que lanzará un IllegalArgumentException si la posición asignada no es correcta
    public Posicion(Posicion posicion) {
        if (posicion == null) {
            throw new IllegalArgumentException("ERROR: No es posible copiar una posición nula.");
        }
        setFila(posicion.getFila());
        setColumna(posicion.getColumna());
    }

    //Creamos método getFila y setFila
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if (fila < 1 || fila > 8) {
            //Si la fila es menor que 1 o mayor que 8, lanzamos una excepción IllegalArgumentException
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }
        this.fila = fila;
    }

    //Creamos método getColumna y setColumna
    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna < 'a' || columna > 'h') {
            //Si la columna no está comprendida entre la a y la h lanzamos la excepción IllegalArgumentException
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }
        this.columna = columna;
    }

    //Creamos métodos equals y hashCode
    @Override
    public int hashCode() {
        return Objects.hash(columna, fila);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Posicion other)) {
            return false;
        }
        return columna == other.columna && fila == other.fila;
    }

    //Creamos método toString que devolverá un String y será la representación de la fila y la columna de forma adecuada (fila=valorFila, columna=valorColumna)
    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }
}

