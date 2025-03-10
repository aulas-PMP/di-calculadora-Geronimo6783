package componentesinterfaz.botonesoperaciones;

import calculadora.Calculadora;
import componentesinterfaz.Boton;
import exceptions.MathException;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import operacionestextoanumero.OperacionesTextoANumero;

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
        escuchadorRaton = new EscuchadorRaton();
        anadirEscuchadorRaton();
        setBackground(new Color(255,128,0));
    }
    
    /**
     * Escuchador que gestiona los eventos del ratón.
     */
    private class EscuchadorRaton implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getButton() == MouseEvent.BUTTON1){
                try{
                    Calculadora.panel.setResultado(true);
                    String resultado = OperacionesTextoANumero.operar(Calculadora.panel.getTextoMostrado());
                    if(!resultado.equals(" ") && Double.parseDouble(resultado) < 0){
                        Calculadora.panel.setForeground(Color.red);
                    }
                    else{
                        Calculadora.panel.setForeground(Color.black);
                    }
                    Calculadora.panel.setTextoMostrado(resultado.replace(".", ","));
                    Calculadora.panelOperacion.setForeground(Calculadora.panel.getForeground());
                    Calculadora.panelOperacion.setTextoMostrado(Calculadora.panel.getTextoMostrado());
                }
                catch(MathException e){
                    Calculadora.panel.setTextoMostrado("Math Error");
                }
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
