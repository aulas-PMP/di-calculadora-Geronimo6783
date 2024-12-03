package calculadora;

import componentesinterfaz.PanelBotones;
import javax.swing.*;
import componentesinterfaz.PanelSalida;
import exceptions.MathException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import operacionestextoanumero.OperacionesTextoANumero;

/**
 * Clase principal del programa que representa a una calculadora.
 * @author Lois Domínguez Domínguez
 */
public class Calculadora extends JFrame{
    
    /**
     * Panel de salida de la calculadora.
     */
    public static PanelSalida panel = new PanelSalida();
    
    /**
     * Altura de la calculadora cuando no está en pantalla completa.
     */
    public static final int alturaCalculadoraNoPantallaCompleta = 600;
    
    /**
     * Anchura de la calculadora cuando no está en pantalla completa.
     */
    public static int anchuraCalculadoraNoPantallaCompleta;
    
    /**
     * Panel que contiene a todos los paneles de botones de la calculadora.
     */
    private final PanelBotones panelBotones;
    
    /**
     * Se encarga de gestionar los eventos de teclado.
     */
    private final EscuchadorTeclado escuchadorTeclado;
    
    /**
     * Constructor de calculadoras.
     */
    private Calculadora(){
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = pantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchuraPantalla = tamanoPantalla.width;
        
        setTitle("Calculadora Lois Domínguez Domínguez");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        anchuraCalculadoraNoPantallaCompleta = anchuraPantalla/2;
        setBounds(anchuraPantalla/4, (alturaPantalla - 600)/2, anchuraCalculadoraNoPantallaCompleta, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelSalida = new JPanel();
        panelSalida.setSize(Calculadora.anchuraCalculadoraNoPantallaCompleta , Calculadora.alturaCalculadoraNoPantallaCompleta / 6);
        panelSalida.setLayout(new BorderLayout());
        panelSalida.add(panel, BorderLayout.CENTER);
        add(generarBarraDeMenus());
        add(panelSalida);
        panelBotones = new PanelBotones();
        add(panelBotones);
        setFocusable(true);
        escuchadorTeclado = new EscuchadorTeclado();
        addKeyListener(escuchadorTeclado);
        setVisible(true);
    }
    
    /**
     * Genera una barra de menús en la que puedes seleccionar el modo de la calculadora a usar.
     * @return Barra de menús en la que puedes seleccionar el modo de la calculadora a usar.
     */
    private JMenuBar generarBarraDeMenus(){
        JMenuBar barraMenus = new JMenuBar();
        barraMenus.setOpaque(true);
        barraMenus.setBackground(Color.WHITE);
        JMenu menuModo = new JMenu("Modo");
        menuModo.setSize(50, barraMenus.getHeight());
        menuModo.setBorder(new EmptyBorder(0,20,0,20));
        
        ButtonGroup grupoDeBotones = new ButtonGroup();
        JRadioButtonMenuItem botonModoRaton = new JRadioButtonMenuItem("Ratón");
        JRadioButtonMenuItem botonModoTeclado = new JRadioButtonMenuItem("Teclado numérico");  
        JRadioButtonMenuItem botonModoLibre = new JRadioButtonMenuItem("Libre");
        botonModoRaton.setBackground(Color.WHITE);
        botonModoTeclado.setBackground(Color.WHITE);
        botonModoLibre.setBackground(Color.WHITE);
        botonModoRaton.setBorder(new EmptyBorder(5,0,5,0));
        botonModoTeclado.setBorder(new EmptyBorder(5,0,5,0));
        botonModoLibre.setBorder(new EmptyBorder(5,0,5,0));
        botonModoLibre.setSelected(true);
        botonModoRaton.addMouseListener(new EscuchadorRatonModoRaton());
        botonModoTeclado.addMouseListener(new EscuchadorRatonModoTeclado());
        botonModoLibre.addMouseListener(new EscuchadorRatonModoLibre());
        grupoDeBotones.add(botonModoRaton);
        grupoDeBotones.add(botonModoTeclado);
        grupoDeBotones.add(botonModoLibre);
        menuModo.add(botonModoRaton);
        menuModo.add(botonModoTeclado);
        menuModo.add(botonModoLibre);
        
        barraMenus.setLayout(new BorderLayout());
        barraMenus.add(menuModo, BorderLayout.LINE_START);
        barraMenus.setBorder(new EmptyBorder(0,0,0,0));
        return barraMenus;
    }
    
    public static void main(String[] args) {
        new Calculadora();
    }
    
    /**
     * Clase que representa al escuchador del ratón del botón del modo ratón.
     */
    private class EscuchadorRatonModoRaton extends MouseAdapter{
        
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getButton() == MouseEvent.BUTTON1){
                    removeKeyListener(escuchadorTeclado);
                    panelBotones.anadirEscuchadorRatonBotones();
                }
            }
    }
    
    /**
     * Clase que representa al escuchador del ratón del botón del modo ratón.
     */
    private class EscuchadorRatonModoTeclado extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getButton() == MouseEvent.BUTTON1){
                addKeyListener(escuchadorTeclado);
                panelBotones.eliminarEscuchadorRatonBotones();
            }
        }
    }
    
    /**
     * Clase que representa al escuchador del ratón del botón del modo libre.
     */
    private class EscuchadorRatonModoLibre extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getButton() == MouseEvent.BUTTON1){
                addKeyListener(escuchadorTeclado);
                panelBotones.anadirEscuchadorRatonBotones();
            }
        }
    }
    
     /**
     * Clase interna que se encarga de gestionar los eventos del teclado.
     */
    private static class EscuchadorTeclado extends KeyAdapter{

        /**
         * Gestiona cuando las teclas del teclado numérico son pulsadas.
         * @param ke Evento del teclado.
         */
        @Override
        public void keyPressed(KeyEvent ke) {
            int codigo = ke.getKeyCode();
            int localizacion = ke.getKeyLocation();
            switch(codigo){
                case 8 -> {
                    Calculadora.panel.setForeground(Color.black);
                    String textoAMostrar = Calculadora.panel.getTextoMostrado();
                    int tamanoTexto = textoAMostrar.length();
                    if(tamanoTexto > 1){
                        textoAMostrar = textoAMostrar.substring(0, textoAMostrar.length() - 1);
                        Calculadora.panel.setTextoMostrado(textoAMostrar);
                    }
                    else{
                        if(tamanoTexto == 1){
                            Calculadora.panel.limpiar();
                        }
                    }
                }
                case KeyEvent.VK_NUMPAD0 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('0');
                }
                case KeyEvent.VK_NUMPAD1 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('1');
                }
                case KeyEvent.VK_NUMPAD2 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('2');
                }
                case KeyEvent.VK_NUMPAD3 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('3');
                }
                case KeyEvent.VK_NUMPAD4 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('4');
                }
                case KeyEvent.VK_NUMPAD5 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('5');
                }
                case KeyEvent.VK_NUMPAD6 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('6');
                }
                case KeyEvent.VK_NUMPAD7 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('7');
                }
                case KeyEvent.VK_NUMPAD8 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('8');
                }
                case KeyEvent.VK_NUMPAD9 -> {
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('9');
                }
                case 10 ->{
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        try{
                            String resultado = OperacionesTextoANumero.operar(Calculadora.panel.getTextoMostrado());
                            if(Double.parseDouble(resultado) < 0){
                                Calculadora.panel.setForeground(Color.red);
                            }
                            else{
                                Calculadora.panel.setForeground(Color.black);
                            }
                            Calculadora.panel.setTextoMostrado(resultado.replace(".", ","));
                        }
                        catch(MathException e){
                            Calculadora.panel.setTextoMostrado("Math Error");
                        }
                    }
                }
                case 107 ->{
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter('+');
                    }
                }
                case 109 ->{
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter('-');
                    }
                }
                case 106 ->{
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter('*');
                    }
                }
                case 110 ->{
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter(',');
                    }
                }
                case 111 ->{
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter('/');
                    }
                }
                case KeyEvent.VK_ESCAPE ->{
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.limpiar();
                    }
                }
            }
        }
    }
}
