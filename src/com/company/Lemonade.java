package com.company;

public class Lemonade extends Food{

    private String taste = null;

    public Lemonade(String taste){
        super("Lemonade");
        this.taste = taste;
    }

    public void setTaste(String taste){
        this.taste = taste;
    }

    public String getTaste(){
        return taste;
    }

    public void consume(){
        System.out.println(this + " has been drunk");
    }

    public int calculateCalories(){
        if (taste.equals("lemon")){
            return 10;
        }
        else if(taste.equals("orange")){
            return 9;
        }
        else if(taste.equals("strawberry")){
            return 11;
        }
        else{
            return 0;
        }
    }

    public String toString() {
        return super.toString() + " taste of '" + taste.toUpperCase() + "'";
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Lemonade)) return false;
            return taste.equals(((Lemonade)arg0).taste);
        }
        else return false;
    }

}
