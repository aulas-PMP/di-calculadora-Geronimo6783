package calculadora;

import componentesinterfaz.PanelBotones;
import javax.swing.*;
import componentesinterfaz.PanelSalida;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;

/**
 * Clase principal del programa que representa a una calculadora.
 * @author Lois Domínguez Domínguez
 */
public class Calculadora {
    
    /**
     * Panel de salida de la calculadora.
     */
    public static PanelSalida panel = new PanelSalida();
    
    public static final int alturaCalculadoraNoPantallaCompleta = 600;
    
    public static int anchuraCalculadoraNoPantallaCompleta;
    
    /**
     * Constructor de calculadoras.
     */
    private Calculadora(){
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = pantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchuraPantalla = tamanoPantalla.width;
        
        JFrame marco = new JFrame();
        marco.setTitle("Calculadora Lois Domínguez Domínguez");
        marco.setLayout(new BoxLayout(marco.getContentPane(), BoxLayout.Y_AXIS));
        anchuraCalculadoraNoPantallaCompleta = anchuraPantalla/2;
        marco.setBounds(anchuraPantalla/4, (alturaPantalla - 600)/2, anchuraCalculadoraNoPantallaCompleta, 600);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelSalida = new JPanel();
        panelSalida.setSize(Calculadora.anchuraCalculadoraNoPantallaCompleta , Calculadora.alturaCalculadoraNoPantallaCompleta / 6);
        panelSalida.setLayout(new BorderLayout());
        panelSalida.add(panel, BorderLayout.CENTER);
        marco.add(Calculadora.generarBarraDeMenus());
        marco.add(panelSalida);
        marco.add(new PanelBotones());
        marco.setVisible(true);
    }
    
    /**
     * Genera una barra de menús en la que puedes seleccionar el modo de la calculadora a usar.
     * @return Barra de menús en la que puedes seleccionar el modo de la calculadora a usar.
     */
    private static JMenuBar generarBarraDeMenus(){
        JMenuBar barraMenus = new JMenuBar();
        JMenu menuModo = new JMenu("Modo");
        
        ButtonGroup grupoDeBotones = new ButtonGroup();
        JRadioButtonMenuItem botonModoRaton = new JRadioButtonMenuItem("Ratón");
        JRadioButtonMenuItem botonModoTeclado = new JRadioButtonMenuItem("Teclado numérico");  
        JRadioButtonMenuItem botonModoLibre = new JRadioButtonMenuItem("Libre");
        botonModoLibre.setSelected(true);
        grupoDeBotones.add(botonModoRaton);
        grupoDeBotones.add(botonModoTeclado);
        grupoDeBotones.add(botonModoLibre);
        menuModo.add(botonModoRaton);
        menuModo.add(botonModoTeclado);
        menuModo.add(botonModoLibre);
        
        barraMenus.setLayout(new BorderLayout());
        barraMenus.add(menuModo, BorderLayout.LINE_START);
        return barraMenus;
    }
    
    public static void main(String[] args) {
        new Calculadora();
    }
    
}
