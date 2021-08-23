package com.revature.hibernate_demo_app;

import org.hibernate.cfg.Configuration;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started..." );
        
        // create a configuration object
        Configuration cfg = new Configuration();
        
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        
        // open the session
        Session session = factory.openSession();
        
        // begin the transaction
        Transaction transaction = session.beginTransaction();
        
//       //create employee
//        Employee employee = new Employee();
//        employee.setId(2);
//        employee.setName("Tim");
//        employee.setEmail("t@mail.com");
//        
        // create address
//        Address address = new Address();
//        address.setCity("city 1");
//        address.setStreet("street 1");
//        address.setOpen(true);
//        address.setCreated(new Date());
//        address.setX(123.456);
//        
//        // save address & employee
//        session.save(employee);
//        session.save(address);
        
        // fetch data
        Address address1 = session.get(Address.class, 1);
        System.out.println(address1);
        
        Address address2 = session.get(Address.class, 2);
        System.out.println(address2);


        
        //
        
        // commit the transaction
        transaction.commit();
        
        // close the session
        session.close();
        
        
//        System.out.println(employee);
        
        
        
    }
}
