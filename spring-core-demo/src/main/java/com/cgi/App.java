package com.cgi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
       ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
       Person p=context.getBean("person",Person.class);
       System.out.println(p.getPersonId()+" "+p.getPersonName());
       
       Employee e=context.getBean("e",Employee.class);
       System.out.println(e);
       
       
       Coach coach = context.getBean("coach", Coach.class);
       
       System.out.println(coach.getDailyWorkout());
    }
}
