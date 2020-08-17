package com.app.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.vegetable.jpa.PlacedOrder;

@Repository
public interface PlacedOrderRepository extends JpaRepository<PlacedOrder, Integer> {

}
