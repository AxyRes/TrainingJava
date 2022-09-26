package com.training.fruitshop.shoppingfruit;

import java.util.Scanner;

import javax.swing.plaf.TreeUI;

public class Utils {

    public static int inputMinMaxInt(String str, int min, int max){
        while (true) {
            try {
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                int number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.print("Please input an integer number: ");
            }
        }
    }

    public static double inputMinMaxDouble(String str, double min, double max) {
        while(true) {
            try {
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                double number = Double.parseDouble(sc.nextLine());
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.print("Please input an double number: ");
            }
        }
    }

    public static String inputString(String str, String regex) {
        while (true) {
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            String in = sc.nextLine();
            if(!in.matches(regex)){
                System.out.println("Please input match reges("+regex+")");
                continue;
            }
            return in;
        }
    }

    public static boolean getYesNo(String str) {
        while (true) {
            System.out.print("str");
            Scanner sc = new Scanner(System.in);
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("PLease input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}
