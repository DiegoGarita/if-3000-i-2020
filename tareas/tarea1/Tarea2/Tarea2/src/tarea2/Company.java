
package tarea2;


public class Company {//información de la compañía
    
 Product pR = new Product("CODE", "EXPIRATIONDATE", 000, "BRAND");  //recibe la clase producto
  private String name;
  private int ID;
  private String adress;
  private int phoneNumber;

    public Company(String name, int ID, String adress, int phoneNumber) {
        this.name = name;
        this.ID = ID;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
public void ShowInfoCompany(){ //mostrar información de la empresa (introducida manualmente)
      
      setName("Super Crash");
      setAdress("Glen Park, 25m norte");
      setID(001325212135);
      setPhoneNumber(22714105);
    
         System.out.println("Nombre de la empresa: " + getName() + "\n"
                + "Cedula juridica: " + getID()+ "\n"
                + "Direccion de la empresa : " + getAdress() + "\n"
                + "Telefono de la empresa: " + getPhoneNumber());
         
}
    
}//end

