package com.training.managervehicle;

public class Motorbike extends Vehicle {
    private String license;
    private int speed;
    private static final String MAKE_SOUND = "Tin tin tin";

    public Motorbike() {
    }

    public Motorbike(String license, int speed) {
        this.license = license;
        this.speed = speed;
    }

    public Motorbike(String license, int speed, String name, String color, String ID, String brand, int price) {
        super(name, color, ID, brand, price);
        this.license = license;
        this.speed = speed;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "+) MOTOBIKE: \n" + super.toString() + " ; Required license - " + this.license + " ; Speed - " + this.speed + " ; Sound - " + this.MAKE_SOUND + "\n";
    }

    @Override
    protected void updateVehicle() { 
        super.updateVehicle();
        this.license = Utils.updateYesNo(this.license, "Update Required license(Yes/No): ");
        this.speed = Utils.updateGreaterThan0(this.speed, "Update Speed: ");
    }

    @Override
    protected void createVehicle() {
        super.createVehicle();
        this.license = Utils.getYesNo("Required license(Yes/No): ");
        this.speed = Utils.getGreaterThan0("Speed: ");
    }

}
