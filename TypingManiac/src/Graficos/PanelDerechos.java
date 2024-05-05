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
 * @author Guardia
 * 
 * Esta calse contiene el panel que engloba lo relacionado con los derechos de autor
 * 
 */

public class PanelDerechos extends JPanel{

    private JLabel etiquetaTitulo;
    private JPanel descripcion;
    private JButton botonMenu;
    private Ventana w;
    
    public PanelDerechos(Ventana w) {
        
        this.w = w;
        
        this.etiquetaTitulo = new JLabel("Derechos de Autor", SwingConstants.CENTER);
        this.descripcion = new JPanel();
        
        JLabel etiqueta1 = new JLabel("Diseño, programacion y creacion: Cristofer Isaac Guardia Ogliastre");
        JLabel etiqueta2 = new JLabel("Musica: Daft Punk - Giorgio by Moroder");
        JLabel etiqueta3 = new JLabel("Tecnologias usadas: Java");
        
        this.descripcion.add(etiqueta1);
        this.descripcion.add(etiqueta2);
        this.descripcion.add(etiqueta3);
        
        this.descripcion.setLayout(new GridLayout(3, 1));
        
        this.botonMenu = new JButton("MENU");
        
        /*-------------------------EVENTOS-----------------------------------*/
        
        this.botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changePanel(new PanelMenu(w));
            }
        });
        
        /*------------------------------DISEÑO-------------------------------*/
        
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 50, 10, 50);
        
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        add(this.etiquetaTitulo, gbc);
                
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 4;
        
        add(this.descripcion, gbc);
        
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        add(this.botonMenu, gbc);
        
        this.setBackground(new Color(7, 26, 82));
        this.etiquetaTitulo.setOpaque(true);
        this.etiquetaTitulo.setBackground(new Color(167, 255, 131));
        this.botonMenu.setBackground(new Color(23, 185,120));
        
        etiqueta1.setForeground(new Color( 167 , 255 , 131 ));
        etiqueta2.setForeground(new Color( 167 , 255 , 131 ));
        etiqueta3.setForeground(new Color( 167 , 255 , 131 ));
        
        this.etiquetaTitulo.setForeground(new Color(7, 26, 82));
        this.descripcion.setBackground(new Color(8, 105,114));
        this.botonMenu.setForeground(new Color(167 , 255 , 131));
    }
    
    void changePanel(JPanel npanel) {
        w.updatePanel(npanel);
    }
    
}
