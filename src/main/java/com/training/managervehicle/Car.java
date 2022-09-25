package com.training.managervehicle;

public class Car extends Vehicle{
    private String type;
    private int yearOfManufacture;

    public Car() {
    }

    public Car(String ID) {
        this.ID = ID;
    }

    public Car(String type, int yearOfManufacture) {
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Car(String type, int yearOfManufacture, String name, String color, String ID, String brand, int price) {
        super(name, color, ID, brand, price);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "+) CAR: \n" + super.toString() + " ; Type - " + this.type + " ; Year of manufacture - " + this.yearOfManufacture + "\n";
    }

    @Override
    protected void updateVehicle() {
        super.updateVehicle();
        this.type = Utils.updateType(this.type, "Update Type(Sport/Travel/Common): ");
        this.yearOfManufacture = Utils.updateYear(this.yearOfManufacture, "Update Year of manufacture: ");
    }

    @Override
    protected void createVehicle() {
        super.createVehicle();
        this.type = Utils.getType("Type(Sport/Travel/Common): ");
        this.yearOfManufacture = Utils.getYear("Year of manufacture: ");
    }
}
