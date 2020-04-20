package tarea2;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {

    private ArrayList<Product> avaiableProducts = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Product(String code, String expirationDate, double price, String tradeMark) {
        this.code = code;
        this.expirationDate = expirationDate;
        this.price = price;
        this.tradeMark = tradeMark;
    }

    public ArrayList<Product> getAvaiableProducts() {
        return avaiableProducts;
    }

    public void setAvaiableProducts(ArrayList<Product> avaiableProducts) {
        this.avaiableProducts = avaiableProducts;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }
    private String code;
    private String expirationDate;
    private double price;
    private String tradeMark;

    @Override
    public String toString() {
        return "Código " + this.code + " Fecha de vencimiento " + this.expirationDate + " Precio individual" + this.price + " Marca " + this.tradeMark;
    }

    /////////////////////////////////////////////////////////////////////////////
    public void Producto() { //datos de los productos

        Product arroz = new Product("001A", "02/04/2021", 2300, "Arroz");
        Product azucar = new Product("002B", "15/03/2022", 1600, "Azucar");
        Product aceite = new Product("003C", "27/08/2020", 1500, "Aceite");
        Product cafe = new Product("004D", "22/12/2021", 1850, "Café");
        Product cereales = new Product("005E", "09/08/2020", 2000, "Cereales");

        avaiableProducts.add(arroz);
        avaiableProducts.add(azucar);
        avaiableProducts.add(aceite);
        avaiableProducts.add(cafe);
        avaiableProducts.add(cereales);

        System.out.println("PRODUCTOS DISPONIBLES: \n\n  " + " Producto: " + arroz.getTradeMark() + ";     Código: " + arroz.getCode() + " ; Expira el: " + arroz.getExpirationDate() + " ; Precio: " + arroz.getPrice()
                + "\n " + "  Producto: " + azucar.getTradeMark() + ";    Código: " + azucar.getCode() + " ; Expira el: " + azucar.getExpirationDate() + " ; Precio: " + azucar.getPrice()
                + "\n " + "  Producto: " + aceite.getTradeMark() + ";    Código: " + aceite.getCode() + " ; Expira el: " + aceite.getExpirationDate() +" ; Precio: " + aceite.getPrice()
                + "\n" + "   Producto: " + cafe.getTradeMark() + ";      Código: " + cafe.getCode() + " ; Expira el: " + cafe.getExpirationDate() + " ; Precio: " + cafe.getPrice()
                + "\n" + "   Producto: " + cereales.getTradeMark() + ";  Código: " + cereales.getCode() + " ; Expira el: " + cereales.getExpirationDate() + " ; Precio: " + cereales.getPrice()
                + "\n");

        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("");
    }

    /////////////////////////////////////////////////////////////////////////////
    String keep = "";
    String lista = "";
    int i = 0;
    int x = 0;
    int totalsin = 0;
    int canTot = 0;
    double total;

    public void factura() { //muestra la factura final

        System.out.println("COMPRAS: \n" + keep + "\nTotal sin impuestos: " + totalsin + "\nCantidad total de productos: " + canTot + "\nTOTAL A PAGAR: " + total);

    }

    public void compra() { //método de comprar producto

        String list = "";
        System.out.println("");
        System.out.println("Ingrese el código del producto que desea comprar");
        String codigo = sc.nextLine();
        for (i = 0; i < avaiableProducts.size(); i++) {
            if (codigo.equalsIgnoreCase(avaiableProducts.get(i).getCode())) {
                x = i;
                list = avaiableProducts.get(i) + "";

            }

        }

        if (list.equals("")) {
            System.out.println("ERROR: El producto no exixte");
            compra();
        }

        System.out.println("Ingrese la cantidad que desea comprar de este producto");
        int cant = Integer.parseInt(sc.nextLine());
        canTot += cant;

        lista = "       "+cant + "       :        " + list;
        keep += lista +": Precio por productos: "+ cant * avaiableProducts.get(x).getPrice() + "\n";
        totalsin += cant * avaiableProducts.get(x).getPrice();
        System.out.println("");
        System.out.println("*Presione 1 si desea comprar otro producto \n*Presione 2 si desea ver la lista de productos disponibles  \n*Presione 3 para aplicar impuestos\n*Presione 4 para finalizar la compra");
        int comp = Integer.parseInt(sc.nextLine());

        switch (comp) {
            case 1:
                compra();
                break;
            case 2:
                Producto();
                compra();
                break;
            case 3:
                System.out.println("");
                System.out.println("\nIngrese 1 para aplicar 13% de impuesto por iva\nIngrese 2 para aplicar 10% de impuesto por servicio\nIngrese 3 para aplicar 13%+10% de impuestos\nIngrese 4 si no va a aplicar impuesto");
                int imp = Integer.parseInt(sc.nextLine());
                switch (imp) {
                    case 1:
                        total = iva13(totalsin);
                        break;
                    case 2:
                        total = iva10(totalsin);
                        break;
                    case 3:
                        total = bothInv(totalsin);
                        break;
                    default:
                        total += totalsin;
                        break;
                }

                break;

        }
    }

    public double iva13(double numTot) { //agrega el iva

        double IVA13 = 0.13;

        double result = numTot + (numTot * IVA13);

        return result;
    }// end public iv13()

    public double iva10(double numTot) { //agrega el servicio

        double IVA10 = 0.10;

        double result = numTot + (numTot * IVA10);

        return result;

    }// end ´public iva10

    public double bothInv(double numTot) { //agrega ambos impuestos

        double IVA23 = 0.23;

        double result = numTot + (numTot * IVA23);

        return result;
    }

}
