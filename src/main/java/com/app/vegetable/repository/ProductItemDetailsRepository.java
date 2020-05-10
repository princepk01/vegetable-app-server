package com.app.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.vegetable.jpa.ProductItemDetails;

@Repository
public interface ProductItemDetailsRepository extends JpaRepository<ProductItemDetails, Integer> {

}
