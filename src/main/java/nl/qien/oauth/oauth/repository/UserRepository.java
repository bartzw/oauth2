package nl.qien.oauth.oauth.repository;

import nl.qien.oauth.oauth.controller.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    int count();

    int save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();
    public Boolean checkPassword(String email, String password);


/*
    int update(Employee book);

    int deleteById(Long id);

    List<Employee> findAll();

    List<Employee> findByNameAndPrice(String name, BigDecimal price);


    String getNameById(Long id);
*/
}