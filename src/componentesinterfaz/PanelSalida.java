package componentesinterfaz;

import calculadora.Calculadora;
import static calculadora.Calculadora.panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
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
     * Constructor de paneles de salida.
     */
    public PanelSalida(){
        super(" ");
        setHorizontalAlignment(SwingConstants.RIGHT);
        setOpaque(true);
        setFont(new Font("Liberation Serif", Font.BOLD, 100));
        setSize(Calculadora.anchuraCalculadoraNoPantallaCompleta, Calculadora.alturaCalculadoraNoPantallaCompleta / 6);
        setBackground(Color.WHITE);
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
    
}
