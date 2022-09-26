package com.training.fruitshop.shoppingfruit;

public class Fruit {
    private String ID ;
    private String FruName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String ID, String FruName, double price, int quantity, String origin) {
        this.ID = ID;
        this.FruName = FruName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFruName() {
        return FruName;
    }

    public void setFruName(String FruName) {
        this.FruName = FruName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    
}
