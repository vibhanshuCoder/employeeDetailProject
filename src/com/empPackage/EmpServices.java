package com.empPackage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmpServices {
    public Map<Integer,EmpDatabase> empMap = new HashMap<>();
    public BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private int id = 0;
    public PrintStream Out = new PrintStream(new FileOutputStream(FileDescriptor.out));
    public Scanner scanner = new Scanner(System.in);
    public  EmpDatabase EmpDatabase = new EmpDatabase();

//    ---------------ADD-METHOD-------------------
    public void addEmp() throws IOException {

        EmpDatabase empDatabase = new EmpDatabase();
        Out.print("Enter employee name : ");
        String name = br.readLine();
        empDatabase.setName(name);
        Out.print("Enter employee age : ");
        String age = br.readLine();
        empDatabase.setAge(age);
        Out.print("Enter employee salary : ");
        String salary = br.readLine();
        empDatabase.setSalary(salary);
        Out.print("Enter employee contact number : ");
        String phnNb= br.readLine();
        empDatabase.setPhnNb(phnNb);
        empMap.put(id, empDatabase);
        Out.print("-----------Data Added successfully-------------\n");
        homePage();
    }
//    ------------------VIEW-METHOD-----------
    public void viewEmp()
    throws IOException
    {

        Out.print("""
                Enter your choice
                View All - 0
                View by Id - 1
                Home - 2
                """);

        int i = scanner.nextInt();
        switch (i)
        {
            case 0:{
               for(Map.Entry ery : empMap.entrySet()) {
                    System.out.println("ID : " + ery.getKey() + ery.getValue().toString());
                }
                viewEmp();
            }

            case 1: {
                System.out.println("Enter ID : ");
                int keyval = scanner.nextInt();
                EmpDatabase val = empMap.get(keyval);
                Out.print("ID : " + keyval + "" + val);
                viewEmp();
            }
            case 2: {
                homePage();
            }

            default: {
                Out.print("Please enter valid input");
                break;
            }
        }}

//    ---------------UPDATE-METHOD--------
public void updateEmp() throws IOException
{
    System.out.println("""
            Enter choice which data you want to update
            update all detail - 0
            Name :- 1
            Age :- 2
            Salary :- 3
            ContactNo. :-4
            Exit to home :- 5
            """);
    int se = scanner.nextInt();
    switch (se)
    {
        case 0: {
            Out.println("Enter ID: ");
            int kvl = scanner.nextInt();
            Out.println("Enter Name:");
            String name = br.readLine();
            EmpDatabase.setName(name);
            Out.println("Enter Age:");
            String age = br.readLine();
            EmpDatabase.setAge(age);
            Out.println("Enter Salary:");
            String salary = br.readLine();
            EmpDatabase.setSalary(salary);
            Out.println("Enter Contact number:");
            String phnnb = br.readLine();
            EmpDatabase.setPhnNb(phnnb);
            empMap.put(kvl, EmpDatabase);
            updateEmp();
        }
        case 1: {
            Out.println("Enter ID: ");
            int kvl = scanner.nextInt();
            Out.println("Enter Name:");
            String name = br.readLine();
            EmpDatabase val = empMap.get(kvl);
            val.setName(name);
            empMap.put(kvl, val);
            updateEmp();
        }

        case 2: {
            Out.println("Enter ID: ");
            int kvl = scanner.nextInt();
            Out.println("Enter Age:");
            String age = br.readLine();
            EmpDatabase val = empMap.get(kvl);
            val.setAge(age);
            empMap.put(kvl, val);
            updateEmp();
        }
        case 3: {
            Out.println("Enter ID: ");
            int kvl = scanner.nextInt();
            Out.println("Enter Salary:");
            String salary = br.readLine();
            EmpDatabase val = empMap.get(kvl);
            val.setSalary(salary);
            empMap.put(kvl, val);
            updateEmp();
        }
        case 4: {
            Out.println("Enter ID: ");
            int kvl = scanner.nextInt();
            Out.println("Enter Contact number:");
            String phnnb = br.readLine();
            EmpDatabase val = empMap.get(kvl);
            val.setPhnNb(phnnb);
            empMap.put(kvl, EmpDatabase);
            updateEmp();
        }
        case 5:
            {
            homePage();
            }
        default:
            {
            System.out.println("Enter a valid input");
            updateEmp();
            }
    }
}
//    ---------------DELETE-METHOD--------
    public void deleteEmp() {
        Out.print("Enter your choice : " +
                "\nDelete all - 1" +
                "\nDelete by ID - 2");
        int dl = scanner.nextInt();
        switch (dl) {
            case 1: {
                empMap.clear();
                homePage();
            }
            case 2: {
                Out.print("Enter ID : ");
                int dlId = scanner.nextInt();
                empMap.remove(dlId);
                deleteEmp();
            }
            case 3: {
                homePage();
            }
            default: {
                Out.print("Enter valid input");
            }
        }

    }
//-----------------HOME-METHOD----------
    public void homePage()
    {
        Out.print("""
                -----Welcome to the employee detail portal-----
                Enter your Choice
                Add Employee - 1
                View Employee - 2
                Update Employee - 3
                Delete Employee - 4
                Exit - 5
                """);
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        try{ switch (i)
        {
            case 1:{
                id++;
                addEmp();
                break;
            }
            case 2:{viewEmp();break;}
            case 3:{updateEmp();break;}
            case 4:{deleteEmp();break;}
            case 5:{Out.print("Thank you...see you next.");break;}
        }}catch (Exception e) {
            Out.print("Invalid input...please enter a valid input.");
            homePage();
        }
    }
}
