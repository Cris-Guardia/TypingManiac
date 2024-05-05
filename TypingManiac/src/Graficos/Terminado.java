package Graficos;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Guardia
 */
public class Terminado extends JPanel{

    private JLabel resultado;
    private JLabel puntos;
    private JButton botonSiguiente;
    private Ventana w;
    
    public Terminado(int puntos, String resultado, Ventana w, int siguiente, String nombre){
        
        this.setLayout(new GridLayout(2, 1));
        this.resultado = new JLabel(resultado);
        this.puntos = new JLabel(String.valueOf(puntos) + "PUNTOS");
        this.w = w;
        
        if(resultado.equals("GANASTE")){
            
            if(siguiente != 0){
                this.botonSiguiente = new JButton("SIGUIENTE");
                this.botonSiguiente.setBackground(new Color(23, 185, 120));
                this.botonSiguiente.setForeground(new Color(7, 26, 82));
            
                this.setLayout(new GridLayout(3, 1));
                
                this.botonSiguiente.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    if(siguiente == 2 ){
                        
                       changePanel(new PanelJuegoDos(w, puntos, 0, 80, nombre));
                    }
                    if(siguiente == 3 ){
                        
                       changePanel(new PanelJuego3(w, puntos, 0, 70, nombre));
                    }
                    
                }
            });
            
            add(this.botonSiguiente);
            }
            
            
        }
        
        add(this.resultado);
        add(this.puntos);
        
        this.setBackground(new Color(8, 105, 114));
        this.resultado.setForeground(new Color(167, 255, 131));
        this.puntos.setForeground(new Color(167, 255, 131));
        
    }

    Terminado(int puntosJuego, String perdiste, Ventana w, JPanel siguuienteNivel, int i) {
        
    }
    
    void changePanel(JPanel npanel) {
        w.updatePanel(npanel);
    }
    
}