package componentesinterfaz;

import calculadora.Calculadora;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Clase que representa al panel que contiene al panel de botones numéricos y el de operaciones.
 * @author Lois Domínguez Domínguez
 */
public class PanelBotones extends JPanel{
    
    /**
     * Constructor del panel que contiene al panel de botones numéricos y el de operaciones.
     */
    public PanelBotones(){
        setLayout(new GridLayout(1,2));
        setSize(Calculadora.anchuraCalculadoraNoPantallaCompleta , (Calculadora.alturaCalculadoraNoPantallaCompleta * 5) / 6);
        add(new PanelBotonesNumericos());
        add(new PanelBotonesOperaciones());
    }
}
