package componentesinterfaz.botonesoperaciones;

import calculadora.Calculadora;
import componentesinterfaz.Boton;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que representa al botón de la operación de división de la calculadora.
 * @author Lois Domínguez Domínguez
 */
public class BotonBorrado extends Boton{
    
    /**
     * Constructor de botones de la operación de división de la calculadora.
     */
    public BotonBorrado(){
        super('←');
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
                if(Calculadora.panel.isResultado()){
                    Calculadora.panel.limpiar();
                    Calculadora.panel.setResultado(false);
                }
                Calculadora.panel.setForeground(Color.black);
                String textoAMostrar = Calculadora.panel.getTextoMostrado();
                int tamanoTexto = textoAMostrar.length();
                if(tamanoTexto > 1){
                    textoAMostrar = textoAMostrar.substring(0, textoAMostrar.length() - 1);
                    Calculadora.panel.setTextoMostrado(textoAMostrar);
                }
                else{
                    if(tamanoTexto == 1){
                        Calculadora.panel.limpiar();
                    }
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