package calculadora;

import componentesinterfaz.PanelBotones;
import componentesinterfaz.PanelBotonesNumericos;
import componentesinterfaz.PanelBotonesOperaciones;
import javax.swing.*;
import componentesinterfaz.PanelSalida;
import componentesinterfaz.botonesnumericos.*;
import componentesinterfaz.botonesoperaciones.*;
import java.awt.Dimension;
import java.awt.GridLayout;
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
    
    /**
     * Constructor de calculadoras.
     */
    private Calculadora(){
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = pantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchuraPantalla = tamanoPantalla.width;
        
        JFrame marco = new JFrame();
        marco.setTitle("Calculadora");
        marco.setLayout(new BoxLayout(marco.getContentPane(), BoxLayout.Y_AXIS));
        marco.setBounds(anchuraPantalla/4, (alturaPantalla - 600)/2, anchuraPantalla/2, 600);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelSalida = new JPanel();
        panelSalida.add(panel);
        marco.add(panelSalida);
        marco.add(new PanelBotones());
        marco.addKeyListener(new EscuchadorTeclado());
        marco.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Calculadora();
    }
    
    /**
     * Clase interna que se encarga de gestionar los eventos del teclado.
     */
    private static class EscuchadorTeclado implements KeyListener{

        /**
         * Gestiona cuando las teclas del teclado numérico son pulsadas.
         * @param ke Evento del teclado.
         */
        @Override
        public void keyTyped(KeyEvent ke) {
            switch(ke.getKeyCode()){
                case KeyEvent.VK_NUMPAD0 -> {panel.mostrarCaracter('0');}
                case KeyEvent.VK_NUMPAD1 -> {panel.mostrarCaracter('1');}
                case KeyEvent.VK_NUMPAD2 -> {panel.mostrarCaracter('2');}
                case KeyEvent.VK_NUMPAD3 -> {panel.mostrarCaracter('3');}
                case KeyEvent.VK_NUMPAD4 -> {panel.mostrarCaracter('4');}
                case KeyEvent.VK_NUMPAD5 -> {panel.mostrarCaracter('5');}
                case KeyEvent.VK_NUMPAD6 -> {panel.mostrarCaracter('6');}
                case KeyEvent.VK_NUMPAD7 -> {panel.mostrarCaracter('7');}
                case KeyEvent.VK_NUMPAD8 -> {panel.mostrarCaracter('8');}
                case KeyEvent.VK_NUMPAD9 -> {panel.mostrarCaracter('9');}
                case KeyEvent.VK_PLUS ->{
                    if(ke.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD){
                        panel.mostrarCaracter('+');
                    }
                }
                case KeyEvent.VK_MINUS ->{
                    if(ke.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD){
                        panel.mostrarCaracter('-');
                    }
                }
                case KeyEvent.VK_ASTERISK ->{
                    if(ke.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD){
                        panel.mostrarCaracter('x');
                    }
                }
                case KeyEvent.VK_SLASH ->{
                    if(ke.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD){
                        panel.mostrarCaracter('÷');
                    }
                }
                case KeyEvent.VK_ESCAPE ->{
                    if(ke.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD){
                        panel.limpiar();
                    }
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }    
    }
}
