package edu.bupt.secp.model;

import edu.bupt.secp.model.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
    @Query(value = "select id from restaurant where name = ?1", nativeQuery = true)
    Integer findIdbyName(String name);

}
