
package tarea2;

import java.util.Scanner;

public class Customer extends Company {
    
       private int age;

    public Customer(int age, String name, int ID, String adress, int phoneNumber) {
        super(name, ID, adress, phoneNumber);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

          public void ShowInfoCusto() { //muestra la información del usuario

        setName(nombreIngresado);
        setAge(Integer.parseInt(edadIngresado));
        setAdress(direccionIngresado);
        setID(Integer.parseInt(cedulaIngresado));
        setPhoneNumber(Integer.parseInt(teleIngresado));

        System.out.println("Nombre del cliente: " + getName() + "\n"
                + "Edad del cliente: " + age + "\n"
                + "Número de identificación: " + getID() + "\n"
                + "Dirección del cliente: " + getAdress() + "\n"
                + "Número telefonico del cliente: " + getPhoneNumber());

    }
    
   String nombreIngresado;
    String edadIngresado;
    String cedulaIngresado;
    String direccionIngresado;
    String teleIngresado;
    
     Scanner sc = new Scanner(System.in);

    public void infoCustomer() { //toma la información del usuario
        System.out.println("...");
        System.out.println("Ingrese  su nombre");
        nombreIngresado = sc.nextLine();
        System.out.println("...");
        System.out.println("Ingrese su edad");
        edadIngresado = sc.nextLine();
        System.out.println("...");
        System.out.println("Ingrese su número de identificación");
        cedulaIngresado = sc.nextLine();
        System.out.println("...");
        System.out.println("Ingrese su dirección");
        direccionIngresado = sc.nextLine();
        System.out.println("...");
        System.out.println("Ingrese su número telefonico");
        teleIngresado = sc.nextLine();
        System.out.println("...");
        System.out.println("----------------------------------------------------------------------------------------");

    }// 
    

    
}//end
