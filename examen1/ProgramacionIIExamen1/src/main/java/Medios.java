
import java.util.ArrayList;
import java.util.List;

public class Medios {

    private Customer customer;
    private ArrayList<PhoneNumber> number;
    private ArrayList<Email> mail;
    private ArrayList<Direction> direct;

    public Medios(Customer customer) {
        this.customer = customer;
        number = new ArrayList<>();//ListFactory.createInstance(); ->  {return new ArrayList();}
        mail = new ArrayList<>();
        direct = new ArrayList<>();
    }

    public List<PhoneNumber> addPhoneNumber(PhoneNumber phone) {
        number.add(phone);
        return number;
    }

    public List<Email> addEmail(Email email) {
        mail.add(email);
        return mail;
    }

    public List<Direction> addDirection(Direction direction) {
        direct.add(direction);
        return direct;
    }

}
