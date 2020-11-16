/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernateexercisesbasic;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jordan
 */
public class HibernateApp {
    public static void main(String[] args) {
        
        
        //Create students
        Student s1 = new Student();
        s1.setStudent_number(333111);
        s1.setLname("Jobs");
        s1.setfName("Michael");
        s1.setGrade(8);
        
        Student s2 = new Student();
        s2.setStudent_number(369741);
        s2.setLname("Smith");
        s2.setfName("Bob");
        s2.setGrade(3);
        
        
        //TODO make the necessarry arrangements so that NINI and REX are inside the database
        Animal a1 = new Animal();
        a1.setId(0);
        a1.setSpecies("feline");
        a1.setName("NINI");
        a1.setAge(3);
        
        Animal a2 = new Animal();
        a2.setId(1);
        a2.setSpecies("canine");
        a2.setName("REX");
        a2.setAge(5);
        /////////////////////////////////////////////////////////////////////////////////
        
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        
        //TODO Create the ANIMAL TABLE within the database; TIP a new configuration is required
        
        SessionFactory sf = conf.buildSessionFactory();
        
        
        Session session = sf.openSession();
        
        Transaction tc = session.beginTransaction();
        
        session.save(s1);
        
        
        Student get_student = (Student) session.get(Student.class, 333111);
        System.out.println(get_student.getfName());
        
        
        get_student.setfName("Steve");
        session.update(get_student);
        
        
        session.delete(s1);
        
        
        //HQL 
        Query query = session.createQuery("from Student");
        List list = query.list();
        
        //HCQL
        Criteria crit_query = session.createCriteria(Student.class);
        crit_query.add(Restrictions.eq("grade", 8));
        List results = crit_query.list();
        
        //TODO1 Save NINI and REX in the Animal Table
        
        
        //TODO2 Change NINI's age to 4 
        
       
        
        //TODO3 ADD for NINI and REX SQL and HCQL 
        //1. Fetch NINI from database using SQL 
        //2. Fetch animals that are younger then 6 years old using HCQL
        
        tc.commit();
        

    }
}
