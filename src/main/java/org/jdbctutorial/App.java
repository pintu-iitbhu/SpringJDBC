package org.jdbctutorial;

import org.jdbctutorial.Configs.JdbcConfig;
import org.jdbctutorial.Dao.PersonsDaoImp;
import org.jdbctutorial.Dto.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
//        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplateConfig.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//        PersonsDaoImp p1 = ctx.getBean("p1",PersonsDaoImp.class);
//        JdbcTemplate template= context.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        ///query
//        String query = "INSERT INTO Persons(id, FirstName, Lastname, City, Address) VALUES(?,?,?,?,?)";
//        int result = template.update(query, 22, "Dhiraj", "Yadav", "taraiya", "Saran");

        PersonsDaoImp personsDaoImp = context.getBean("p1", PersonsDaoImp.class);

        Person p= new Person();
        p.setId(336);
        p.setAddress("blr2");
        p.setCity("mumbai2");
        p.setFirstName("Prateek");
        p.setLastName("Raman");

        int result = personsDaoImp.insert(p);
        System.out.println("Number of recoreds inserted " + result);

        int res = personsDaoImp.delete(336);
        System.out.println("Deleting the records inserted " + res);

        Person per = personsDaoImp.getPerson(22);
        System.out.println("Records for the give id " + per);

        List<Person> personList= personsDaoImp.getAllPersons();
        for (Person person : personList){
            System.out.println("Number of recoreds inserted " + person);
        }



    }
}
