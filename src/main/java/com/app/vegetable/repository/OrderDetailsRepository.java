package com.app.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.vegetable.jpa.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}
