package org.jdbctutorial.Dao;

import org.jdbctutorial.Dto.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImp implements RowMapper<Person> {
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person p = new Person();
        p.setId(resultSet.getInt(1));
        p.setFirstName(resultSet.getString(2));
        p.setLastName(resultSet.getString(3));
        p.setCity(resultSet.getString(4));
        p.setAddress(resultSet.getString(5));
        return p;
    }
}
