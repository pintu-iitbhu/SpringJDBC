package org.jdbctutorial.Configs;

import org.jdbctutorial.Dao.PersonsDao;
import org.jdbctutorial.Dao.PersonsDaoImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"org.jdbctutorial.Dao"})
public class JdbcConfig {
    @Bean(name = {"ds"})
    public DriverManagerDataSource getDataSource(){
       DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
       driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
       driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
       driverManagerDataSource.setPassword("RCpky@123");
       driverManagerDataSource.setUsername("root");
       return driverManagerDataSource;
    }

    @Bean(name = {"jdbcTemplate"})
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
//    @Bean(name = {"p1"})
//    public PersonsDao getPersonsDao(){
//        PersonsDaoImp daoImp = new PersonsDaoImp();
//        daoImp.setJdbcTemplate(getJdbcTemplate());
//        return daoImp;
//    }
}


