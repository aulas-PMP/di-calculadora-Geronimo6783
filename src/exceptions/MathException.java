package exceptions;

/**
 * Excepción lanzada cuando no se puede realizar una operación matemática por ser imposible.
 * @author Lois Domínguez Domínguez
 */
public class MathException extends Exception{
    
    /**
     * Constructor de excepciones lanzadas cuando no se puede realizar una operación matemática
     * por ser imposible.
     */
    public MathException(){
        super("Math Error");
    }
}
