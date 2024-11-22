package componentesinterfaz;

import javax.swing.BoxLayout;
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
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(new PanelBotonesNumericos());
        add(new PanelBotonesOperaciones());
    }
}
