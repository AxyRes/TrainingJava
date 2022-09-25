package com.training.managerstudent;

import Entity.Student;
import Entity.Report;
import java.util.ArrayList;
import java.util.Scanner;

public class Validation{
    private final static Scanner sc = new Scanner(System.in);

    public static int checkInputLimit(int min, int max){
        while(true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max){
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                // TODO: handle exception
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.println("Enter again: ");
            }
        }
    }

    public static String checkInputString(){
        while(true){
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty!");
                System.out.println("Enter again; ");
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputYN() {
        while(true) {
            String result = checkInputString();
            if(result.equalsIgnoreCase("Y")){
                return true;
            }
            if(result.equalsIgnoreCase("N")){
                return false;
            }
            System.err.println("Please Input y/Y or n/N.");
            System.out.println("Enter again: ");
        }
    }

    public static boolean checkInputUD() {
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("U")){
                return true;
            }
            if(result.equalsIgnoreCase("D")){
                return false;
            }
            System.err.println("Please Input u/U or d/D.");
            System.out.println("Enter again: ");
        }
    }

    public static String checkInputCourse() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net") || result.equalsIgnoreCase("c/c++")){
                return result;
            }
            System.err.println("There are only three course: Java, .Net, C/C++");
            System.out.println("Enter again: ");
        }
    }

    public static boolean checkStudentExit(ArrayList<Student> list, String ID, String stuName, String semester, String course){
        int size = list.size();
        for (Student stu : list) {
            if (ID.equalsIgnoreCase(stu.getID()) && stuName.equalsIgnoreCase(stu.getStuName()) && semester.equalsIgnoreCase(stu.getSemester()) && course.equalsIgnoreCase(stu.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkReportExist(ArrayList<Report> list, String name, String course, int total) {
        for (Report rp : list) {
            if (name.equalsIgnoreCase(rp.getStudentName()) && course.equalsIgnoreCase(rp.getCourseName()) && total == rp.getTotalCourse()){
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkIDexist(ArrayList<Student> list, String ID, String name) {
        for (Student stu : list){
            if (ID.equalsIgnoreCase(stu.getID()) && name.equalsIgnoreCase(stu.getStuName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkChangeInformation(Student stu, String ID, String name, String semester, String courses) {
        if (ID.equalsIgnoreCase(stu.getID()) && name.equalsIgnoreCase(stu.getStuName()) && semester.equalsIgnoreCase(stu.getSemester()) && courses.equalsIgnoreCase(stu.getCourseName())) {
            return false;
        }
        return true;
    }
}