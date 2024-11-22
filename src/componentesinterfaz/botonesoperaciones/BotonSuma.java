package componentesinterfaz.botonesoperaciones;

import calculadora.Calculadora;
import componentesinterfaz.Boton;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que representa al botón de la operación de adición de la calculadora.
 * @author Lois Domínguez Domínguez
 */
public class BotonSuma extends Boton{
    
    /**
     * Constructor de botones de la operación de adición de la calculadora.
     */
    public BotonSuma(){
        super('+');
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
                Calculadora.panel.mostrarCaracter('+');
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
