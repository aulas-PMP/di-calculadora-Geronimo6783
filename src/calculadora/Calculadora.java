package calculadora;

import componentesinterfaz.PanelBotones;
import javax.swing.*;
import componentesinterfaz.PanelSalida;
import exceptions.MathException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.EmptyBorder;
import operacionestextoanumero.OperacionesTextoANumero;

/**
 * Clase principal del programa que representa a una calculadora.
 * @author Lois Domínguez Domínguez
 */
public class Calculadora extends JFrame{
    
    /**
     * Panel de salida de la calculadora que muestra lo que introduce el usuario y el resultado de las operaciones.
     */
    public static PanelSalida panel = new PanelSalida();
    
    /**
     * Panel que muestra la operación que ha introducido el usuario en la calculadora.
     */
    public static PanelSalida panelOperacion = new PanelSalida();
    
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
     * Panel que muestra el modo en el que se encuentra la calculadora.
     */
    private final PanelModo panelModo = new PanelModo();
    
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
        panelSalida.setSize(Calculadora.anchuraCalculadoraNoPantallaCompleta , Calculadora.alturaCalculadoraNoPantallaCompleta / 12);
        panelSalida.setMaximumSize(new Dimension(anchuraPantalla, (Calculadora.alturaCalculadoraNoPantallaCompleta / 12)));
        panelSalida.setLayout(new BorderLayout());
        panelSalida.add(panel, BorderLayout.CENTER);
        add(generarBarraDeMenus());
        JPanel jPanelOperacion = new JPanel();
        jPanelOperacion.setSize(Calculadora.anchuraCalculadoraNoPantallaCompleta , Calculadora.alturaCalculadoraNoPantallaCompleta / 12);
        jPanelOperacion.setMaximumSize(new Dimension(anchuraPantalla, (Calculadora.alturaCalculadoraNoPantallaCompleta / 12)));
        jPanelOperacion.setLayout(new BorderLayout());
        jPanelOperacion.add(panelOperacion, BorderLayout.CENTER);
        add(jPanelOperacion);
        add(panelSalida);
        panelBotones = new PanelBotones();
        add(panelBotones);
        setFocusable(true);
        escuchadorTeclado = new EscuchadorTeclado();
        addKeyListener(escuchadorTeclado);
        EscuchadorEventosVentana escuchadorEventosVentana = new EscuchadorEventosVentana();
        addWindowListener(escuchadorEventosVentana);
        addWindowStateListener(escuchadorEventosVentana);
        setVisible(true);
    }
    
    /**
     * Genera una barra de menús en la que puedes seleccionar el modo de la calculadora a usar.
     * @return Barra de menús en la que puedes seleccionar el modo de la calculadora a usar.
     */
    private JMenuBar generarBarraDeMenus(){
        JMenuBar barraMenus = new JMenuBar();
        barraMenus.setMaximumSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, 0));
        barraMenus.setOpaque(true);
        barraMenus.setBackground(Color.WHITE);
        JMenu menuModo = new JMenu("Modo");
        menuModo.setSize(50, barraMenus.getHeight());
        menuModo.setBorder(new EmptyBorder(15,20,10,15));
        
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
        botonModoRaton.addActionListener(new EscuchadorAccionModoRaton());
        botonModoTeclado.addActionListener(new EscuchadorAccionModoTeclado());
        botonModoLibre.addActionListener(new EscuchadorAccionModoLibre());
        grupoDeBotones.add(botonModoRaton);
        grupoDeBotones.add(botonModoTeclado);
        grupoDeBotones.add(botonModoLibre);
        menuModo.add(botonModoRaton);
        menuModo.add(botonModoTeclado);
        menuModo.add(botonModoLibre);
        
        barraMenus.setLayout(new BorderLayout());
        barraMenus.add(menuModo, BorderLayout.LINE_START);
        barraMenus.setBorder(new EmptyBorder(0,0,0,0));
        panelModo.setModo(Modo.LIBRE);
        barraMenus.add(panelModo, BorderLayout.CENTER);
        return barraMenus;
    }
    
    /**
     * Método principal del programa que inicia la calculadora.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        new Calculadora();
    }
    
    /**
     * Clase que representa al escuchador de acción del botón del modo ratón.
     */
    private class EscuchadorAccionModoRaton implements ActionListener{
        
            @Override
            public void actionPerformed(ActionEvent e){
                panelModo.setModo(Modo.RATON);
                panelModo.repaint();
                removeKeyListener(escuchadorTeclado);
                panelBotones.eliminarEscuchadorRatonBotones();
                panelBotones.anadirEscuchadorRatonBotones();
            }
    }
    
    /**
     * Clase que representa al escuchador de acción del botón del modo teclado.
     */
    private class EscuchadorAccionModoTeclado implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            panelModo.setModo(Modo.TECLADO);
            panelModo.repaint();
            removeKeyListener(escuchadorTeclado);
            addKeyListener(escuchadorTeclado);
            panelBotones.eliminarEscuchadorRatonBotones();
        }
    }
    
    /**
     * Clase que representa al escuchador de acción del botón del modo libre.
     */
    private class EscuchadorAccionModoLibre implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            panelModo.setModo(Modo.LIBRE);
            panelModo.repaint();
            removeKeyListener(escuchadorTeclado);
            addKeyListener(escuchadorTeclado);
            panelBotones.eliminarEscuchadorRatonBotones();
            panelBotones.anadirEscuchadorRatonBotones();
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
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
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
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('0');
                }
                case KeyEvent.VK_NUMPAD1 -> {
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('1');
                }
                case KeyEvent.VK_NUMPAD2 -> {
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('2');
                }
                case KeyEvent.VK_NUMPAD3 -> {
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('3');
                }
                case KeyEvent.VK_NUMPAD4 -> {
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('4');
                }
                case KeyEvent.VK_NUMPAD5 -> {
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('5');
                }
                case KeyEvent.VK_NUMPAD6 -> {
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('6');
                }
                case KeyEvent.VK_NUMPAD7 -> {
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('7');
                }
                case KeyEvent.VK_NUMPAD8 -> {
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('8');
                }
                case KeyEvent.VK_NUMPAD9 -> {
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter('9');
                }
                case 10 ->{
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        try{
                            Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                            Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                            Calculadora.panel.setResultado(true);
                            String resultado = OperacionesTextoANumero.operar(Calculadora.panel.getTextoMostrado());
                            if(!resultado.equals(" ") && Double.parseDouble(resultado) < 0){
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
                        if(Calculadora.panel.isResultado()){
                            Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                            Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                            Calculadora.panel.limpiar();
                            Calculadora.panel.setResultado(false);
                        }
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter('+');
                    }
                }
                case 109 ->{
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        if(Calculadora.panel.isResultado()){
                            Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                            Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                            Calculadora.panel.limpiar();
                            Calculadora.panel.setResultado(false);
                        }
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter('-');
                    }
                }
                case 106 ->{
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter('*');
                    }
                }
                case 110 ->{
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter(',');
                    }
                }
                case 111 ->{
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                        Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.mostrarCaracter('/');
                    }
                }
                case KeyEvent.VK_ESCAPE ->{
                    if(Calculadora.panel.isResultado()){
                        Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                    Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                        Calculadora.panel.limpiar();
                        Calculadora.panel.setResultado(false);
                    }
                    if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                        Calculadora.panel.setForeground(Color.black);
                        panel.limpiar();
                    }
                }
            }
            
            if(ke.getKeyChar() == ',' && localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                if(Calculadora.panel.isResultado()){
                    Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                    Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                    Calculadora.panel.limpiar();
                    Calculadora.panel.setResultado(false);
                }
                if(localizacion == KeyEvent.KEY_LOCATION_NUMPAD){
                    Calculadora.panel.setForeground(Color.black);
                    panel.mostrarCaracter(',');
                }
            }
        }
    }
    
    /**
     * Clase que representa al panel que muestra el modo
     * en el que se encuentra la calculadora en texto.
     */
    private class PanelModo extends JPanel{
       
        /**
         * Modo en el que se encuentra la calculadora.
         */
        private Modo modo;

        /**
         * Permite obtener el modo en el que se encuentra la calculadora.
         * @return Modo en el que se encuentra la calculadora.
         */
        public Modo getModo() {
            return modo;
        }

        /**
         * Permite establecer el modo en el que se encuentra la calculadora.
         * @param modo Modo en el que se encuentra la calculadora a establecer.
         */
        public void setModo(Modo modo) {
            this.modo = modo;
        }
        
        /**
         * Constructor de paneles que muestran el modo en el que se encuentra
         * la calculadora en texto.
         */
        public PanelModo(){
            setBackground(Color.WHITE);
        }
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            String modoString = "";
            int posicion_x = getWidth() / 2;
            int posicion_y = getHeight() / 2 + 12;
            g.setFont(new Font("Liberation Serif", Font.BOLD, 20));
            
            switch(modo){
                case Modo.LIBRE -> {modoString = "Libre";}
                case Modo.TECLADO -> {posicion_x -= 15; 
                                      modoString = "Teclado";}
                case Modo.RATON -> {modoString = "Ratón";}
            }
            g.drawString(modoString, posicion_x, posicion_y);
        }
    }
    
    /**
     * Clase enumerada con los modos posibles en los que puede encontrarse el programa.
     */
    private enum Modo{
        LIBRE,
        TECLADO,
        RATON;
    }
    
    /**
     * Clase que gestiona los eventos de ventana.
     */
    private class EscuchadorEventosVentana extends WindowAdapter{
        
        /**
         * Gestiona la ventana cuando es miminizada.
         * @param e Evento de ventana.
         */
        @Override
        public void windowIconified(WindowEvent e){
            panel.limpiar();
        }
        
        /**
         * Gestiona la ventana cuando cambia de estado.
         * @param e Evento de ventana.
         */
        @Override
        public void windowStateChanged(WindowEvent e){
            if(e.getNewState() == JFrame.MAXIMIZED_BOTH){
                panelBotones.aumentarTamanoTextoBotones();
                Calculadora.panel.setFont(new Font("Liberation Serif", Font.BOLD, 100));
                Calculadora.panelOperacion.setFont(new Font("Liberation Serif", Font.BOLD, 100));
            }
            else{
                if(e.getNewState() == JFrame.NORMAL){
                    panelBotones.disminuirTamanoTextoBotones();
                    Calculadora.panel.setFont(new Font("Liberation Serif", Font.BOLD, 50));
                    Calculadora.panelOperacion.setFont(new Font("Liberation Serif", Font.BOLD, 50));
                }
            }
        }
    }
}
