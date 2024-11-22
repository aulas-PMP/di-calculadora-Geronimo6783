package componentesinterfaz;

import componentesinterfaz.botonesnumericos.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Clase que representa al panel de los botones donde
 * van los botones numéricos y de operaciones.
 * @author Lois Domínguez Domínguez
 */
public class PanelBotonesNumericos extends JPanel{
    
    /**
     * Constructor de un panel de botones donde van los
     * botones numeŕicos y de operaciones.
     */
    public PanelBotonesNumericos(){
        setLayout(new GridBagLayout());
        GridBagConstraints restriccionesLayout = new GridBagConstraints();
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 3;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 3;
        add(new Boton0(), restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 2;
        add(new Boton1(), restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 1;
        restriccionesLayout.gridy = 2;
        add(new Boton2(), restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 2;
        restriccionesLayout.gridy = 2;
        add(new Boton3(), restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 1;
        add(new Boton4(), restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 1;
        restriccionesLayout.gridy = 1;
        add(new Boton5(), restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 2;
        restriccionesLayout.gridy = 1;
        add(new Boton6(), restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 0;
        add(new Boton7(), restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 1;
        restriccionesLayout.gridy = 0;
        add(new Boton8(), restriccionesLayout);
        
        restriccionesLayout.fill = GridBagConstraints.BOTH;
        restriccionesLayout.gridwidth = 1;
        restriccionesLayout.gridheight = 1;
        restriccionesLayout.gridx = 2;
        restriccionesLayout.gridy = 0;
        add(new Boton9(), restriccionesLayout);
    }
}
