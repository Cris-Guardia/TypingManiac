package Graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Guardia Ogliastre
 */
public class Palabra extends JLabel{
    
    private boolean activo;
    private int velocidad = 10;

    public Palabra(String texto){
        activo = false;
        
        this.setText(texto);
        this.setOpaque(true);
        
        this.setLayout(null);
        
        this.setFont(new Font("Arial", 1, 20));
        
        this.setBackground(new Color( 167 , 255 , 131 ));
        this.setForeground(new Color( 7 , 26 , 82 ));
        
        ImageIcon imagen = new ImageIcon("papel.png");
        
        this.setSize(100, 50);
        //setBounds(250, 450, 100, 100);
        //setIcon(new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        
        this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(this.getHeight(), this.getWidth(), Image.SCALE_SMOOTH)));
        
    }
    
    public void Run() {
        activo = true;
        Timer t = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Caer();
            }
        }
        );
        t.start();

    }
    
    public boolean getActivo() {
        return activo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void Caer() {
        int y = this.getY();
        int x = this.getX();
        y += velocidad;
        setLocation(new Point(x, y));
        if (y >= 462) {
            activo = false;
        }
        
    }

    
    
}
