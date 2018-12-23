package edu.bupt.secp.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import edu.bupt.secp.model.Meau;

import java.util.List;

public interface MeauRepository extends CrudRepository<Meau, Iterable> {

    @Query(value = "select * from meau where restaurant_id = ?1", nativeQuery = true)
    List<Meau> findMeausByRestaurant_id(Integer n);
}
