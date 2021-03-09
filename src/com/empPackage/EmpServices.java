package com.empPackage;
import javax.xml.namespace.QName;
//import java.util.logging.Logger;
import java.util.regex.*;
import java.util.*;
import java.util.logging.*;

public class EmpServices
{
    String name,age,phnNum,email;
    int id = 0;
    public EmpMain empObj = new EmpMain();
    public Scanner empScan = new Scanner(System.in);
    public ArrayList<String> empDetails = new ArrayList<>();
    public Map<Integer, ArrayList<String>> empMap = new HashMap<Integer, ArrayList<String>>();
    public void addEmp()
    {
        empMap.put(id, empDetails);
    }
    public void viewEmp(){

    }
    public void updateEmp()
    {

    }
    public void deleteEmp()
    {

    }
    public void homeEmp()
    {

    }
    public void main(String[] args)
    {


    }
}

