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
    
    /**
     * Botones de operaciones de la calculadora.
     */
    Boton[] botones = new Boton[6];
    
    /**
     * Constructor de paneles de los botones de operaciones de la calculadora.
     */
    public PanelBotonesOperaciones(){
        setLayout(new GridLayout(3,2));
        setSize((Calculadora.anchuraCalculadoraNoPantallaCompleta * 1) / 4, (Calculadora.alturaCalculadoraNoPantallaCompleta * 5) / 6);
        botones[0] = new BotonSuma();
        botones[1] = new BotonResta();
        botones[2] = new BotonMultiplicacion();
        botones[3] = new BotonDivisor();
        botones[4] = new BotonBorrado();
        botones[5] = new BotonIgual();
        for(Boton boton : botones){
            add(boton);
        }
    }
    
    /**
     * Elimina el escuchador del ratón de los botones de operaciones de la calculadora.
     */
    public void eliminarEscuchadorRatonBotones(){
        for(Boton boton : botones){
            boton.eliminarEscuchadorRaton();
        }
    }
    
    /**
     * Añade el escuchador del ratón de los botones de operaciones de la calculadora.
     */
    public void anadirEscuchadorRatonBotones(){
        for(Boton boton : botones){
            boton.anadirEscuchadorRaton();
        }
    }
}
