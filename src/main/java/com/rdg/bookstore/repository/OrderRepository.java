package com.rdg.bookstore.repository;

import com.rdg.bookstore.entity.Customer;
import com.rdg.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByCustomer(Customer customer);
}
