package com.company;

public class Cheese extends Food {
    public Cheese() {
        super("Cheese");
    }
    public void consume() {
        System.out.println(this + " has eaten");
    }

    public int calculateCalories(){
        return 800;
    }

}
