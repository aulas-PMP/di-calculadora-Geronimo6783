package componentesinterfaz.botonesoperaciones;

import calculadora.Calculadora;
import componentesinterfaz.Boton;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que representa al botón que permite realizar la operación introducida en la calculadora.
 * @author Lois Domínguez Domínguez
 */
public class BotonIgual extends Boton{
      
    /**
     * Constructor de botones que permiten realizar la operación introducida en la calculadora.
     */
    public BotonIgual(){
        super('=');
        addMouseListener(new EscuchadorRaton());
        setBackground(new Color(255,128,0));
    }
    
    /**
     * Escuchador que gestiona los eventos del ratón.
     */
    private class EscuchadorRaton implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getButton() == MouseEvent.BUTTON1){
                //Realizar la operación y mostrar resultado por pantalla.
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
