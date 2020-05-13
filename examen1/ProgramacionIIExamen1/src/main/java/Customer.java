
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;

    public List<Medios> getContact() {
        return contact;
    }

    public void setContact(List<Medios> contact) {
        this.contact = contact;
    }
    private List<Medios> contact;

    public Customer() {
        contact = new ArrayList<>();
    }//contructor 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addInvoice(Medios medios) {
        contact.add(medios);
    }

}
