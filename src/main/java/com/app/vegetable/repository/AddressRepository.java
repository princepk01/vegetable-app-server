package com.app.vegetable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.vegetable.jpa.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer>{

	@Query("SELECT address FROM Address address WHERE address.user.id =:userId")
	List<Address> getAddressByUserId(@Param("userId") int userId);
	

}
