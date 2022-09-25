package com.training.managerstudent;

import Entity.Report;
import Entity.Student;
import java.util.ArrayList;
import java.util.Collections;

public class Manager {
    
    public static void menu() {
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
    }

    public static void createStu(int count, ArrayList<Student> list) {
        if (count > 10) {
            System.out.print("Do you want to continues (Y/N): ");
            if (!Validation.checkInputYN()){
                return;
            }
        }
        while (true) {
            System.out.println("Enter ID: ");
            String ID = Validation.checkInputString();
            System.out.println("Enter name student: ");
            String name = Validation.checkInputString();
            if(!Validation.checkIDexist(list, ID, name)){
                System.err.println("ID has already exist student, Please re-enter.");
                continue;
            }
            System.out.print("Enter Semester: ");
            String semester = Validation.checkInputString();
            System.out.print("Enter name course: ");
            String course = Validation.checkInputCourse();
            if (Validation.checkStudentExit(list, ID, name, semester, course)) {
                list.add(new Student(ID, name, semester, course));
                count ++;
                System.out.println("New student have added! Success.");
                return;
            }
            System.err.println("Duplicated.");
        }
    }

    public static void findAndSort(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty! Please input at least one.");
            return;
        }
        ArrayList<Student> listStuFindByName = listStuFindByName(list);
        if (listStuFindByName.isEmpty()) {
            System.out.println("Not exist");
        } else {
            Collections.sort(listStuFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            for(Student stu : list){
                stu.print();
            }
        }

    }

    public static ArrayList<Student> listStuFindByName(ArrayList<Student> list) {
        ArrayList<Student> listStuFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = Validation.checkInputString();
        for(Student stu : list){
            if(stu.getStuName().contains(name)){
                listStuFindByName.add(stu);
            }
        }
        return listStuFindByName;
    }

    public static void UpdateOrDelete(int count, ArrayList<Student> list) {
        if(list.isEmpty()) {
            System.out.println("List is empty! Please input at least one.");
            return;
        }
        System.out.print("Enter ID: ");
        String ID = Validation.checkInputString();
        ArrayList<Student> listStuFindByName = getListStuByID(list, ID);
        if(listStuFindByName.isEmpty()){
            System.out.println("Not found student.");
            return;
        }else{
            Student stu = getStudentByListFound(listStuFindByName);
            System.out.println("Do you want to update (U) or delete (D) student: ");
            if(Validation.checkInputUD()) {
                System.out.print("Enter ID: ");
                String ID1 = Validation.checkInputString();
                System.out.print("Enter Name: ");
                String name = Validation.checkInputString();
                System.out.print("Enter semester: ");
                String semester = Validation.checkInputString();
                System.out.print("Enter course: ");
                String course = Validation.checkInputCourse();
                if(!Validation.checkChangeInformation(stu, ID, name, semester, course)){
                    System.out.println("Nothing changes.");
                }
                if(Validation.checkStudentExit(list, ID, name, semester, course)){
                    stu.setID(ID);
                    stu.setStuName(name);
                    stu.setSemester(semester);
                    stu.setCourseName(course);
                    System.err.println("Update Success.");
                }
                return;
            }else{
                list.remove(stu);
                count --;
                System.err.println("Delete success.");
                return;
            }
        }
    }

    public static Student getStudentByListFound(ArrayList<Student> listStuFindByName){
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name", "Semester", "Course name");
        for(Student stu : listStuFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count, stu.getStuName(), stu.getSemester(), stu.getCourseName());
            count ++;
        }
        System.out.print("Enter Student: ");
        int choice = Validation.checkInputLimit(1, listStuFindByName.size());
        return listStuFindByName.get(choice - 1);
    }

    public static ArrayList<Student> getListStuByID(ArrayList<Student> list, String ID) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : list) {
            if (ID.equalsIgnoreCase(student.getID())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    public static void report(ArrayList<Student> ls) {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        int size = ls.size();
        for (int i = 0; i < size; i++) {
            int total = 0;
            for (Student student : ls) {
                String id = student.getID();
                String courseName = student.getCourseName();
                String studentName = student.getStuName();
                for (Student studentCountTotal : ls) {
                    if (id.equalsIgnoreCase(studentCountTotal.getID()) && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                        total++;
                    }
                }
                if (Validation.checkReportExist(lr, studentName,
                        courseName, total)) {
                    lr.add(new Report(student.getStuName(), studentName, total));
                }
            }
        }
        //print report
        for (int i = 0; i < lr.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", lr.get(i).getStudentName(),
                    lr.get(i).getCourseName(), lr.get(i).getTotalCourse());
        }
    }
}
