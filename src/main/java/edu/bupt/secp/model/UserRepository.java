package edu.bupt.secp.model;

import edu.bupt.secp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select * from user limit ?1", nativeQuery = true)
    List<User> findTopN(Integer n);

    @Query(value = "select id from user where name = ?1", nativeQuery = true)
    Integer findIdbyName(String name);
}
