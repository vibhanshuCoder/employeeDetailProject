package com.empPackage;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {

    public static void main(String[] args) {

        ArrayList<Student> storage = new ArrayList<Student>();
        Scanner input = new Scanner(System.in);

        Student obj3 = new Student();

        System.out.print("Enter Student name ");

        obj3.setName(input.nextLine());
        storage.add(obj3);
        System.out.print(storage);
        System.out.print("Enter ID ");
        obj3.setID(input.nextInt());
        storage.add(obj3);

        System.out.print(storage);
    }
}

class Student {

    private  String  name;
    private int ID;
    private double grade;
    private int test;
    private int NUM_Tests;

    public Student() {
        name = "unassigned";
        ID = 0;
        grade = 0;
        test = 0;
        NUM_Tests = 0;
    }

    public  void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }

    public String toString() {
        return String.format(name,ID);
    }
}