package Graficos;

import Graficos.Ventana;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Guardia
 * 
 * Mediante esta clase se ingrersa el nombre del jugador
 * 
 * 
 * 
 */

public class IngresarNombre extends JPanel implements KeyListener{
   
    private JLabel etiquetaNombre;
    private JTextField cuadroNombre;
    private JButton botonJugar;
    private Ventana w;
    
    public IngresarNombre(Ventana w){
        
        this.w = w;
        
        
        
        /*-------------------------COMPONENTES---------------------------*/
        
        this.etiquetaNombre = new JLabel("Ingrese su nombre", SwingConstants.CENTER);
        this.cuadroNombre = new JTextField();
        this.botonJugar = new JButton("Jugar");
        
        add(this.etiquetaNombre);
        add(this.cuadroNombre);
        add(this.botonJugar);
        
        /*----------------------------EVENTOS-------------------------------*/
        
        this.botonJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                //Datos datos = new Datos();
                
                try {
                    ObjectInputStream datosPartida = new ObjectInputStream(new FileInputStream("Datos.dat"));
            
                    Datos datos = (Datos) datosPartida.readObject();
                    
                    if(datos.getNombre().equals(cuadroNombre.getText())){
                        System.out.println("PARTIDA SI CARGADA");
                        changePanel(new PanelJuego(w, datos.getPuntos(), datos.getNumeroPalabra() , datos.getTiempo() , cuadroNombre.getText()));
                    }
                    else{
                        changePanel(new PanelJuego(w, 0 , 0, 120, cuadroNombre.getText()));
                    }
            
                    datosPartida.close();
                    
                    
            
                } catch (Exception ex) {
            
                    System.out.println("PARTIDA NO CARGADA");
                    
                    changePanel(new PanelJuego(w, 0 , 0, 120, ""));
            
                } 
                
                
            }
        });
        
        this.addKeyListener(this);
        
        /*----------------------------DISEÑO-------------------------------*/
        
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 50, 10, 50);
        
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        add(this.etiquetaNombre, gbc);
                
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 4;
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        add(this.cuadroNombre, gbc);
        
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        add(this.botonJugar, gbc);
        
        this.setBackground(new Color(7, 26, 82));
        
        this.etiquetaNombre.setOpaque(true);
        this.etiquetaNombre.setBackground(new Color(167, 255, 131));
        this.cuadroNombre.setBackground(new Color(8, 105,114));
        this.botonJugar.setBackground(new Color(23, 185,120));
        
        this.etiquetaNombre.setForeground(new Color(7, 26, 82));
        this.cuadroNombre.setForeground(new Color( 167 , 255 , 131 ));
        this.botonJugar.setForeground(new Color( 167 , 255 , 131 ));
        
    }
    
    void changePanel(JPanel npanel) {
        w.updatePanel(npanel);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        if(ke.getExtendedKeyCode() == KeyEvent.VK_ENTER){
            
            try {
                    ObjectInputStream datosPartida = new ObjectInputStream(new FileInputStream("Datos.dat"));
            
                    Datos datos = (Datos) datosPartida.readObject();
                    
                    if(datos.getNombre().equals(cuadroNombre.getText())){
                        System.out.println("PARTIDA SI CARGADA");
                        changePanel(new PanelJuego(w, datos.getPuntos(), datos.getNumeroPalabra() , datos.getTiempo() , cuadroNombre.getText()));
                    }
                    else{
                        changePanel(new PanelJuegoDos(w, 0 , 0, 60, cuadroNombre.getText()));
                    }
            
                    datosPartida.close();
                    
                    
            
                } catch (Exception ex) {
            
                    System.out.println("PARTIDA NO CARGADA");
                    
                    changePanel(new PanelJuego(w, 0 , 0, 60, ""));
            
                } 
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
