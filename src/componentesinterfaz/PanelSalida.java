package componentesinterfaz;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase que representa al panel donde se muestran los resultados
 * de las operaciones y las acciones que realiza el usuario.
 * @author Lois Domínguez Domínguez
 */
public class PanelSalida extends JTextField{
    
    /**
     * Texto mostrado por pantalla.
     */
    private String textoMostrado = "";
    
    /**
     * Constructor de paneles de salida.
     */
    public PanelSalida(){
        super();
        setHorizontalAlignment(SwingConstants.RIGHT);
        setOpaque(true);
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
        setText("");
    }
}
