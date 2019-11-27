package controller;

import java.util.ArrayList;

public class CareTaker {
    private ArrayList<String> states;

    public CareTaker() {
        states = new ArrayList<>();
    }
    
    public void addEditor(String cc){
        states.add(cc);
    }
    
    public String getState(int index){
        return states.get(index);
    }
}
