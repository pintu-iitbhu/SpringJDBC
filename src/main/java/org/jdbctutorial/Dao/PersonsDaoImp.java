package org.jdbctutorial.Dao;

import org.jdbctutorial.Dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("p1")
public class PersonsDaoImp implements PersonsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int insert(Person person) {
        String query = "INSERT INTO Persons(id, FirstName, Lastname, City, Address) VALUES(?,?,?,?,?)";
        int r = this.jdbcTemplate.update(query, person.getId(),person.getFirstName(),person.getLastName(),person.getCity(), person.getAddress());
        return r;
    }
    public int change(Person person) {
        String query = "UPDATE Persons SET FirstName =?, City=?";
        int r = this.jdbcTemplate.update(query,person.getFirstName(),person.getCity());
        return r;
    }
    public int delete(int id) {
        String query = "DELETE FROM Persons WHERE id=?";
        int r = this.jdbcTemplate.update(query,id);
        return r;
    }
    public Person getPerson(int id) {
        String query = "SELECT * FROM Persons WHERE id=?";
        RowMapper<Person> rowMapperImp = new RowMapperImp();
        Person person= this.jdbcTemplate.queryForObject(query,rowMapperImp, id);
        return person;
    }
    public List<Person> getAllPersons() {
        String query = "SELECT * FROM Persons";
        List<Person> persons =this.jdbcTemplate.query(query, new RowMapperImp());
        return persons;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
