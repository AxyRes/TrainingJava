package com.training.fruitshop.shoppingfruit;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.zip.CheckedInputStream;

public class Manager {
    
    List<Fruit> fruit = new ArrayList<>();
    Hashtable<String, ArrayList<Fruit>> order = new Hashtable<>();
    
    public Fruit getFruitByID(String ID) { 
        for (Fruit fr : fruit) {
            if (ID.equals(fr.getID())) {
                return fr;
            }
        }
        return null;
    }

    public void createFruit() {
        while (true) {
            String frID = Utils.inputString("Enter Fruit ID: ", ".+");
            if (getFruitByID(frID) != null) {
                System.out.println("ID is exist!");
                continue;
            }
            String frName = Utils.inputString("Enter fruit name: ", "A-Za-z\\s]+");
            double price = Utils.inputMinMaxDouble("Enter price: ", 1, Double.MAX_VALUE);
            int quantity = Utils.inputMinMaxInt("Enter quantity", 1, Integer.MAX_VALUE);
            String origin = Utils.inputString("Enter origin: ", "A-Za-z\\s]+");
            fruit.add(new Fruit(frID, frName, price, quantity, origin));
            if (!Utils.getYesNo("Do you want to continues? (Y/N): ")) {
                break;
            }
        }
    }
    
    public int displayListFruit(){
        int countItem = 0;
        if (fruit.isEmpty()){
            return -1;
        }
        for (Fruit fr : fruit) {
            if (fr.getQuantity() != 0){
                countItem++;
                if (countItem == 1) {
                    System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit Name", "Origin", "Price");
                }
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem, fr.getFruName(), fr.getOrigin(), fr.getPrice());
            }
        }
        if (countItem == 0) {
            return -1;
        }
        int item = Utils.inputMinMaxInt("Enter item: ", 1, countItem);
        return item;
    }

    public Fruit getFruit(int item) {
        int count =0;
        for (Fruit fr : fruit) {
            if (fr.getQuantity() != 0) {
                count++;
            }
            if (item == count) {
                return fr;
            }
        }
        return null;
    }

    public Fruit checkOrderFruit(ArrayList<Fruit> list, String ID) { 
        for(Fruit fr : list) {
            if (fr.getID().equalsIgnoreCase(ID)) {
                return fr;
            }
        }
        return null;
    }

    public void shopping(){
        ArrayList<Fruit> list = new ArrayList<>();
        while (true) {
            int item = displayListFruit();
            if (item == -1) {
                System.out.println("Out of stock.");
                return;
            }
            Fruit fr = getFruit(item);
            System.out.println("You are selected: " + fr.getFruName());
            int quantity = Utils.inputMinMaxInt("Enter Quantity: ", 0, fr.getQuantity());
            fr.setQuantity(fr.getQuantity() - quantity);
            Fruit frinOrder = checkOrderFruit(list, fr.getID());
            if (frinOrder != null ) {
                frinOrder.setQuantity(frinOrder.getQuantity() - quantity);
            } else {
                if (quantity != 0) {
                    list.add(new Fruit(fr.getID(), fr.getFruName(), fr.getPrice(), quantity, fr.getOrigin()));
                }
            }
            if (!Utils.getYesNo("Do you want to continues? (Y/n): ")) {
                break;
            }
        }
        if (list.isEmpty()) {
            System.out.println("No Orders");
        }else {
            displayListOrder(list);
            String name = setName();
            order.put(name, list);
        }
    }

    public String setName() {
        String name = Utils.inputString("Enter name: ", "[A-Za-z\\s]+");
        int count = 0;
        for (String name_key : order.keySet()) {
            String real_name = name_key.split("a")[0];
            if (name.equals(real_name)) {
                count++;
            }
        }
        return name + "a" + count; 
    }

    public void displayListOrder(ArrayList<Fruit> list) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fr : list) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", fr.getFruName(), fr.getQuantity(), fr.getPrice(), fr.getPrice() * fr.getQuantity());
            total += fr.getPrice() * fr.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public void viewOrder() {
        if (order.isEmpty()) {
            System.out.println("No orders");
            return;
        }
        for (String name : order.keySet()) {
            System.out.println("Customer: " + name.split("#")[0]);
            ArrayList<Fruit> listOrder = order.get(name);
            displayListOrder(listOrder);
        }

    }
    public void generateFruit(){
        fruit.add(new Fruit("F1", "Chuoi", 2000, 3, "Hanoi"));
        fruit.add(new Fruit("F2", "Buoi", 4000, 6, "Hanoi"));
        fruit.add(new Fruit("F3", "Dua", 5000, 5, "Hanoi"));
    }
}
