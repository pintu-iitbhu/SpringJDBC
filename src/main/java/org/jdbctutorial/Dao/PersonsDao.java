package org.jdbctutorial.Dao;

import org.jdbctutorial.Dto.Person;

import java.util.List;

public interface PersonsDao {
    public int insert(Person person);
    public int change(Person person);
    public int delete(int id);
    public Person getPerson(int id);
    public List<Person> getAllPersons();


}
