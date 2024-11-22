package componentesinterfaz;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * Clase que representa a un botón de la interfaz gráfica de la calculadora.
 * @author Lois Domínguez Domínguez
 */
public abstract class Boton extends JButton{
    
    /**
     * Constructor de botones de la calculadora.
     * @param caracter Caracter que mostrará el botón.
     */
    protected Boton(char caracter){
        super(Character.toString(caracter));
        setBackground(new Color(255,255,255));
        setBorder(new EmptyBorder(30,30,30,30));
    }
}
