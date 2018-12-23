package edu.bupt.secp.model;

import edu.bupt.secp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
