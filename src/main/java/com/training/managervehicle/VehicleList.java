package com.training.managervehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleList extends ArrayList<Vehicle> implements I_FuntionList {
    ArrayList<Vehicle> list = new ArrayList<>();
    Vehicle vel;
    private int index;
    File file;

    public VehicleList() {
    }

    public VehicleList(Vehicle vel, int index, File file, int initialCapacity) {
        super(initialCapacity);
        this.vel = vel;
        this.index = index;
        this.file = file;
    }

    public VehicleList(Vehicle vel, int index, File file) {
        this.vel = vel;
        this.index = index;
        this.file = file;
    }

    public VehicleList(Vehicle vel, int index, File file, Collection<? extends Vehicle> c) {
        super(c);
        this.vel = vel;
        this.index = index;
        this.file = file;
    }

    public ArrayList<Vehicle> getList() {
        return list;
    }

    public void setList(ArrayList<Vehicle> list) {
        this.list = list;
    }

    public Vehicle getVel() {
        return vel;
    }

    public void setVel(Vehicle vel) {
        this.vel = vel;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    @Override
    public int find(String code){
        index = list.indexOf(new Car(code));
        return index;
    }
    
    @Override
    public void add(){
        int choice;
        try {
            do {
                System.out.println("\n          ADD VEHICLE MENU");
                System.out.println("        1 - Add Car");
                System.out.println("        2 - Add Motorbike");
                System.out.println("        Other - back to menu \n");
                choice = Utils.getInt("Enter your choice: ");
                switch (choice) {
                    case 1:
                        vel = new Car();
                        vel.createVehicle();
                        index = list.indexOf(vel);
                        if (index == -1) {
                            list.add(vel);
                            System.out.println("Added!");
                        }else{
                            System.out.println("Dupplicated");
                        }
                        System.out.println("");
                        break;
                
                    case 2:
                        vel = new Motorbike();
                        vel.createVehicle();
                        index = list.indexOf(vel);
                        if (index == -1) {
                            list.add(vel);
                            System.out.println("Added!");
                        } else {
                            System.out.println("Dupplicated!");
                        }
                        System.out.println("");
                        break;
                }
            } while (choice >= 1 && choice <= 2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void delete(){
        this.index = find(Utils.getString("Enter Vehicle ID that you want to delete, required to enter correct Vehicle ID including uppercase and lowercase: "));
        String check;
        if (index != -1) {
            check = Utils.getYesNo("Are you sure you want to delete (Yes/No)?: ");
            if (check.equalsIgnoreCase("Yes")) {
                list.remove(index);
                System.out.println("Delete Done!");
            } else {
                System.out.println("Delete Error, Please try again");
            }
        } else {
            System.out.println("Not found ID you type!");            
        }
    }

    @Override
    public void search(){
        int choice;
        String text1, text2;
        int count1 = 0;
        int count2 = 0;

        try {
            do {
                System.out.println("\n          SEARCH VEHICLE MENU");
                System.out.println("        1 - Search by vehicle name");
                System.out.println("        2 - Search by vehicle id");
                System.out.println("        Ohter - Back to menu \n");
                choice = Utils.getGreaterThan0("Enter your choice: ");
                switch (choice) {
                    case 1:
                        text1 = Utils.getString("Enter the vehicle name you want to find: ");
                        ArrayList<Vehicle> clonelist = (ArrayList<Vehicle>) list.clone();
                        Collections.sort(clonelist, new Comparator<Vehicle>() {
                            @Override
                            public int compare(Vehicle c1, Vehicle c2){
                                return (c2.ID.compareTo(c1.ID));
                            }
                        });
                        for (Vehicle oo : clonelist) {
                            if (oo.getName() != null && (oo.getName().contains(text1))){
                                System.out.println(oo.toString());
                                count1 ++;
                            }
                        }
                        if(count1 == 0){
                            System.out.println("Not Found!");
                        }
                        System.out.println("");
                        break;
                
                    case 2:
                        break;
                }
            } while (choice >= 1 && choice <= 2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void update(){
        this.index = find(Utils.getString("Enter the Vehicle ID that you want to update, required to enter correct Vehicle ID including uppercase and lowercase: "));
        if (index != -1) {
            vel = list.get(index);
            vel.updateVehicle();
            list.set(index, vel);
            System.out.println("Done, Your information have been updated! The result of the update: \n" + vel.toString());
        } else {
            System.out.println("Vehicle dosen't exist!");
        }
    }

    @Override
    public void output(){
        int choice;
        try {
            do {
                System.out.println("\n          SHOW VEHICLE MENU");
                System.out.println("        1 - Show all");
                System.out.println("        2 - Show descending by price");
                System.out.println("        Other - Back to menu!");
                choice = Utils.getGreaterThan0("Enter your choice: ");
                switch(choice) {
                    case 1:
                        for (Vehicle oo : list) {
                            System.out.println(oo.toString());
                        }
                        System.out.println("");
                        break;
                    case 2:
                        ArrayList<Vehicle> clonelist = (ArrayList<Vehicle>) list.clone();
                        Collections.sort(clonelist, new Comparator<Vehicle>() {
                            @Override
                            public int compare(Vehicle c1, Vehicle c2){
                                if (c1.price < c2.price) {
                                    return 1;
                                } else {
                                    if (c1.price == c2.price) {
                                        return 0;
                                    } else {
                                        return -1;
                                    }
                                }
                            }
                        });
                        for (Vehicle oo : clonelist) {
                            System.out.println(oo.toString());
                        }
                        System.out.println("");
                        break;
                }
            } while (choice >= 1 && choice <= 2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void readFile(){
        System.out.println("                                                   vehicle_file.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("vehicle_file.txt");
            ois = new ObjectInputStream(fis);
            list = (ArrayList<Vehicle>) ois.readObject();
            for(Vehicle oo : list){
                System.out.println(oo);
            }

        } catch (FileNotFoundException e) {
            // TODO: handle exception
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if ( ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    // TODO: handle exception
                    Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

    } 

    @Override
    public void writeFile(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("vehicle_file.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("Saved!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
