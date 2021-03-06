package com.empPackage;
public class EmpDatabase {

    private String name;
    private int age;
    private String phnNb;
    private String salary;

    public EmpDatabase(String name, int age, String phnNb, String salary) {
        this.name = name;
        this.age = age;
        this.phnNb = phnNb;
        this.salary = salary;
    }

    EmpDatabase() {
    }

    public String getName() {
        return name;
    }

    public EmpDatabase setName(String name) {
        this.name = name;
        return null;
    }

    public int getAge() {
        return age;
    }

    public EmpDatabase setAge(int age) {
        this.age = age;
        return null;
    }

    public String getPhnNb() {
        return phnNb;
    }

    public EmpDatabase setPhnNb(String phnNb) {
        this.phnNb = phnNb;
        return null;
    }

    public String getSalary() {
        return salary;
    }

    public EmpDatabase setSalary(String salary) {
        this.salary = salary;
        return null;
    }

    @Override
    public String toString() {
        return "\nEmployee Detail{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phnNb='" + phnNb + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

}
