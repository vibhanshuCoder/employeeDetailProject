package com.empPackage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class EmpServices {
    public Map<Integer, EmpDatabase> empMap = new HashMap<>();
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int id = 0;
    public int i;
    public PrintStream Out = new PrintStream(new FileOutputStream(FileDescriptor.out));
    public EmpDatabase empDatabase = new EmpDatabase();

    //    -----------ADD-NAME-METHOD------------------
    public void addName() {
        Out.println("Enter Employee Name");
        try {
            String name = br.readLine();

            if (name != null) {
                empDatabase.setName(name);
                addAge();
            } else {
                Out.println("please enter a valid name");
                addName();
            }
        } catch (Exception exp) {
            Out.println("Wrong Input type");
            addName();
        }
    }

    //    ---------------ADD-AGE-METHOD-------------
    private void addAge() throws IOException {
        Out.println("Enter Employee Age");
        int age = Integer.parseInt(br.readLine());
        if (age > 60 || age < 18) {
            Out.println("Please enter a valid age");
            addAge();
        } else {
            empDatabase.setAge(age);
            addSalary();
        }
        homePage();
    }

    private void addSalary() throws IOException {
        Out.println("Enter Employee Salary");
        String salary = br.readLine();
        if (salary.matches("^[1-9]{5,10}$")) {
            empDatabase.setSalary(salary);
            addPhnb();
        } else {
            Out.println("please Enter valid salary");
            addSalary();
        }

    }

    private void addPhnb() throws IOException {
        Out.println("Enter Employee ContactNo.");
        String phnb = br.readLine();
        if (phnb.matches("^[6-9][0-9]{9}$")) {
            empDatabase.setPhnNb(phnb);
        } else {
            Out.println("Enter valid mobile number");
            addPhnb();
        }
        empMap.put(id, empDatabase);
        homePage();
    }

    //    ---------------ADD-METHOD-------------------
    public void addEmp() throws IOException {

//        Out.print("Enter employee name : ");
//        String name = br.readLine();
//        empDatabase.setName(name);    id+
        id++;
        addName();

//        Out.print("Enter employee age : ");
//        String age = br.readLine();
//        empDatabase.setAge(age);
//        Out.print("Enter employee salary : ");
//        String salary = br.readLine();
//        empDatabase.setSalary(salary);
//        Out.print("Enter employee contact number : ");
//        String phnNb= br.readLine();
//        empDatabase.setPhnNb(phnNb);
//        empMap.put(id, empDatabase);
        Out.print("-----------Data Added successfully-------------\n");
        homePage();
    }

    //    ------------------VIEW-METHOD-----------
    public void viewEmp()
            throws IOException {

        Out.print("""
                Enter your choice
                View All - 0
                View by Id - 1
                Home - 2
                """);
        try {
            i = Integer.parseInt(br.readLine());
        } catch (Exception exp) {
            Out.print("Please enter a valid choice");
            viewEmp();
        }
        switch (i) {
            case 0: {
                for (Map.Entry ery : empMap.entrySet()) {
                    System.out.println("ID : " + ery.getKey() + ery.getValue().toString());
                }
                viewEmp();
            }

            case 1: {
                System.out.println("Enter ID : ");
                int keyval = Integer.parseInt(br.readLine());
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
public void updateEmp() throws IOException {
    System.out.println("""
            Enter choice which data you want to update
            update all detail - 0
            Name :- 1
            Age :- 2
            Salary :- 3
            ContactNo. :-4
            Exit to home :- 5
            """);
    try {
        i = Integer.parseInt(br.readLine());
    } catch (Exception exp) {
        Out.print("Please enter a valid choice");
        updateEmp();
    }
    switch (i) {
        case 0: {
            Out.println("Enter ID: ");
            int kvl = Integer.parseInt(br.readLine());
            Out.println("Enter Name:");
            String name = br.readLine();
            empDatabase.setName(name);
            Out.println("Enter Age:");
            int age = Integer.parseInt(br.readLine());
            empDatabase.setAge(age);
            Out.println("Enter Salary:");
            String salary = br.readLine();
            empDatabase.setSalary(salary);
            Out.println("Enter Contact number:");
            String phnnb = br.readLine();
            empDatabase.setPhnNb(phnnb);
            empMap.put(kvl, empDatabase);
            updateEmp();
        }
        case 1: {
            Out.println("Enter ID: ");
            int kvl = Integer.parseInt(br.readLine());
            Out.println("Enter Name:");
            String name = br.readLine();
            EmpDatabase val = empMap.get(kvl);
            val.setName(name);
            empMap.put(kvl, val);
            updateEmp();
        }

        case 2: {
            Out.println("Enter ID: ");
            int kvl = Integer.parseInt(br.readLine());
            Out.println("Enter Age:");
            int age = Integer.parseInt(br.readLine());
            empDatabase = empMap.get(kvl);
            empDatabase.setAge(age);
            empMap.put(kvl, empDatabase);
            updateEmp();
        }
        case 3: {
            Out.println("Enter ID: ");
            int kvl = Integer.parseInt(br.readLine());
            Out.println("Enter Salary:");
            String salary = br.readLine();
            empDatabase = empMap.get(kvl);
            empDatabase.setSalary(salary);
            empMap.put(kvl, empDatabase);
            updateEmp();
        }
        case 4: {
            Out.println("Enter ID: ");
            int kvl = Integer.parseInt(br.readLine());
            Out.println("Enter Contact number:");
            String phnnb = br.readLine();
            empDatabase = empMap.get(kvl);
            empDatabase.setPhnNb(phnnb);
            empMap.put(kvl, empDatabase);
            updateEmp();
        }
        case 5:
            {
                homePage();
            }
        default: {
            System.out.println("Enter a valid input");
            updateEmp();
        }
    }
}

    //    ---------------DELETE-METHOD--------
    public void deleteEmp() throws IOException {
        Out.print("Enter your choice : " +
                "\nDelete all - 1" +
                "\nDelete by ID - 2");
        try {
            i = Integer.parseInt(br.readLine());
        } catch (Exception exp) {
            Out.print("Please enter a valid choice");
            deleteEmp();
        }
        switch (i) {
            case 1: {
                empMap.clear();
                homePage();
            }
            case 2: {
                Out.print("Enter ID : ");
                int dlId = Integer.parseInt(br.readLine());
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
    public void homePage() {
        Out.print("""
                -----Welcome to the employee detail portal-----
                Enter your Choice
                Add Employee - 1
                View Employee - 2
                Update Employee - 3
                Delete Employee - 4
                Exit - 5
                """);
        try {
            i = Integer.parseInt(br.readLine());
        } catch (Exception exp) {
            Out.print("please enter a valid choice");
            homePage();
        }
        try {
            switch (i) {
                case 1: {
                    id++;
                    addEmp();
                    break;
                }
                case 2: {
                    viewEmp();
                    break;
                }
                case 3: {
                    updateEmp();
                    break;
                }
                case 4: {
                    deleteEmp();
                    break;
                }
            case 5:{Out.print("Thank you...see you next.");break;}
        }}catch (Exception e) {
            Out.print("Invalid input...please enter a valid input.");
            homePage();
        }
    }
}
