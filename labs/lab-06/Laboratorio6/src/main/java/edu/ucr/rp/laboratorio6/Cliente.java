package edu.ucr.rp.laboratorio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable {

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    private int nombre;
    private Supermercado supermarket;
    private Carniceria carniceria = new Carniceria(1);
    private Pasillo pasillo = new Pasillo(2);
    private Random random = new Random();
    boolean carniboolean = indicadorDeCarniceria();
    private int pasillo1 = 0;
    private int pasillo2 = 0;
    private int pasillo3 = 0;
    private int pasillo4 = 0;

    public Cliente(int nombre, Supermercado supermercado) {
        this.nombre = nombre;
        this.supermarket = supermercado;
    }

    @Override
    public void run() {
        System.out.printf("El cliente %s está llegando \n", nombre);
        sleep();

        System.out.printf("%s está en la entrada \n", nombre);
        supermarket.siguente();

        System.out.printf("%s entró\n", nombre);
        sleep();

        hallWays(pasillo1);

        int cant = cantidadDeProductos();
        ArrayList a = listaDeProductos(cant);
        System.out.println("El cliente " + nombre + " comprará los productos: " + a);
        sleep();

        tiempoDeSeleccion(cant, a);
        sleepCaminaEntrePasillos();
        System.out.println("El cliente " + nombre + " durará " + a.size() + " segundos en la caja");
        payingTime(a);
        System.out.println("El cliente " + nombre + " debe ir a la carnicería? " + indicadorDeCarniceria());
        pasillo1--;
        sleep();
        butch();
        
         System.out.println(nombre + " haciendo fila para cancelar productos adquiridos");
        supermarket.filaCajas(2, nombre);


        System.out.printf("%s salió\n", nombre);
        supermarket.abandonaSupermercado();

    }

    private void sleep() {
        try {

            Thread.sleep(new Random().nextInt(5000));

        } catch (InterruptedException ignored) {
        }

    }

    public int cantidadDeProductos() {
        return (random.nextInt(60 - 5 + 1) + 5);
    }

    public ArrayList listaDeProductos(int cantidadDeProductos) {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < cantidadDeProductos; i++) {
            lista.add(random.nextInt(120));
        }
        Collections.sort(lista);
        return lista;
    }

    public int duracionDeSeleccion() {
        return (random.nextInt(5 - 2 + 1) + 2);
    }

    public void tiempoDeSeleccion(int cant, ArrayList a) {

        for (int i = 0; i < cant; i++) {
            int duracion = duracionDeSeleccion();
            System.out.println("El cliente " + nombre + " dura " + duracion + " segundos en seleccionar el producto " + a.get(i) + " ubicado en el pasillo " + ((numeroDePasillo((int) a.get(i))) + 1));
            try {
                Thread.sleep(duracion * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void sleepCaminaEntrePasillos() {
        int x = (random.nextInt(10000 - 5000 + 1) + 5000);
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean indicadorDeCarniceria() {
        return random.nextBoolean();
    }

    public void payingTime(ArrayList a) {

        try {
            Thread.sleep(a.size() * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void butch() {
        if (carniboolean == true) {

            System.out.println("Cliente " + nombre + " entró  a la carnicería");
            System.out.println("Cliente " + nombre + " salió de la carnicería");
            carniceria.gettingInLineBucther();
            try {

                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            carniceria.leavingButcherShop();

        } else {
            System.out.println("Cliente " + nombre + " no entró a la carnicería");
        }

    }

    public int numeroDePasillo(int a) {
        return a * 4 / 120;
    }

    public void pasillo() {

//        boolean valida= false;
//        
//        while(valida == false){
//        System.out.println("El cliente"+ nombre+ "intenta entrar al pasillo");
//                if(indicadorPasillo()<2){
//                    System.out.println("El cliente "+ nombre +" entra al pasillo");
//                    valida = true;
//                }
//                else{
//                    System.out.println("El cliente "+ nombre +" espera");
//                     try {
//
//                Thread.sleep(5000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                    
//                }
//        
//        }
    }

    public int indicadorPasillo() {
        boolean valida = false;

        return 0;
    }

//    public boolean indicateHalls() {
//        return (random.nextBoolean());
//    }


    
    public void hallWays(int pass) {
        System.out.printf("%s: está buscando pasillos\n", nombre);
        if(pass<2) {
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.printf("%s: ¿puede entrar al pasillo?\n", nombre);
                pasillo.enterInHall(this);
                sleep();
                pasillo1++;
                
            } catch (InterruptedException ignored) {
            }
        }
    }

}
