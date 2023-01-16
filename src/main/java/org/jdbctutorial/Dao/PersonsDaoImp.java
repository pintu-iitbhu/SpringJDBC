package org.jdbctutorial.Dao;

import org.jdbctutorial.Dto.Person;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonsDaoImp implements PersonsDao {

    private JdbcTemplate jdbcTemplate;
    public int insert(Person person) {

        String query = "INSERT INTO Persons(id, FirstName, Lastname, City, Address) VALUES(?,?,?,?,?)";
        int r = this.jdbcTemplate.update(query, person.getId(),person.getFirstName(),person.getLastName(),person.getCity(), person.getAddress());
        return r;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
