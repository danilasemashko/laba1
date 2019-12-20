package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        int countItems = 0;
        boolean flagSort = false;
        boolean flagCal = false;
        for (String arg: args){
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")){
                breakfast[countItems] = new Cheese();
            }
            else if (parts[0].equals("Apple")){
                breakfast[countItems] = new Apple(parts[1].toLowerCase());
            }
            else if(parts[0].equals("Lemonade")){
                breakfast[countItems] = new Lemonade(parts[1].toLowerCase());
            }

            else {
                switch (parts[0]) {
                    case "-sort":
                        flagSort = true;
                        break;
                    case "-calories":
                        flagCal = true;
                        break;
                    default:
                        System.out.println("Cannot find class " + parts[0] + ".\nContinue...\n");
                        countItems--;
                }
            }
            countItems++;
        }

        if (flagSort){
            Arrays.sort(breakfast, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    if (o1 instanceof Lemonade && o2 instanceof Lemonade) {
                        return -(((Lemonade) o1).getTaste().compareTo(((Lemonade) o2).getTaste()));
                    }
                    else if (o1 instanceof Lemonade && o2 instanceof Apple) {
                        return -(((Lemonade) o1).getTaste().compareTo(((Apple) o2).getSize()));
                    }
                    else if (o1 instanceof Apple && o2 instanceof Lemonade) {
                        return -(((Apple) o1).getSize().compareTo(((Lemonade) o2).getTaste()));
                    }
                    else if (o1 instanceof Apple && o2 instanceof Apple) {
                        return -(((Apple) o1).getSize().compareTo(((Apple) o2).getSize()));
                    }
                    else if (o1 instanceof Cheese && (o2 instanceof Apple || o2 instanceof Lemonade)) {
                        return -1;
                    }
                    else if ((o1 instanceof Apple || o1 instanceof Lemonade) && o2 instanceof Cheese) {
                        return 1;
                    }
                    else if (o1 == null) {
                        return 1;
                    }
                    else if (o2 == null) {
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            });
        }

        for (Food item: breakfast){
            if (item != null){
                item.consume();
            }
            else{
                break;
            }
        }

        int counter = 0;
        Lemonade check = new Lemonade("orange");
        for (Food item: breakfast){

            if (item != null){
                if (item.equals(check)){
                    counter++;
                }
            }
        }
        System.out.println("Amount products of type " + "'" +check + "'" + ": " + counter);

        counter = 0;
        for (Food item: breakfast){

            if (item != null){
                if (item.equals_type(check)){
                    counter++;
                }
            }
        }
        System.out.println("Amount products of type " + "'" +check.getName() + "'" + ": " + counter);

        if (flagCal){
            int calories = 0;
            for (Food item: breakfast) {
                if (item != null) {
                    calories += item.calculateCalories();
                }
                else{
                    break;
                }
            }
            System.out.println("Calories: " + calories + '\n');
        }

    }
}
