package Graficos;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Cristofer Guardia
 * 
 * Esta claser es el menu del juego
 * 
 */



public class PanelMenu extends JPanel {
    
    private JLabel etiquetaMenu;
    private JButton botonJugar;
    private JButton botonReglas;
    private JButton botonDerechos;
    private JButton botonSalir;
    private Ventana w;

    public PanelMenu(Ventana w) {
        
        this.w = w;
                
        setVisible(true);
        
        /*------------------------------COMPONENTES----------------------*/
        
        this.etiquetaMenu = new JLabel("Typing Maniac", SwingConstants.CENTER);
        this.etiquetaMenu.setOpaque(true);
        
        this.botonJugar = new JButton("JUGAR");
        this.botonReglas = new JButton("REGLAS");
        this.botonDerechos = new JButton("DERECHOS");
        this.botonSalir = new JButton("SALIR");
        
        
        
        /*-----------------------------------EVENTOS--------------------*/
        
        this.botonJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /*
                //Datos datos = new Datos();
                
                try {
            
                    ObjectInputStream datosPartida = new ObjectInputStream(new FileInputStream("Datos.dat"));
            
                    Datos datos = (Datos) datosPartida.readObject();
            
                    changePanel(new PanelJuego(w, datos.getPuntos(), datos.getNumeroPalabra() , datos.getTiempo() ));
            
                    datosPartida.close();
                    
                    
            
                } catch (Exception ex) {
            
                    System.out.println("PARTIDA NO CARGADA");
                    
                    changePanel(new PanelJuego(w, 0 , 0, 120));
            
                } 
                
                */
                
                changePanel(new IngresarNombre(w));
                
            }
        });
        
        this.botonReglas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                changePanel(new PanelReglas(w));
                
            }
        });
        
        this.botonDerechos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                changePanel(new PanelDerechos(w));
                
            }
        });
        
        this.botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        
        /*--------------POSCICIONAMIENTO Y ADICION-----------------*/
        
        /*------------------------------DISEÑO----------------------------*/
        

        setLayout( new GridBagLayout() );
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 50, 10, 50);
        
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        add(this.etiquetaMenu, gbc);
        
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(this.botonJugar, gbc);
                
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(this.botonReglas, gbc);
        
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        add(this.botonDerechos, gbc);
        
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.gridheight = 1;
        add(this.botonSalir, gbc);
        
        this.etiquetaMenu.setBackground(new Color(167, 255, 131));
        
        this.setBackground(new Color(7, 26, 82));
        this.botonJugar.setBackground(new Color(23, 185,120));
        this.botonReglas.setBackground(new Color(23, 185,120));
        this.botonDerechos.setBackground(new Color(23, 185,120));
        this.botonSalir.setBackground(new Color(23, 185,120));
        
        //AbstractBorder brdr = new Abc(Color.BLACK,2,16,0);
        
        this.etiquetaMenu.setForeground(new Color(7, 26, 82));
        this.botonJugar.setForeground(new Color(167, 255, 131));
        this.botonReglas.setForeground(new Color(167, 255, 131));
        this.botonDerechos.setForeground(new Color(167, 255, 131));
        this.botonSalir.setForeground(new Color(167, 255, 131));
        
    }

    void changePanel(JPanel npanel) {
        w.updatePanel(npanel);
    }
    
}
