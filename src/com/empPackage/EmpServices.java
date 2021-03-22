package com.empPackage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class EmpServices {
    private String nameref;
    private int ageref = 18;
    private String phNbref;
    private String salaryref;
    public Map<Integer, EmpDatabase> empMap = new HashMap<>();
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int id = 1010;
    private int idexp;
    public int i;
    public PrintStream Out = new PrintStream(new FileOutputStream(FileDescriptor.out));
    public EmpDatabase empDatabase = new EmpDatabase();

    public int IDvalid() throws IOException {
        Out.print("Enter ID : DZ");
        int idref = Integer.parseInt(br.readLine());
        try {
            if (idref != 0) {
                idexp = idref;
            } else {
                Out.println("Please enter a valid ID");
                IDvalid();
            }
        } catch (Exception exp) {
            Out.println("Please enter a valid ID");
            IDvalid();
        }
        return idexp;
    }

    //    -----------ADD-NAME-METHOD------------------
    public String addName() throws IOException {
        Out.println("Enter Employee Name");
        nameref = br.readLine();
        try {
            if (nameref.matches("^[a-zA-Z\\s]{4,30}$")) {
                empDatabase.setName(nameref);
            } else {
                Out.println("please enter a valid name");
                addName();
            }
        } catch (Exception exp) {
            Out.println("Please enter a valid name");
            addName();
        }
        return nameref;
    }

    //    ---------------ADD-AGE-METHOD-------------
    private int addAge() {
        Out.println("Enter Employee Age");
        ageref = 18;
        try {
            ageref = Integer.parseInt(br.readLine());
            if (ageref < 60 && ageref > 18) {
                empDatabase.setAge(ageref);

            } else {
                Out.println("Enter valid age");
                addAge();
            }
        } catch (Exception exp) {
            Out.println("Wrong input-type");
            addAge();
        }
        return ageref;
    }

    private String addSalary() throws IOException {
        Out.println("Enter Employee Salary");
        salaryref = br.readLine();
        if (salaryref.matches("^[1-9]*\\d{4,10}$")) {
            empDatabase.setSalary(salaryref);
        } else {
            Out.println("please Enter valid salary");
            addSalary();
        }
        return salaryref;
    }

    private String addPhnb() throws IOException {
        Out.println("Enter Employee ContactNo.");
        phNbref = br.readLine();
        try {
            if (phNbref.matches("^[6-9]\\d{9}$")) {
                empDatabase.setPhnNb(phNbref);
            } else {
                Out.println("Enter valid mobile number");
                addPhnb();
            }
        } catch (Exception exp) {
            Out.println("Enter a valid mobile number");
            addPhnb();
        }
        return phNbref;
    }

    //    ---------------ADD-METHOD-------------------
    public void addEmp() throws IOException {


        String name = addName();
        int age = addAge();
        String phnb = addPhnb();
        String salary = addSalary();
        EmpDatabase epdb = new EmpDatabase(name, age, phnb, salary);
        empMap.put(id, epdb);
        Out.println("-----------Data Added successfully-------------");
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
                Update - 3
                """);
        try {
            i = Integer.parseInt(br.readLine());
        } catch (Exception exp) {
            Out.print("Please enter a valid choice");
            viewEmp();
        }
        switch (i) {
            case 0: {
                if (empMap != null) {
                    for (Map.Entry ery : empMap.entrySet()) {
                        Out.println("ID : DZ" + ery.getKey() + ery.getValue().toString());
                    }
                    viewEmp();
                } else {
                    Out.println("---No Record to show---");
                    viewEmp();
                }
            }

            case 1: {
                int keyval = IDvalid();
                if (empMap != null && empMap.containsKey(keyval)) {
                    EmpDatabase val = empMap.get(keyval);
                    Out.print("ID : DZ" + keyval + "" + val);
                    viewEmp();
                } else {
                    Out.println("---No record present with this ID---");
                }
            }
            case 2: {
                homePage();
            }
            case 3: {
                updateEmp();
            }

            default: {
                Out.print("Please enter valid input");
                break;
            }
        }}

    //    ---------------UPDATE-METHOD--------
    public void updateEmp() {
        EmpDatabase val;
        System.out.println("""
                Enter choice which data you want to update
                update all detail - 0
                Name :- 1
                Age :- 2
                Salary :- 3
                ContactNo. :-4
                Exit to home :- 5
                View :- 6
                """);
        try {
            i = Integer.parseInt(br.readLine());
        } catch (Exception exp) {
            Out.print("Enter valid choice");
            updateEmp();
        }
        try {
            switch (i) {
                case 0: {
                    int kvl = IDvalid();
                    String name = addName();
                    empDatabase.setName(name);
                    int age = addAge();
                    empDatabase.setAge(age);
                    String salary = addSalary();
                    empDatabase.setSalary(salary);
                    String phnnb = addPhnb();
                    empDatabase.setPhnNb(phnnb);
                    empMap.put(kvl, empDatabase);
                    updateEmp();
                }
                case 1: {
                    int kvl = IDvalid();
                    String name = addName();
                    val = empMap.get(kvl);
                    val.setName(name);
                    empMap.put(kvl, val);
                    updateEmp();
                }

                case 2: {
                    int kvl = IDvalid();
                    int age = addAge();
                    val = empMap.get(kvl);
                    empDatabase.setAge(age);
                    empMap.put(kvl, val);
                    updateEmp();
                }
                case 3: {
                    int kvl = IDvalid();
                    String salary = addSalary();
                    val = empMap.get(kvl);
                    empDatabase.setSalary(salary);
                    empMap.put(kvl, val);
                    updateEmp();
                }
                case 4: {
                    int kvl = IDvalid();
                    ;
                    String phnnbref = addPhnb();
                    val = empMap.get(kvl);
                    empDatabase.setPhnNb(phnnbref);
                    empMap.put(kvl, val);
                    updateEmp();
                }
                case 5: {
                    homePage();
                }
                case 6: {
                    viewEmp();
                }
                default: {
                    Out.println("Enter valid choice");
                    updateEmp();
                }
            }
        } catch (Exception exp) {
            Out.println("Enter valid choice");
        }
}

    //    ---------------DELETE-METHOD--------
    public void deleteEmp() throws IOException {
        Out.print("Enter your choice : " +
                "\nDelete all - 1" +
                "\nDelete by ID - 2" +
                "\nView - 3" +
                "\nHomePage - 4");
        try {
            i = Integer.parseInt(br.readLine());
        } catch (Exception exp) {
            Out.print("Enter valid choice");
            deleteEmp();
        }
        try {
            switch (i) {
                case 1: {
                    if (empMap != null) {
                        empMap.clear();
                        Out.println("--Record deleted successfully--");
                        homePage();
                    } else {
                        Out.println("No record to delete..");
                        homePage();
                    }


                }
                case 2: {
                    int dlId = IDvalid();
                    if (empMap != null && empMap.containsKey(dlId)) {
                        empMap.remove(dlId);
                        deleteEmp();
                        Out.println("----Record deleted Successfully----");
                    } else {
                        Out.println("---No record present with this ID---");
                        deleteEmp();
                    }
                }
                case 3: {
                    viewEmp();
                }
                case 4: {
                    homePage();
                }
                default: {
                    Out.print("Enter valid Choice");
                }
            }
        } catch (Exception exp) {
            Out.println("Enter valid Choice");
            deleteEmp();
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
                case 5: {
                    Out.print("Thank you...see you next.");
                    break;
                }
                default: {
                    Out.println("Enter valid choice");
                    homePage();
                }
            }}catch (Exception e) {
            Out.print("Invalid input...please enter a valid input.");
            homePage();
        }
    }
}
