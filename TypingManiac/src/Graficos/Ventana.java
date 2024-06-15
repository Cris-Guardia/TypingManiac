package Graficos;

import java.awt.Dimension;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Cristofer Guardia
 * 
 * Esta es la Ventana del juego
 * 
 * Es la clase principal principal
 * 
 * Maneja unicamente el panel menu
 * 
 */


public class Ventana extends JFrame{
    
    private JPanel panel;

    public Ventana() {
        
        setTitle("TypingManiac");
        
        /*---------------------------DIMENSIONES-------------------------*/
        
        setPreferredSize(new Dimension(800, 500));
        
        setResizable(false);
        
        /*--------------------------FUNCIONALIDADES--------------------*/
        
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*--------------------------COMPONENTES------------------------*/
        
        
        this.panel = new PanelMenu(this);
        add(this.panel);
        this.panel.setFocusable(true);
        
        /*------------------------------MUSICA-----------------------------*/
                
        try{
            
            File archivo = new File("musica.wav");
            
            AudioInputStream musica = AudioSystem.getAudioInputStream(archivo);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(musica);
            
            clip.start();
                    
        }
        catch(Exception ex){
            System.out.println("Cancion no encontrada");
        }
        
    }

    public void updatePanel(JPanel p) {
        this.remove(panel);
        panel = p;
        this.repaint();
        this.add(panel);
        panel.repaint();
        this.panel.setFocusable(true);
        this.repaint();
        pack();
    }
    
    
}
