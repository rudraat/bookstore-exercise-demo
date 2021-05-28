package com.rdg.bookstore.controller;

import com.rdg.bookstore.entity.Book;
import com.rdg.bookstore.entity.Customer;
import com.rdg.bookstore.entity.Order;
import com.rdg.bookstore.repository.BookRepository;
import com.rdg.bookstore.repository.CustomerRepository;
import com.rdg.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class OrderController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/addOrder")
    public ResponseEntity<Long> addOrder(@RequestParam Long customerId, @RequestBody List<Long> orderedBooks) {
        List<Book> books = bookRepository.findAllById(orderedBooks);
        Set<Book> setOBooks = new HashSet<>(books);
        Order currentOrder = new Order(customerRepository.getById(customerId), setOBooks);
        orderRepository.save(currentOrder);
        return new ResponseEntity<>(currentOrder.getOrderId(), HttpStatus.OK);
    }

    @GetMapping("/listOrders")
    public ResponseEntity<List<Order>> listOrdersByCId(@RequestParam Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return new ResponseEntity<>(orderRepository.findByCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrder")
    public ResponseEntity<String> deleteOrder(@RequestParam Long orderId) {
        orderRepository.deleteById(orderId);
        return new ResponseEntity<>("Succesfully deleted " + orderId, HttpStatus.OK);
    }

}
