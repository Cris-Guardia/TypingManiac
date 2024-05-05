package Graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Guardia Ogliastre
 * 
 * Este Panel se encarga de ejecutar el juego en el nivel 1 de dificultad
 * 
 * 
 */

public class PanelJuego3 extends JPanel implements KeyListener{
    
    private Ventana w;
    private JPanel juego;
    private JPanel menu;
    private JLabel etiquetaPuntaje;
    private JLabel etiquetaTiempo;
    private JButton botonSalir;
    private Palabra[] palabras;
    private JPanel piso;
    private int tiempo = 120;
    private int puntosJuego = 0;
    private int noTipeada = 0;
    private int numeroPalabra = 0;
    private int contadorLento = 5;
    private int contadorAlto = 5;
    private boolean lento = true;
    private boolean alto = true;
    private boolean roto = true;
    private boolean continuar = true;
    private String nombreJugador;
    private StringBuilder cadena = new StringBuilder();

    
    
    public PanelJuego3(Ventana w, int puntos , int numero , int segundos, String nombre) {
    
        this.w = w;
        
        
        this.tiempo = segundos;
        this.puntosJuego = puntos;
        this.numeroPalabra = numero;
        this.nombreJugador = nombre;
        
        setFocusable(true);
                
        /*----------------------------COMPONENTES-------------------------*/
        
        this.juego = new JPanel();
        
        this.menu = new JPanel();
        
        this.piso = new JPanel();
        
        JPanel siguienteNivel = this;
        
        /*-----------------------------DISEÑO-------------------------------*/
        
        setLayout(new BorderLayout());
        
        add(this.juego, BorderLayout.CENTER);
        add(this.menu, BorderLayout.EAST);
        add(this.piso, BorderLayout.SOUTH);
        
        this.etiquetaTiempo = new JLabel( String.valueOf(this.tiempo) , SwingConstants.CENTER); 
        this.etiquetaPuntaje = new JLabel( "Puntos" + String.valueOf(this.puntosJuego) );
        this.botonSalir = new JButton("Salir");
        
        /*---------------------------DISEÑO MENU---------------------------*/
        
        this.menu.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        this.menu.add(this.botonSalir, gbc);
        
        this.botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changePanel(new PanelMenu(w));
                
                Datos datos = new Datos(puntosJuego, numeroPalabra, tiempo);
                
                try {
            
                    ObjectOutputStream datosPartida = new ObjectOutputStream(new FileOutputStream("Datos.dat"));
            
                    datosPartida.writeObject(datos);
            
                    datosPartida.close();
            
                } catch (IOException ex) {
            
                    System.out.println("PARTIDA NO GUARDADA");
            
                }

            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        this.menu.add(this.etiquetaTiempo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        this.menu.add(this.etiquetaPuntaje, gbc);
        
        /*---------------------------DISEÑO JUEGO---------------------------*/
        
        this.palabras = new Palabra[10];
        
        this.palabras[0] = new Palabra("Iguana");
        this.palabras[1] = new Palabra("multar");
        this.palabras[2] = new Palabra("hablar");
        this.palabras[3] = new Palabra("chisme");
        this.palabras[4] = new Palabra("poster");
        this.palabras[5] = new Palabra("servir");
        this.palabras[6] = new Palabra("actual");
        this.palabras[7] = new Palabra("viajar");
        this.palabras[8] = new Palabra("suceso");
        this.palabras[9] = new Palabra("Azúcar");
        
        for(int i = 0 ; i < palabras.length ; i++ ){
            this.palabras[i].setVelocidad(20);
        }
        
        Timer t;
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                repaint();
                chechColision();
                
                etiquetaTiempo.setText(String.valueOf(tiempo));
                etiquetaPuntaje.setText("PUNTOS" + String.valueOf(puntosJuego));
                
                
                
                if((tiempo > 0) && (noTipeada < 5) && continuar){
                    
                    tiempo--;
                    
                    Run();
                    
                }
                
                else{
                    
                    Terminado terminado;
                    
                    if( noTipeada >= 5 ){
                        terminado = new Terminado(puntosJuego , "PERDISTE", w, 0, "");
                    }
                    else{
                        terminado = new Terminado(puntosJuego , "GANASTE", w, 0, nombre);
                    }
                 
                    add(terminado, BorderLayout.WEST);
                            
                    Datos datos = new Datos(0, 0, 120);
                
                    try {

                        ObjectOutputStream datosPartida = new ObjectOutputStream(new FileOutputStream("Datos.dat"));

                        datosPartida.writeObject(datos);

                        datosPartida.close();

                    } catch (IOException ex) {

                        System.out.println("PARTIDA NO REINICIADA");

                    }
                    
                }

            }
        });
        
        t.start();
        
        this.addKeyListener(this);
        
        this.juego.setLayout(null);
        
        this.juego.setBackground(new Color(7, 26, 82));
        this.menu.setBackground(new Color(167, 255, 131));
        this.piso.setBackground(new Color(8, 105, 114));
        this.botonSalir.setBackground(new Color(23, 185, 120));
        this.botonSalir.setForeground(new Color(167, 255, 131));
    }

    void changePanel(JPanel npanel) {
        w.updatePanel(npanel);
    }
    
    void chechColision(){

        if (this.palabras[this.numeroPalabra].getY() >= 462) {

            noTipeada++;

            this.palabras[this.numeroPalabra].setVisible(false);
            this.palabras[this.numeroPalabra].setActivo(false);
            this.juego.remove(this.palabras[numeroPalabra]);

            this.numeroPalabra++;

            if(noTipeada >= 5){
                continuar = false;
            }

        }

    }
    
    public boolean isFalling(){
        
        if((noTipeada < 5) && (numeroPalabra <= 9)){
            
            for (int i = 0; i < palabras.length; i++) {
                if ( palabras[i].getActivo() && palabras[i].getParent().isVisible() ) {
                    return true;
                }
                
            }

        }
        
        return false;
        
    }
    
    public void Run(){
        
        if (!isFalling()) {
            
            boolean added = false;
            do {
                
                if (!palabras[numeroPalabra].getActivo()) {
                    this.juego.add(this.palabras[this.numeroPalabra]);
                    this.palabras[this.numeroPalabra].setBounds(50, 0, 100, 50);
                    palabras[numeroPalabra].Run();
                    added = true;
                    
                }
                
            } while (!added);
            
        }
        
    }

    @Override
    public void keyTyped(KeyEvent ke){}

    @Override
    public void keyPressed(KeyEvent ke) {
        
        if( ke.getExtendedKeyCode() == KeyEvent.VK_ENTER ){
            
            String entrada = cadena.toString();
            
            String etiqueta = this.palabras[numeroPalabra].getText();
            
            if(entrada.equals(etiqueta)){
                
                    System.out.println("Es correcto");

                    this.puntosJuego += 100;
                    cadena.setLength(0);

                    this.palabras[this.numeroPalabra].setVisible(false);
                    this.palabras[this.numeroPalabra].setActivo(false);
                    this.juego.remove(this.palabras[numeroPalabra]);

                    if(this.numeroPalabra >= 9){
                        continuar = false;

                        if(noTipeada < 5){

                            Terminado terminado = new Terminado(this.puntosJuego, "GANASTE", this.w, 0, this.nombreJugador);
                            this.juego.add(terminado);
                        }
                        else{
                            Terminado terminado = new Terminado(this.puntosJuego, "PERDISTE", this.w, 0, "");
                            this.juego.add(terminado);

                        }

                    }

                    else{

                        this.numeroPalabra++;

                    }

                }
                else{

                    if(entrada.equals("alto")){

                        if(alto){
                            alto = false;
                            
                            Timer tiempo = new Timer(1000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    if(contadorAlto>0){
                                        palabras[numeroPalabra].setVelocidad(0);
                                        juego.setBackground(Color.red);
                                        contadorAlto--;
                                    }
                                    else{
                                        palabras[numeroPalabra].setVelocidad(20);
                                        juego.setBackground(new Color(7, 26, 82));
                                    }

                                }
                            });

                            tiempo.start();

                            cadena.setLength(0);
                        }
                        else{
                            System.out.println("Alto ya ha sido usado");

                            cadena.setLength(0);

                        }

                    }
                    else{

                        if(entrada.equals("lento")){

                            if(lento){

                                lento = false;
                                Timer tiempo = new Timer(1000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    if(contadorLento>0){
                                        palabras[numeroPalabra].setVelocidad(1);
                                        juego.setBackground(Color.cyan);
                                        contadorLento--;
                                        
                                    }
                                    else{
                                        palabras[numeroPalabra].setVelocidad(20);
                                        juego.setBackground(new Color(7, 26, 82));
                                    }

                                }
                            });

                            tiempo.start();

                            cadena.setLength(0);
                            }
                            else{
                                System.out.println("Lento ya ha sido usado");
                                cadena.setLength(0);
                            }

                        }
                        else{

                            if(entrada.equals("roto")){
                                if(roto){

                                    roto = false;

                                    this.puntosJuego += 100;
                                    this.palabras[this.numeroPalabra].setVisible(false);
                                    this.palabras[this.numeroPalabra].setActivo(false);
                                    this.juego.remove(this.palabras[numeroPalabra]);
                                    this.numeroPalabra++;

                                    cadena.setLength(0);
                                }
                                else{
                                    System.out.println("Roto ya ha sido usado");
                                }
                                
                        }
                        else{
                            System.out.println("Entrada mala");

                            if( puntosJuego >= 50 ){
                                puntosJuego -= 50;
                            }

                            cadena.setLength(0);
                        }

                    }

                }

            }
        }
        else{
            
            cadena.append(ke.getKeyChar());
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent ke){}

}
