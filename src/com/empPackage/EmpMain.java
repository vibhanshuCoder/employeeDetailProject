package com.empPackage;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class EmpMain
{
    private String name, phnNumber, age, emailId;
    public EmpMain() {
    }

    public EmpMain(String name, String age, String phnNumber, String emailId) {
        this.name = name;
        this.age = age;
        this.phnNumber = phnNumber;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhnNumber() {
        return phnNumber;
    }

    public void setPhnNumber(String phnNumber)
    {
        this.phnNumber = phnNumber;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
