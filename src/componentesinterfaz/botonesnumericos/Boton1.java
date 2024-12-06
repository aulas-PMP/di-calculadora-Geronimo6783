package componentesinterfaz.botonesnumericos;

import calculadora.Calculadora;
import componentesinterfaz.Boton;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que representa al botón del número 1 de la calculadora.
 * @author Lois Domínguez Domínguez
 */
public class Boton1 extends Boton{
    
    /**
     * Constructor de botones del número 1 de la calculadora.
     */
    public Boton1(){
        super('1');
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
                Calculadora.panel.mostrarCaracter('1');
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
