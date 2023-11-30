package org.iesalandalus.programacion.reyajedrez.modelo;

public enum Color {
    //Creamos el enumerado con los literales BLANCO y NEGRO
    BLANCO("Blanco"), NEGRO("Negro");

    //Atributo cadenaAMostrar
    private final String cadenaAMostrar;

    //Constructor
    Color(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }
    //Método toString que devolverá la representación en forma de cadena del literal
    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}

