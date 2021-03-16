package com.empPackage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class FullEmpClass {
    private static int ID = 0;
    public static ArrayList<String> empDetail = new ArrayList<>();
    public static HashMap<Integer, ArrayList<String>> empMap= new HashMap<>();
    private static String name, address, age, salary;
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);

    public static void create() throws IOException
    {

        System.out.println("Enter Detail :");
        System.out.println("Enter name :");
        name = br.readLine();
        empDetail.add(name);
        System.out.println("Enter Age :");
        age = br.readLine();
        empDetail.add(age);
        System.out.println("Enter Salary:");
        salary = br.readLine();
        empDetail.add(salary);
        System.out.println("Enter Address :");
        address = br.readLine();
        empDetail.add(address);
//        while(empDetail.size() !=0) {
            empMap.put(ID, empDetail);
            System.out.println("Record added successfully \n");
            home();
        }

    public static void view() throws IOException {
      try {
          for(Map.Entry ery: empMap.entrySet()) {
              System.out.println("ID :" + ery.getKey() + "\nDetails :" + ery.getValue());
          }
//          -----------------------------------------------------------------            //
//          if (detailList.size() != 0) {
//              for (int i = 0; i <= detailList.size(); i++) {
//                  System.out.println(detailList.get(i));
//              }
//          } else {
//              System.out.println("NO RECORD TO SHOW");
//              home();
//          }
      }catch (Exception e)
      {
          home();
      }
      home();
    }

    public static void update() throws IOException
    {
        System.out.println("""
                Enter choice which data you want to update
                Name :- 0
                Age :- 1
                Salary :- 2
                Address :-3
                Exit to home :- 4
                """);
        int se = sc.nextInt();
        switch (se)
        {
                case 0: {
                    System.out.println("Enter Name:");
                    name = br.readLine();
                    empDetail.set(0,name);
                    update();
                }
                case 1: {
                    System.out.println("Enter Age:");
                    age = br.readLine();
                    empDetail.set(1,age);
                    update();
                }
                case 2: {
                    System.out.println("Enter Salary:");
                    salary=br.readLine();
                    empDetail.set(2,salary);
                    update();
                }
                case 3: {
                    System.out.println("Enter Addres:");
                    address = br.readLine();
                    empDetail.set(3,address);
                    update();

                }
                case 4: {
                    home();
                }
                default: {
                    System.out.println("Enter a valid input");
                    update();
                }
            }
        }

        public static void delete () throws IOException
        {
           empDetail.clear();
           System.out.println("record deleted successfully");
           home();
        }

        public static void home() throws IOException
        {

        System.out.println("""
                -----------------Enter Your Choice-------------------
                create - 1
                view - 2
                update - 3
                delete - 4
                Exit - 5""");
        try {
            Scanner cSc = new Scanner(System.in);
            int i = cSc.nextInt();
            switch (i) {
                case 1 -> {
                    ID++;
                    create();}
                case 2 -> view();
                case 3 -> update();
                case 4 -> delete();
                case 5 -> System.out.println("Thanks for using...see you next time");
                default -> System.out.println("Invalid Input");
            }
        }catch (Exception e)
        {
            System.out.println("Invalid input....Please enter a valid input");
            home();
        }
    }
    public static void main(String[] args) throws IOException{
        FullEmpClass emp = new FullEmpClass();
        emp.home();
    }
}
