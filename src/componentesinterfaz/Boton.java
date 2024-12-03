package componentesinterfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * Clase que representa a un botón de la interfaz gráfica de la calculadora.
 * @author Lois Domínguez Domínguez
 */
public abstract class Boton extends JButton{
    
    /**
     * Gestiona los eventos del ratón.
     */
    protected MouseListener escuchadorRaton;
    
    /**
     * Constructor de botones de la calculadora.
     * @param caracter Caracter que mostrará el botón.
     */
    protected Boton(char caracter){
        super(Character.toString(caracter));
        setFocusable(false);
        setFont(new Font("Liberation Serif", Font.BOLD, 25));
        setBackground(new Color(255,255,255));
        setBorder(new EmptyBorder(30,30,30,30));
    }
    
    /**
     * Elimina el escuchador del ratón.
     */
    public void eliminarEscuchadorRaton(){
        removeMouseListener(escuchadorRaton);
    }
    
    /**
     * Añade el escuchador del ratón.
     */
    public void anadirEscuchadorRaton(){
        addMouseListener(escuchadorRaton);
    }
}
