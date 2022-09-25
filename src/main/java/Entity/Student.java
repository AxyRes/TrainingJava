/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author nhatt
 */
public class Student implements Comparable<Student>{
    private String ID;
    private String stuName;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(String ID, String stuName, String semester, String courseName) {
        this.ID = ID;
        this.stuName = stuName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    @Override
    public int compareTo(Student d){
        return d.stuName.compareTo(this.stuName);
   } 
    public void print(){
        System.out.printf("%-15s%-15s%-15s", stuName, semester, courseName);
    }
}
