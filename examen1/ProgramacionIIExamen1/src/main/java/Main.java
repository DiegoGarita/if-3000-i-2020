//Diego Garita Abarca - B83214
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        
        Customer name = new Customer();
        Medios m = new Medios(name);
        name.setName("Juan Pérez");
        name.addInvoice(m);
        
        ArrayList<String> arrayPhoneNumbers = new ArrayList<>();
        arrayPhoneNumbers.add("83426289");
        
        PhoneNumber number = new PhoneNumber();
        number.setArray(arrayPhoneNumbers);
        
        ArrayList<String> arrayDirections = new ArrayList<>();
        arrayDirections.add("Costa Rica");
        arrayDirections.add("San Isidro de El Guarco");
        arrayDirections.add("Cartago");
        arrayDirections.add("30802");
        arrayDirections.add("De la escuela");
        arrayDirections.add("100 al norte");
        
        Direction direction = new Direction();
        direction.setArray(arrayDirections);
        
        ArrayList<String> arrayEmail = new ArrayList<>();
        arrayEmail.add("jsmith@email.com");
        
        Email email = new Email();
        email.setArray(arrayEmail);
        
        System.out.println("El cliente: " + name.getName());
        System.out.println(number.showMessage());
        System.out.println(email.showMessage());
        System.out.println(direction.showMessage());
        
    }
    
}
