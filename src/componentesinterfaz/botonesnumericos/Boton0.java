package componentesinterfaz.botonesnumericos;

import componentesinterfaz.Boton;
import calculadora.Calculadora;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que representa al botón del número 0 de la calculadora.
 * @author Lois Domínguez Domínguez
 */
public class Boton0 extends Boton{
    
    /**
     * Constructor de botones del número 0 de la calculadora.
     */
    public Boton0(){
        super('0');
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
                if(Calculadora.panel.isResultado()){
                    Calculadora.panel.limpiar();
                    Calculadora.panel.setResultado(false);
                }
                Calculadora.panel.setForeground(Color.black);
                Calculadora.panel.mostrarCaracter('0');
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
