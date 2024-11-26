package operacionestextoanumero;

import exceptions.MathException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que contiene utilidades para realizar operaciones matemáticas
 * almacenadas como una cadena de caracteres.
 * @author Lois Domínguez Domínguez
 */
public class OperacionesTextoANumero {
    
    /**
     * Números contenidos en el texto.
     */
    private static ArrayList<Number> numeros = new ArrayList<>();
    
    /**
     * Operadores contenidas en el texto.
     */
    private static ArrayList<Character> operadores = new ArrayList<>();
    
    /**
     * Realiza las operaciones matemáticas de un texto.
     * @param textoOperaciones Texto que contiene las operaciones matemáticas.
     * @return Resultado obtenido al realizar las operaciones.
     * @throws MathException Cuando las operaciones matemáticas del texto no se pueden realizar.
     */
    public static String operar(String textoOperaciones) throws MathException {
        obtenerNumeroYOperadores(textoOperaciones);
        Iterator<Number> iteradorNumeros = numeros.iterator();
        Iterator<Character> iteradorOperadores = operadores.iterator();
        char operador;
        Number operando1;
        Number operando2;
        Number resultadoOperacion = 0;
        int numeroRecorrido = 0;
        
        while(iteradorOperadores.hasNext()){
            operador = iteradorOperadores.next();
            operando1 = iteradorNumeros.next();
            operando2 = iteradorNumeros.next();
            
            if(operador == '*' || operador == '/'){
                switch(operador){
                    case '*' -> {
                        if(operando1 instanceof Double || operando2 instanceof Double){
                            resultadoOperacion = operando1.doubleValue() * operando2.doubleValue();
                        }
                        else{
                            resultadoOperacion = operando1.longValue() * operando2.longValue();
                        }
                    } 
                    case '/' -> {                       
                        resultadoOperacion = operando1.doubleValue() / operando2.doubleValue();
                   }
                }
                
                iteradorOperadores.remove();
                operando1 = resultadoOperacion;
                iteradorNumeros.remove();
                iteradorNumeros = numeros.iterator();
                numeroRecorrido++;
                
                for(int i = 0; i < numeroRecorrido; i++){
                    operando1 = iteradorNumeros.next();
                }
            }
        }
        
        iteradorNumeros = numeros.iterator();
        iteradorOperadores = operadores.iterator();
        numeroRecorrido = 0;
        
        while(iteradorOperadores.hasNext()){
            operador = iteradorOperadores.next();
            operando1 = iteradorNumeros.next();
            operando2 = iteradorNumeros.next();
            
            switch(operador){
                case '+' ->{
                    if(operando1 instanceof Double || operando2 instanceof Double){
                        resultadoOperacion = operando1.doubleValue() + operando2.doubleValue();
                    }
                    else{
                        resultadoOperacion = operando1.longValue() + operando2.longValue();
                    }
                }
                case '-' ->{
                    if(operando1 instanceof Double || operando2 instanceof Double){
                        resultadoOperacion = operando1.doubleValue() - operando2.doubleValue();
                    }
                    else{
                        resultadoOperacion = operando1.longValue() - operando2.longValue();
                    }
                }
            }
            
            iteradorOperadores.remove();
            operando1 = resultadoOperacion;
            iteradorNumeros.remove();
            iteradorNumeros = numeros.iterator();
            numeroRecorrido++;
            
            for(int i = 0; i < numeroRecorrido; i++){
                operando1 = iteradorNumeros.next();
            }
        }
        
        if(resultadoOperacion instanceof Double){
            return Double.toString(resultadoOperacion.doubleValue());
        }
        else{
            return Long.toString(resultadoOperacion.longValue());
        }
    }
    
    /**
     * Carga los números y los operadores en memoria.
     * @param textoOperaciones Texto con las operaciones matemáticas a realizar.
     */
    private static void obtenerNumeroYOperadores(String textoOperaciones) throws MathException {
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
                    if(numero.isEmpty()){
                        throw new MathException();
                    }
                    else{  
                        numeros.add(stringANumero(numero));  
                        numero = "";
                        operadores.add(caracter);
                    }
                }
                
                case '-' -> {
                    
                    if(i != 0 || caracteresTextoOperaciones[i - 1] == '0' || caracteresTextoOperaciones[i - 1] == '1' || 
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
