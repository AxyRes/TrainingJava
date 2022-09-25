/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.training.managerstudent;

import java.util.ArrayList;

import Entity.Student;

/**
 *
 * @author nhatt
 */
public class ManagerStudent {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Validation val = new Validation();
        list.add(new Student("1", "Lam Nhat Tien", "Spring", "Java"));
        list.add(new Student("2", "Nuyen Thanh Long", "Summer", ".Net"));
        list.add(new Student("3", "Nguyen Phuong Uyen", "Fail", "c/c++"));
        int count = 3;
        while (true) {
            Manager.menu();
            int choice = val.checkInputLimit(1, 5);
            switch (choice) {
                case 1:
                    Manager.createStu(count, list);
                    break;
                case 2:
                    Manager.findAndSort(list);
                    break;
                case 3:
                    Manager.UpdateOrDelete(count, list);
                    break;
                case 4:
                    Manager.report(list);
                    break;
                case 5: return;
            }
        }
    }
}
