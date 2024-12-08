package componentesinterfaz;

import calculadora.Calculadora;
import componentesinterfaz.botonesnumericos.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 * Clase que representa al panel de los botones donde
 * van los botones numéricos de la calculadora.
 * @author Lois Domínguez Domínguez
 */
public class PanelBotonesNumericos extends JPanel{
    
    /**
     * Botones numéricos de la calculadora.
     */
    Boton[] botones = new Boton[11];
    
    /**
     * Constructor de un panel de botones donde van los
     * botones numeŕicos y de operaciones.
     */
    public PanelBotonesNumericos(){
        setLayout(new GridBagLayout());
        GridBagConstraints restriccionesLayout = new GridBagConstraints();
        restriccionesLayout.weightx = (Calculadora.anchuraCalculadoraNoPantallaCompleta * 3) / 4;
        restriccionesLayout.weighty = (Calculadora.alturaCalculadoraNoPantallaCompleta * 5) / 6;
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 2;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 3;
        botones[0] = new Boton0();
        add(botones[0], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 2;
        restriccionesLayout.gridy = 3;
        botones[1] = new BotonDecimal();
        add(botones[1], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 2;
        botones[2] = new Boton1();
        add(botones[2], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 1;
        restriccionesLayout.gridy = 2;
        botones[3] = new Boton2();
        add(botones[3], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 2;
        restriccionesLayout.gridy = 2;
        botones[4] = new Boton3();
        add(botones[4], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 1;
        botones[5] = new Boton4();
        add(botones[5], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 1;
        restriccionesLayout.gridy = 1;
        botones[6] = new Boton5();
        add(botones[6], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 2;
        restriccionesLayout.gridy = 1;
        botones[7] = new Boton6();
        add(botones[7], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 0;
        botones[8] = new Boton7();
        add(botones[8], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 1;
        restriccionesLayout.gridy = 0;
        botones[9] = new Boton8();
        add(botones[9], restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 2;
        restriccionesLayout.gridy = 0;
        botones[10] = new Boton9();
        add(botones[10], restriccionesLayout);
    }
    
    /**
     * Elimina el escuchador del ratón de todos lo botones del panel.
     */
    public void eliminarEscuchadorRatonBotones(){
        for(Boton boton : botones){
            boton.eliminarEscuchadorRaton();
        }
    }
    
    /**
     * Añade el escuchador del ratón a todos los botones del panel.
     */
    public void anadirEscuchadorRatonBotones(){
        for(Boton boton : botones){
            boton.anadirEscuchadorRaton();
        }
    }
    
    /**
     * Aumenta el tamaño del texto de los botones del panel.
     */
    public void aumentarTamanoTextoBotones(){
        for(Boton boton : botones){
            boton.aumentarTamanoTexto();
        }
    }
    
    /**
     * Disminuye el tamaño del texto de los botones del panel.
     */
    public void disminuirTamanoTextoBotones(){
        for(Boton boton : botones){
            boton.disminuirTamanoTexto();
        }
    }
}
