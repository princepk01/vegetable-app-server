package com.app.vegetable.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.vegetable.jpa.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("SELECT user FROM User user WHERE user.mobileNumber =:mobileNumber AND user.password =:password")
	User getUserByMobileNumberAndPassword(@Param("mobileNumber") String mobileNumber, @Param("password") String password);

	@Query("SELECT user FROM User user WHERE user.emailAddress =:emailAddress AND user.password =:password")
	User getuserByEmailAddressAndPassword(@Param("emailAddress") String emailAddress, @Param("password") String password);

}
