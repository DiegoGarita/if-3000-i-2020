
package edu.ucr.rp.lab2.generator;

import java.util.Arrays;
import java.util.Collections;


public class PasswordGenerator {

    //objetos
    private Integer minSpecialChars;
    private Integer minUpperCase;
    private Integer minNumbers;
    private Integer minLength;
    private char[] specialChars;
    private Integer maxLength;
    
    //llena los Strings posibles
     public int numbers[]={1,2,3,4,5,6,7,8,9,0};
     public String Uppers[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"} ;     
     public String Others[]={"1","2","3","4","5","6","7","8","9","0","a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z","#","%","@","/","*"};
     public String [] carac = {"#","%","@","/","*"};// establecemos los caracteres por defecto
     
     //guarda para los faltantes
     public int faltantes =0;

    //constructor
    public PasswordGenerator(Integer minSpecialChars, Integer minUpperCase, Integer minNumbers, Integer minLength, char[] specialChars, Integer maxLength) {
        this.minSpecialChars = minSpecialChars;
        this.minUpperCase = minUpperCase;
        this.minNumbers = minNumbers;
        this.minLength = minLength;
        this.specialChars = specialChars;
        this.maxLength = maxLength;
    }
    
    
    //metodo generador
public String generate(){

    String password="";
    
if(minLength >= maxLength){ //valida el tamaño 
    
    return "No se puede generar una contraseña con estas condiciones";
}
else if(minSpecialChars>((maxLength)-minUpperCase-minNumbers)||minUpperCase>((maxLength)-minSpecialChars-minNumbers)||minNumbers>((maxLength)-minSpecialChars-minUpperCase)) //valida entre minimos con el tamaño máximo
   return "El tamaño máximo no coincide entre el minimo de números, mayúsculas y carácteres especiales"; 
else{ //trabaja la lógica central
    int x = (minNumbers+minSpecialChars+minUpperCase); //suma obligatorios
    int y = minLength-x; //los que faltan del minlength
    
    
    faltantes =y+(int)(Math.random()*(maxLength-x)-1); //random para hacer tamaño entre el minimo (menos obligatorios) y máximo
    
    for (int i=0; i<minNumbers ; i++) { 
        password += numbers[(int)(Math.random()*numbers.length-1)]; //agrega numeros
    }
    
    for (int i=0; i<minUpperCase; i++){
        password += Uppers[(int)(Math.random()*Uppers.length-1)]; //agrega mayusculas
    }
    
     for (int i=0; i<minSpecialChars; i++){
        password += carac[(int)(Math.random()*carac.length-1)]; //agrega carácteres
    }
    
    for (int i=0; i<faltantes; i++) {
     password += Others[(int)(Math.random()*Others.length-1)]; //agrega los adicionales para llegar al tamaño entre el minimo y el maximo
    }
    
     String arrayPassword[] = password.split(""); //mezcla los elementos del String creado anteroirmente
            Collections.shuffle(Arrays.asList(arrayPassword));
            password = "";
            for (int i = 0; arrayPassword.length > i; i++) {
                password = password + arrayPassword[i];
            }
    
    
    return password;
    
    }
}

}
