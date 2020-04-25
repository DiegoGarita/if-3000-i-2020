//@author Diego Garita Abarca, B83214
package edu.ucr.rp.lab2;

import edu.ucr.rp.lab2.generator.PasswordGenerator;
import edu.ucr.rp.lab2.generator.PasswordGeneratorBuilder;



public class BuilderPatternDemo1 {
    
    public static void main(String[] args) {
      
        PasswordGeneratorBuilder builder = new PasswordGeneratorBuilder(); //instncia de la clase
        
        PasswordGenerator generator = builder
                                             .withMinSpecialChars(2) //recibe un minimo de dos caracteres especiales (agregados posteriormente)
                                             .withMinUpperCase(2) //recibe un minimo de dos palabras en mayúscula
                                             .withMinNumbers(2) //recibe un minimo de dos numeros
                                             .withMinLength(8) //el minimo tamaño que debe tener es de 8
                                             .withSpecialChars(new char[]{'#','%','@','/','*'}) //carácteres especiales
                                             .withMaxLength(12) //tamaño máximo que debe tener es de 12
                                             .build();
       
               
        System.out.println(generator.generate()); //lo muestra por consola
    } 
    
}
