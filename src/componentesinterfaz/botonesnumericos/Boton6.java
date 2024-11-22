package componentesinterfaz.botonesnumericos;

import calculadora.Calculadora;
import componentesinterfaz.Boton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que representa al botón del número 6 de la calculadora.
 * @author Lois Domínguez Domínguez
 */
public class Boton6 extends Boton{
    
    /**
     * Constructor de botones del número 6 de la calculadora.
     */
    public Boton6(){
        super('6');
        addMouseListener(new EscuchadorRaton());
    }
    
    /**
     * Escuchador que gestiona los eventos del ratón.
     */
    private class EscuchadorRaton implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getButton() == MouseEvent.BUTTON1){
                Calculadora.panel.mostrarCaracter('6');
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
