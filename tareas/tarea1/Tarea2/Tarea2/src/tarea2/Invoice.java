
package tarea2;

import java.util.Calendar;

public class Invoice extends Product {


    public Invoice(int invoiceNumber, String dateHour, double totalToPay, int quantityProducts, String code, String expirationDate, double price, String tradeMark) {
        super(code, expirationDate, price, tradeMark);

        this.invoiceNumber = invoiceNumber;
        this.dateHour = dateHour;
        this.totalToPay = totalToPay;
        this.quantityProducts = quantityProducts;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }

    public double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }

    public int getQuantityProducts() {
        return quantityProducts;
    }

    public void setQuantityProducts(int quantityProducts) {
        this.quantityProducts = quantityProducts;
    }

  private int invoiceNumber;
  private String dateHour;
  private double totalToPay;
  private int quantityProducts;   
    
  public void ShowInvoice() { //muestra la factura

        Calendar cal = Calendar.getInstance();

        String fecha = cal.get(cal.DATE) + "/" + cal.get(cal.MONTH) + "/" + cal.get(cal.YEAR);
        String hora = cal.get(cal.HOUR_OF_DAY) + ":" + cal.get(cal.MINUTE) + ":" + cal.get(cal.SECOND);
        int numFac = (int) (Math.random()*1000+1);

        setInvoiceNumber(numFac);
        setDateHour(fecha + " "+ hora);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println(
                "----------------------------------------------------------------------------------------\n"+
                "Fecha y hora de la compra: " + getDateHour()+ "\n"
                + "Número de factura: " + getInvoiceNumber());
    }
       
    
}
