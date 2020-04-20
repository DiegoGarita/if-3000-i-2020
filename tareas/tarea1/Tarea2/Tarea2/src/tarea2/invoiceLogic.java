package tarea2;

import java.util.Scanner;

public class invoiceLogic {

    public void logic() { //trabaja toda la lógica de la factura 

        //instancias
        Product p = new Product("code", "expirationDate", 0, "tradeMark");
        Invoice i = new Invoice(0, "dateAndTime", 0, 0, "code", "expitarionDate", 0, "tradeMark");
        Company c = new Company("name", 0, "address", 0);
        Customer k = new Customer(0, "name", 0, "address",0);
        try{
        Scanner sc = new Scanner(System.in);//instancia del scanner
        //mensaje de inicio
        System.out.println("¡BIENVENIDO!\n\nPresione 1 para ingresar sus datos");//Datos del cliente
        int dat = Integer.parseInt(sc.nextLine());

        switch (dat) { //switch1
            case 1:
                k.infoCustomer();
                
                System.out.println("\nPresione 2 para ver la lista de productos (o cualquier otro número para salir)");//Lista de productos
                int dat2 = Integer.parseInt(sc.nextLine());
                switch (dat2) { //switch2
                    case 2:
                        p.Producto(); //ve los productos
                        System.out.println("\nPresione 3 para comprar algún producto");//comprar o irse
                        int dat3 = Integer.parseInt(sc.nextLine());
                        switch (dat3) { //switch3
                            case 3:
                                p.compra();//compra
                                System.out.println("Presione 4 para generar su factura");
                                int dat4 = Integer.parseInt(sc.nextLine());
                            
                                switch (dat4) { //switch4
                                    case 4:
                                        i.ShowInvoice();
                                        System.out.println("----------------------------------------------------------------------------------------");
                                        c.ShowInfoCompany();
                                        System.out.println("----------------------------------------------------------------------------------------");
                                        p.factura();
                                        System.out.println("----------------------------------------------------------------------------------------");
                                        k.ShowInfoCusto();
                                        System.out.println("----------------------------------------------------------------------------------------");
                                        break;
                                }
                                break;
                        }
                        break;
                }
                    default:
                        System.out.println("\n¡Gracias por su visita!");
                        break;
                }
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Error, presionó una tecla incorrecta. Intentelo nuevamente\n");
        }
        catch(NullPointerException npe){
            System.out.println("Error, dejó un espacio vacío. Intentelo nuevamente \n");
        }
        }

    }
