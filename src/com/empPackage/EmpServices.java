package com.empPackage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.empPackage.*;

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

            case 1:
            {
                System.out.println("Enter ID : ");
                int keyval = scanner.nextInt();
                EmpDatabase val = empMap.get(keyval);
                System.out.println(val);
                viewEmp();
            }
                    break;
            case 2:{homePage();}

            default:
            {
                Out.print("Please enter valid input");
                break;
            }
        }}

//    ---------------UPDATE-METHOD--------
public void updateEmp() throws IOException
{
    System.out.println("""
                Enter choice which data you want to update
                Name :- 0
                Age :- 1
                Salary :- 2
                ContactNo. :-3
                Exit to home :- 4
                """);
    int se = scanner.nextInt();
    switch (se)
    {
        case 0:
            {
            Out.println("Enter ID: ");
            int kvl = scanner.nextInt();
            Out.println("Enter Name:");
            String name = br.readLine();
            EmpDatabase.setName(name);
            empMap.put(kvl,EmpDatabase);
            updateEmp();
            }
        case 1:
            {
            Out.println("Enter ID: ");
            int kvl = scanner.nextInt();
            Out.println("Enter Age:");
            String age = br.readLine();
          /*  empMap.put(kvl,empDatabase.setAge(age));*/
            updateEmp();
            }
        case 2:
            {
            Out.println("Enter ID: ");
            int kvl = scanner.nextInt();
            Out.println("Enter Salary:");
            String salary=br.readLine();
//            empMap.put(kvl,empDatabase.setSalary(salary));
            updateEmp();
            }
        case 3:
            {
            Out.println("Enter ID: ");
            int kvl = scanner.nextInt();
            Out.println("Enter Contact number:");
            String phnnb= br.readLine();
//            empMap.put(kvl,empDatabase.setPhnNb(phnnb));
            updateEmp();
            }
        case 4:
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
        empMap.clear();
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
