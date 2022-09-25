
package com.training.managervehicle;

public class ManagerVehicle {

    public static void main(String[] args) {
        int choice;
        VehicleList Vhlist = new VehicleList();
        String check = null;
        int count = 1;

        try {
            do {
                Utils.printMenu();
                choice = Utils.getInt("Enter Your Choice: ");
                switch (choice) {
                    case 1:
                        Vhlist.readFile();
                        break;
                    case 2:
                        Vhlist.add();
                        count ++;
                        System.out.println("");
                        break;
                    case 3:
                        Vhlist.update();
                        count ++;
                        System.out.println("");
                        break;
                    case 4:
                        Vhlist.delete();
                        count ++;
                        System.out.println("");
                        break;
                    case 5:
                        Vhlist.search();
                        System.out.println("");
                        break;
                    case 6:
                        Vhlist.output();
                        System.out.println("");
                        break;
                    case 7:
                        Vhlist.writeFile();
                        System.out.println("");
                        break;
                }
            } while (choice >= 1 && choice <= 7);
            if (choice >= 8 || choice <= 0) {
                if (count != 1) {
                    check = Utils.getYesNo("You have not saved it! Do you want to save it to a file (Yes/No): ");
                    if (check.equalsIgnoreCase("Yes")) {
                        Vhlist.writeFile();
                        System.out.println("\n------------------------------------- End Program -------------------------------------\n");
                    } else {
                        System.out.println("\n------------------------------------- End Program -------------------------------------\n");
                    }
                } else {
                    System.out.println("\n------------------------------------- End Program -------------------------------------\n");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
