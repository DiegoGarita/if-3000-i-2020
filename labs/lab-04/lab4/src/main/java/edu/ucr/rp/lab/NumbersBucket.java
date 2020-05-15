
package edu.ucr.rp.lab;

import java.util.ArrayList;
import java.util.List;

public class NumbersBucket {
    private List<Integer> numbers;

    public NumbersBucket() { numbers = new ArrayList<>(); }
    public void add(Integer value) {
        synchronized(this){
            numbers.add(value);
        }
        System.out.println("added "+value);
    }
        public void remove(int index){
        synchronized(this){
        numbers.remove(index);
        }
        
        
    }
    public int size() { return numbers.size(); }
}