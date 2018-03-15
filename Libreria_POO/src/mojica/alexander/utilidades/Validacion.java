/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.utilidades;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;

/**
 *
 * @author MekakuZero
 */
public class Validacion {
    
    public static final String NOMBRES = "^([a-zA-Z]+( [a-zA-Z]+)?)$";
    public static final String NONUMERO = "^[a-zA-Z ]*$";
    
    public static Calendar toCalendar(java.util.Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
    public static boolean valaidadTexto(JLabel lblError, String texto){
        // Si no esta vacio o no esta vacio
        if (texto != null && !texto.isEmpty()) {
            lblError.setText("");
            return true;
        } else
            lblError.setText("El campo es obligatorio");
        
        return false;
    }
    
    public static boolean valaidadTexto(JLabel lblError, String texto, String expresion){
        // Si no esta vacio o no esta vacio
        if (texto != null && !texto.isEmpty()) {
            if (compararExpresion(texto, expresion)) {
                lblError.setText("");
                return true;
            }
            
            lblError.setText("El formato es inadecuado");
            return true;
        } else
            lblError.setText("El campo es obligatorio");
        
        return false;
    }
    
    // Validar texto que pueda ser nulo
    public static boolean valaidadTextoNuleable(JLabel lblError, String texto, String expresion){
        // Si no esta vacio o no esta vacio
        if (texto == null || texto.isEmpty()) {
            lblError.setText("");
            return true;
        } else {
            if (compararExpresion(texto, expresion)) {
                lblError.setText("");
                return true;
            }
        }
        
        lblError.setText("El formato es inadecuado");
        return false;
    }
    
    private static boolean compararExpresion(String texto, String expresion){
        Pattern pat = Pattern.compile(expresion);
        Matcher mat = pat.matcher(texto);
     
        return mat.matches();
    }
    
    public static boolean noNulo(JLabel lblError, Object obj){
        if(obj != null){
            lblError.setText("");
            return true;
        }
        
        lblError.setText("El campo no puede estar vacio");
        
        return false;
    }
}
