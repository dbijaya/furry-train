package com.bijay.springbootjpa.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}

//public interface UserRepository extends JpaRepository<User, Integer> {
//	
//}
