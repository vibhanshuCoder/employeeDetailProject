package com.empPackage;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class FullEmpClass {

    public static List<String> detailList = new ArrayList<>();
    private static String name, address, age, salary;
    public static Scanner sc = new Scanner(System.in);
    public static void create()
    {
        System.out.println("Enter Detail :");
        System.out.println("Enter name :");
        name = sc.nextLine();
        detailList.add(name);
        System.out.println("Enter Age :");
        age = sc.nextLine();
        detailList.add(age);
        System.out.println("Enter Salary:");
        salary = sc.nextLine();
        detailList.add(salary);
        System.out.println("Enter Address :");
        address = sc.nextLine();
        detailList.add(address);
        System.out.println("Record added successfully \n\n");
        home();

    }
    public static void view()
    {try {
        for (int i = 0; i <= detailList.size(); i++) {
            System.out.println(detailList.get(i));
        }
    }catch (Exception e)
    {
        home();
    }

    }
    public static void update() {
        System.out.println("""
                Enter choice which data you want to update
                Name :- 0
                Age :- 1
                Salary :- 2
                Address :-3
                Exit to home :- 4
                """);
                int se = sc.nextInt();
        try {
            switch (se) {
                case 0: {
                    System.out.println("Enter Name:");
                    name = sc.next();
                    detailList.set(0,name);
                    home();
                }
                case 1: {
                    System.out.println("Enter Age:");
                    age = sc.nextLine();
                    detailList.set(1,age);
                    home();
                }
                case 2: {
                    System.out.println("Enter Salary:");
                    salary=sc.nextLine();
                    detailList.set(2,salary);
                    home();
                }
                case 3: {
                    System.out.println("Enter Addres:");
                    address = sc.nextLine();
                    detailList.set(3,address);
                    home();
                }
                case 4: {
                    home();
                }
                default: {
                    System.out.println("Enter a valid input");
                }
            }
        } catch (Exception e){
            System.out.println("Enter valid input");
            update();
        }

    }
        public static void delete ()

    {
           detailList.clear();
           System.out.println("record deleted successfully");
           home();

    }
    public static void home()
    {
        System.out.println("""
                -----------------Enter Your Choice-------------------
                create - 1
                view - 2
                update - 3
                delete - 4
                Exit - 5""");
        Scanner cSc = new Scanner(System.in);
        int i = cSc.nextInt();
        switch (i) {
            case 1 -> create();
            case 2 -> view();
            case 3 -> update();
            case 4 -> delete();
            case 5 -> System.out.println("Thanks for using...see you next time");
            default -> System.out.println("Invalid Input");
        }
    }
    public static void main(String[] args){
        FullEmpClass emp = new FullEmpClass();
        emp.home();
    }
}
