package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {
    private Color color;
    private Posicion posicion;
    private int totalMovimientos;

    //Constructor por defecto.
    public Rey() {
        this.color = Color.BLANCO;
        this.posicion = new Posicion(1, 'e');
        this.totalMovimientos = 0;
    }

    // Constructor para la clase que acepte como parámetro el color y que creará un rey de dicho color cuya posición será "1e" si es blanco o "8e" si es negro
    public Rey(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
        }
        this.color = color;
        this.posicion = (color == Color.BLANCO) ? new Posicion(1, 'e') : new Posicion(8, 'e');
        this.totalMovimientos = 0;
    }

    //Creamos getter y setter de Color
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
        }
        this.color = color;
    }

    //Creamos getter y setter de Posicion
    public Posicion getPosicion() {
        return new Posicion(posicion);
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new IllegalArgumentException("ERROR: No se puede asignar una posición nula.");
        }
        this.posicion = new Posicion(posicion);
    }

    //Creamos el método mover, que tratará excepciones en caso de que no se cumpla la dirección deseada debido a la posición del tablero y teniendo en cuenta que el enroque solo se puede hacer en el primer movimiento.
    //Si hacemos un renroque después de un primer movimiento normal, no nos dejará.
    public void mover(Direccion direccion) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new IllegalArgumentException("ERROR: La dirección no puede ser nula.");
        }
        int fila = getPosicion().getFila();
        char columna = getPosicion().getColumna();
        switch (direccion) {
            case NORTE:
                fila--;
                break;
            case NORESTE:
                fila--;
                columna++;
                break;
            case ESTE:
                columna++;
                break;
            case SURESTE:
                fila++;
                columna++;
                break;
            case SUR:
                fila++;
                break;
            case SUROESTE:
                fila++;
                columna--;
                break;
            case OESTE:
                columna--;
                break;
            case NOROESTE:
                fila--;
                columna--;
                break;
            case ENROQUE_CORTO:
                if (totalMovimientos == 0 && getPosicion().getColumna() == 'e' && getPosicion().getFila() == (getColor() == Color.BLANCO ? 1 : 8)) {
                    columna += 2;
                } else {
                    throw new OperationNotSupportedException("ERROR: No se puede realizar el enroque corto.");
                }
                break;
            case ENROQUE_LARGO:
                if (totalMovimientos == 0 && getPosicion().getColumna() == 'e' && getPosicion().getFila() == (getColor() == Color.BLANCO ? 1 : 8)) {
                    columna -= 2;
                } else {
                    throw new OperationNotSupportedException("ERROR: No se puede realizar el enroque largo.");
                }
                break;
        }
        if (fila >= 1 && fila <= 8 && columna >= 'a' && columna <= 'h') {
            setPosicion(new Posicion(fila, columna));
            totalMovimientos++;
        } else {
            throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
        }
    }




    //Creo el método toString que devuelve un String que será la representación de dicho objeto (color y posición)
    @Override
    public String toString() {
        return "color=" + color + ", posicion=" + posicion;
    }
}

