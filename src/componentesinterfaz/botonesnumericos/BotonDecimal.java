package componentesinterfaz.botonesnumericos;

import calculadora.Calculadora;
import componentesinterfaz.Boton;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que representa al botón que permite introducir la coma para los decimales.
 * @author Lois Domínguez Domínguez
 */
public class BotonDecimal extends Boton{
    
    /**
     * Constructor de botones que permiten introducir la coma para los decimales.
     */
    public BotonDecimal(){
        super(',');
        escuchadorRaton = new EscuchadorRaton();
        anadirEscuchadorRaton();
    }
    
    /**
     * Escuchador que gestiona los eventos del ratón.
     */
    private class EscuchadorRaton implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getButton() == MouseEvent.BUTTON1){
                Calculadora.panel.setForeground(Color.black);
                Calculadora.panel.mostrarCaracter(',');
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    
    }
}
