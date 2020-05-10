package com.app.vegetable.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.vegetable.jpa.ProductItem;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {

	@Query("SELECT item FROM ProductItem item WHERE item.product.id =:productId")
	List<ProductItem> getProductItemsByProductId(@Param("productId") int productId);

//	@Query("SELECT item FROM ProductItem item WHERE item.product.productName =:productName")
//	List<ProductItem> getProductItemByProductName(@Param("productName") String productName);

}
