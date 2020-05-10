package com.app.vegetable.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.vegetable.jpa.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("SELECT p FROM Product p WHERE p.productName =:productName")
	Product findByProductName(@Param("productName") String productName);

	

}
