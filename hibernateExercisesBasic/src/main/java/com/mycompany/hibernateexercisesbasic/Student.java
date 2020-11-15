/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernateexercisesbasic;
import java.util.List;

/**
 *
 * @author Jordan
 */
public class Student {
    //Add notations
    //Add Certificate
    
    int id;
    String fName;
    String lname;
    int age;
    

    public Student(int id, String fName, String lname) {
        this.id = id;
        this.fName = fName;
        this.lname = lname;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    
    
    
}
