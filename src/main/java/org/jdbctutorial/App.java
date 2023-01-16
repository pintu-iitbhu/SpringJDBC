package org.jdbctutorial;

import org.jdbctutorial.Dao.PersonsDaoImp;
import org.jdbctutorial.Dto.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! : Starting the programs....." );
        //spring jdbc ==> template
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplateConfig.xml");
//        JdbcTemplate template= context.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        ///query
//        String query = "INSERT INTO Persons(id, FirstName, Lastname, City, Address) VALUES(?,?,?,?,?)";
//        int result = template.update(query, 22, "Dhiraj", "Yadav", "taraiya", "Saran");

        PersonsDaoImp personsDaoImp = context.getBean("p1", PersonsDaoImp.class);
        Person p= new Person();
        p.setId(33);
        p.setAddress("blr");
        p.setCity("mumbai");
        p.setFirstName("Prateek");
        p.setLastName("Raman");

        int result = personsDaoImp.insert(p);
        System.out.println("Number of recoreds inserted " + result);



    }
}
