/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.training.fruitshop.shoppingfruit;

/**
 *
 * @author nhatt
 */
public class ShoppingFruit {

    public static void main(String[] args) {
        Manager mn = new Manager();
        mn.generateFruit();
        while (true) {
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            int choice = Utils.inputMinMaxInt("Enter choice:", 1, 4);
            switch (choice) {
                case 1:
                    mn.createFruit();
                    break;
                case 2: 
                    mn.viewOrder();
                    break;
                case 3:
                    mn.shopping();
                    break;
                case 4:
                    return;
            }
        }
    }
}
