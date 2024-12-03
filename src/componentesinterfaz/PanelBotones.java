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
     * Panel de los botones numéricos de la calculadora.
     */
    private PanelBotonesNumericos panelBotonesNumericos;
    
    /**
     * Panel de los botones de operaciones de la calculadora;
     */
    private PanelBotonesOperaciones panelBotonesOperaciones;
    
    /**
     * Constructor del panel que contiene al panel de botones numéricos y el de operaciones.
     */
    public PanelBotones(){
        setLayout(new GridLayout(1,2));
        setSize(Calculadora.anchuraCalculadoraNoPantallaCompleta , (Calculadora.alturaCalculadoraNoPantallaCompleta * 5) / 6);
        panelBotonesNumericos = new PanelBotonesNumericos();
        panelBotonesOperaciones = new PanelBotonesOperaciones();
        add(panelBotonesNumericos);
        add(panelBotonesOperaciones);
    }
    
    /**
     * Elimina el escuchador del ratón de todos los botones de los paneles.
     */
    public void eliminarEscuchadorRatonBotones(){
        panelBotonesNumericos.eliminarEscuchadorRatonBotones();
        panelBotonesOperaciones.eliminarEscuchadorRatonBotones();
    }
    
    /**
     * Añade el escuchador del ratón a todos los botones de los paneles.
     */
    public void anadirEscuchadorRatonBotones(){
        panelBotonesNumericos.anadirEscuchadorRatonBotones();
        panelBotonesOperaciones.anadirEscuchadorRatonBotones();
    }
}
