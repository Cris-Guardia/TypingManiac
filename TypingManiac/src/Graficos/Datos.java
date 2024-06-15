package Graficos;

import java.io.Serializable;

/**
 *
 * @author Guardia
 */

public class Datos implements Serializable{

    private int puntos;
    private int numeroPalabra;
    private int tiempo;
    private int nivel;
    private String nombre;

    public Datos() {
        this.puntos = 0;
        this.numeroPalabra = 0;
        this.tiempo = 0;
        this.nombre = "";
        this.nivel = 0;
    }

    public Datos(int puntos, int numeroPalabra, int tiempo) {
        this.puntos = puntos;
        this.numeroPalabra = numeroPalabra;
        this.tiempo = tiempo;
        this.nombre = nombre;
        this.nivel = nivel;
    }
    
    public int getPuntos() {
        return puntos;
    }

    public int getNumeroPalabra() {
        return numeroPalabra;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setNumeroPalabra(int numeroPalabra) {
        this.numeroPalabra = numeroPalabra;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
