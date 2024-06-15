/**
 * Clase principal del programa. Se encarga de cargar la ventana unicamente.
 * 
 * 
 * */
package Principal;

import Graficos.Ventana;

public class Main {

    public static void main(String[] args) {

        Ventana ventana = new Ventana();

        ventana.repaint();
        
        ventana.pack();
        
    }
    
}
