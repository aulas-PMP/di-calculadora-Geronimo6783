package componentesinterfaz;

import calculadora.Calculadora;
import static calculadora.Calculadora.panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Clase que representa al panel donde se muestran los resultados
 * de las operaciones y las acciones que realiza el usuario.
 * @author Lois Domínguez Domínguez
 */
public class PanelSalida extends JLabel{
    
    /**
     * Texto mostrado por pantalla.
     */
    private String textoMostrado = "";
    
    /**
     * Objeto que se encarga de la gestión de los eventos de teclado.
     */
    private final EscuchadorTeclado escuchadorTeclado = new EscuchadorTeclado();
    
    /**
     * Constructor de paneles de salida.
     */
    public PanelSalida(){
        super(" ");
        setHorizontalAlignment(SwingConstants.RIGHT);
        setOpaque(true);
        setFont(new Font("Liberation Serif", Font.BOLD, 100));
        setSize(Calculadora.anchuraCalculadoraNoPantallaCompleta, Calculadora.alturaCalculadoraNoPantallaCompleta / 6);
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(escuchadorTeclado);
    }

    /**
     * Permite obtener el texto que se muestra por pantalla.
     * @return Texto que se muestra por pantalla.
     */
    public String getTextoMostrado() {
        return textoMostrado;
    }

    /**
     * Permite establecer el texto que se muestra por pantalla.
     * @param textoMostrado Texto que se muestra por pantalla a establecer. 
     */
    public void setTextoMostrado(String textoMostrado) {
        this.textoMostrado = textoMostrado;
        setText(textoMostrado);
    }
    
    /**
     * Muestra un caracter a mayores por pantalla.
     * @param caracter Caracter a mayores a mostrar por pantalla.
     */
    public void mostrarCaracter(char caracter){
        textoMostrado += caracter;
        setText(textoMostrado);
    }
    
    /**
     * Limpia el panel haciendo que no muestre nada más por pantalla.
     */
    public void limpiar(){
        textoMostrado = "";
        setText(" ");
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
                        panel.mostrarCaracter('*');
                    }
                }
                case KeyEvent.VK_SLASH ->{
                    if(ke.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD){
                        panel.mostrarCaracter('/');
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
