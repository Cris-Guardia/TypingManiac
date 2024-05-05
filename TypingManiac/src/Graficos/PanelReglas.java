package Graficos;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Guardia Ogliastre
 * 
 * Esta clse explica las reglas del juego
 * 
 */

public class PanelReglas extends JPanel {
   
    private JLabel etiquetaTitulo;
    private JPanel descripcion;
    private JButton botonMenu;
    private Ventana w;
    
    public PanelReglas(Ventana w){
        
        super();
        
        this.w = w;
        
        
        repaint();
        
        /*----------------------------COMPONENTES--------------------*/
        
        this.etiquetaTitulo = new JLabel("REGLAS", SwingConstants.CENTER);
        this.descripcion = new JPanel();
        
        
        JLabel regla1 = new JLabel("Escribe las palabras que ves en pantalla antes de que caigan. Si lo haces bien ganas 100 puntos, si lo haces mal pierdes 50");
        JLabel regla2 = new JLabel("Pierdes si no escribes el 50% de las palabras, recuerda tener cuidado con las mayusculas y las tildes");
        JLabel regla3 = new JLabel("Dispones de 3 comodines:");
        JLabel comodines = new JLabel("1) Alto: detiene las palabras un tiempo 2) Lento: Las palabras caen lento por unos segundos 3) roto: Elimina la palabra actual");
        
        this.descripcion.add(regla1);
        this.descripcion.add(regla2);
        this.descripcion.add(regla3);
        this.descripcion.add(comodines);
        
        this.descripcion.setLayout(new GridLayout(4,1));
        
        this.botonMenu = new JButton("MENU");
        
        /*---------------------------- Eventos ----------------------------*/
        
        this.botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changePanel(new PanelMenu(w));
            }
        });
        
        /*------------------------------DISEÑO-----------------------------*/
        
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        add(this.etiquetaTitulo, gbc);
        
        
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 2;
        
        add(this.descripcion, gbc);
        
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        add(this.botonMenu, gbc);
        
        this.etiquetaTitulo.setOpaque(true);
        
        this.setBackground(new Color(7, 26, 82));
        this.etiquetaTitulo.setBackground(new Color(167, 255, 131));
        this.botonMenu.setBackground(new Color(23, 185,120));
        this.descripcion.setBackground(new Color(8, 105,114));
        
        regla1.setForeground(new Color( 167 , 255 , 131 ));
        regla2.setForeground(new Color( 167 , 255 , 131 ));
        regla3.setForeground(new Color( 167 , 255 , 131 ));
        comodines.setForeground(new Color( 167 , 255 , 131 ));
        
        this.etiquetaTitulo.setForeground(new Color( 7 , 26 , 82 ));
        this.botonMenu.setForeground(new Color(167 , 255 , 131));

                

        
    }
    
    void changePanel(JPanel npanel) {
        
        w.updatePanel(npanel);
    }
    
}
