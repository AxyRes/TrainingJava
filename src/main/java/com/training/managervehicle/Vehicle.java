package com.training.managervehicle;

public class Vehicle {
    protected String name, color,ID, brand;
    protected int price;

    public Vehicle(){

    }

    public Vehicle(String name, String color, String ID, String brand, int price) {
        this.name = name;
        this.color = color;
        this.ID = ID;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected void createVehicle(){
        this.ID = Utils.getString("Vehicle ID: ");
        this.name = Utils.getString("Name: ");
        this.brand = Utils.getString("Brand: ");
        this.color = Utils.getColor("Color(Blue/Red/Green): ");
        this.price = Utils.getGreaterThan0("Price: ");
    }
    
    protected void updateVehicle() {
        String newId, currentId;
        currentId = this.ID;
        do {
            newId = Utils.updateString(this.ID, "Update Vehicle ID: ");
            if (currentId.equals(newId)) {
                System.out.println("Duplicated vehicle ID, input again!");
            } else {
                this.ID = newId;
            }
        } while (currentId.equalsIgnoreCase(newId));
        this.name = Utils.updateString(this.name, "Update Name: ");
        this.brand = Utils.updateString(this.brand, "Update Brand: ");
        this.color = Utils.updateColor(this.color, "Update color: ");
        this.price = Utils.updateInt(this.price, "Update Price: ");
    }

    @Override
    public String toString() {
        return "Vehicle ID - " + this.ID + " ; Name - " + this.name + " ; Brand - " + this.brand + " ; Color - " + this.color + " ; Price - " + this.price;
    }

    @Override
    public boolean equals(Object obj) { 
        return this.ID.equals(((Vehicle) obj).getID());
    }
}
