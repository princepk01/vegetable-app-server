package com.app.vegetable.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.vegetable.jpa.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	@Query("SELECT ci from CartItem ci where ci.user.id :=userId")
	List<CartItem> getCartItemByUserId(@Param("userId") int userId);

	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query("UPDATE CartItem ci SET ci.itemCount =:itemCount WHERE ci.id =:cartItemId"
	 * ) int updateById(@Param("cartItemId") int cartItemId, @Param("itemCount") int
	 * itemCount);
	 */

}
