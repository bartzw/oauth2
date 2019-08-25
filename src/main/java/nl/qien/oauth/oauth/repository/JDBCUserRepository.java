package nl.qien.oauth.oauth.repository;


import nl.qien.oauth.oauth.controller.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JDBCUserRepository implements UserRepository {

    // Spring Boot will create and configure DataSource and JdbcTemplate
    // To use it, just @Autowired
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from User", Integer.class);
    }


    @Override
    public int save(User user) {
        return jdbcTemplate.update(
                "insert into User (ID, FIRSTNAME, LASTNAME) values(?,?,?)",
                user.getId(), user.getFirstName(), user.getLastName());
    }

    @Override
    public Boolean checkPassword(String email, String password) {
        String sqlQuery = "select count(*) from User where email =? and password =?";
        Object[] arrayWithParameters = {email, password};
        int count = jdbcTemplate.queryForObject(sqlQuery, arrayWithParameters, Integer.class);
        return count == 1 ? true: false;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from User where ID = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new User(
                                rs.getLong("ID"),
                                rs.getString("FIRST_NAME"),
                                rs.getString("LAST_NAME"),
                                rs.getString("email"),
                                rs.getString("password")
                        ))
        );
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select * from User",
                (rs, rowNum) ->
                        new User(
                                rs.getLong("id"),
                                rs.getString("first_Name"),
                                rs.getString("last_Name"),
                                rs.getString("email"),
                                rs.getString("password")
                        )
        );
    }

    /*
    @Override
    public int update(Employee Employee) {
        return jdbcTemplate.update(
                "update Employee set name = ? where id = ?",
                Employee.getname(), Employee.getId());
    }


    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete Employee where id = ?",
                id);
    }




    @Override
    public List<Employee> findByNameAndname(String name, BigDecimal name) {
        return jdbcTemplate.query(
                "select * from Employee where name like ? and name <= ?",
                new Object[]{"%" + name + "%", name},
                (rs, rowNum) ->
                        new Employee(
                                rs.getLong("id"),
                                rs.getString("name"),
                        )
        );
    }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select name from Employee where id = ?",
                new Object[]{id},
                String.class
        );
    }
    */
}

