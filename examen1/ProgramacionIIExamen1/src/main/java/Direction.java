
import java.util.ArrayList;

public class Direction extends Message {

    private ArrayList<String> array;

    public ArrayList<String> getArray() {
        return array;
    }

    public void setArray(ArrayList<String> array) {
        this.array = array;
    }

    @Override
    public String showMessage() {
        return super.showMessage() + "\nA la dirección: " + array; //To change body of generated methods, choose Tools | Templates.
    }

}
