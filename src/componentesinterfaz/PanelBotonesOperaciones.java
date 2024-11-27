package componentesinterfaz;

import calculadora.Calculadora;
import componentesinterfaz.botonesoperaciones.BotonBorrado;
import componentesinterfaz.botonesoperaciones.BotonDivisor;
import componentesinterfaz.botonesoperaciones.BotonIgual;
import componentesinterfaz.botonesoperaciones.BotonMultiplicacion;
import componentesinterfaz.botonesoperaciones.BotonResta;
import componentesinterfaz.botonesoperaciones.BotonSuma;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Panel de los botones de operaciones de la calculadora.
 * @author Lois Domínguez Domínguez
 */
public class PanelBotonesOperaciones extends JPanel{
    
    public PanelBotonesOperaciones(){
        setLayout(new GridLayout(3,2));
        setSize((Calculadora.anchuraCalculadoraNoPantallaCompleta * 1) / 4, (Calculadora.alturaCalculadoraNoPantallaCompleta * 5) / 6);
        add(new BotonSuma());
        add(new BotonResta());
        add(new BotonMultiplicacion());
        add(new BotonDivisor());
        add(new BotonBorrado());
        add(new BotonIgual());
    }
}
