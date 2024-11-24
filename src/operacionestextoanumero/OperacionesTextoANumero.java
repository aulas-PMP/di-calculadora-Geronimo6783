package operacionestextoanumero;

import exceptions.MathException;
import java.util.ArrayList;

/**
 * Clase que contiene utilidades para realizar operaciones matemáticas
 * almacenadas como una cadena de caracteres.
 * @author Lois Domínguez Domínguez
 */
public class OperacionesTextoANumero {
    
    /**
     * Números contenidos en el texto.
     */
    private static ArrayList<Number> numeros;
    
    /**
     * Operadores contenidas en el texto.
     */
    private static ArrayList<Character> operadores;
    
    /**
     * 
     * @param textoOperaciones
     * @return
     * @throws MathException 
     */
    public static String operar(String textoOperaciones) throws MathException {
        textoOperaciones.replaceAll(",", ".");
        char[] caracteresTextoOperaciones = textoOperaciones.toCharArray();
        
        String numero = "";
        char caracter;
        
        for(int i = 0; i < caracteresTextoOperaciones.length; i++){
            caracter = caracteresTextoOperaciones[i];
            
            switch(caracter){
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ->{
                    numero += caracter;
                }
                
                case '+', '*', '/' -> {
                    
                }
                
                case '-' -> {
                    
                    if(caracteresTextoOperaciones[i - 1] == '0' || caracteresTextoOperaciones[i - 1] == '1' || 
                       caracteresTextoOperaciones[i - 1] == '2' || caracteresTextoOperaciones[i - 1] == '3' || 
                       caracteresTextoOperaciones[i - 1] == '4' || caracteresTextoOperaciones[i - 1] == '5' || 
                       caracteresTextoOperaciones[i - 1] == '6' || caracteresTextoOperaciones[i - 1] == '7' || 
                       caracteresTextoOperaciones[i - 1] == '8' || caracteresTextoOperaciones[i - 1] == '9'){
                        
                        operadores.add(caracter);
                    }
                    else{
                        numero += caracter;
                    }
                }
                
                case '.' -> {
                    
                    if(caracteresTextoOperaciones[i - 1] == '0' || caracteresTextoOperaciones[i - 1] == '1' || 
                       caracteresTextoOperaciones[i - 1] == '2' || caracteresTextoOperaciones[i - 1] == '3' || 
                       caracteresTextoOperaciones[i - 1] == '4' || caracteresTextoOperaciones[i - 1] == '5' || 
                       caracteresTextoOperaciones[i - 1] == '6' || caracteresTextoOperaciones[i - 1] == '7' || 
                       caracteresTextoOperaciones[i - 1] == '8' || caracteresTextoOperaciones[i - 1] == '9'){
                        
                        numero += caracter;
                    }
                    else{
                        throw new MathException();
                    }
                }
            }
        }
    }
    
    /**
     * Convierte una cadena de caracteres a un número.
     * @param numero Cadena de convertir a número.
     * @return Cadena de caracteres convertida en número.
     * @throws MathException Cuando la cadena de caracteres no se puede transformar a número.
     */
    private static Number stringANumero(String numero) throws MathException {
        try{
            return Double.valueOf(numero);
        }
        catch(NumberFormatException e){
            try{
                return  Long.valueOf(numero);
            }
            catch(NumberFormatException ex){
                throw new MathException();
            }
        }
    }
}
