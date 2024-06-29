package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.Order;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Override
    <S extends Order> S save(S entity);
    Order findOrderByOrderID(Integer orderID);
    @Override
    List<Order> findAll();
    @Query("SELECT o FROM Order o WHERE o.timestamp BETWEEN :start AND :end")
    List<Order> findAllOrdersByTimestampBetween(@Param("start") Timestamp start, @Param("end") Timestamp end, Pageable pageable);

    @Query("SELECT o FROM Order o WHERE o.timestamp BETWEEN :start AND :end AND o.user.userID = :userID")
    List<Order> findOrdersByTimestampBetweenAndUserID(@Param("start") Timestamp start, @Param("end") Timestamp end, @Param("userID") Integer userID);

    @Query("SELECT o FROM Order o WHERE o.timestamp BETWEEN :start AND :end AND o.user.userID = :userID")
    Page<Order> findOrdersByTimestampBetweenAndUserIDWithPage(@Param("start") Timestamp start, @Param("end") Timestamp end, @Param("userID") Integer userID, Pageable pageable);
}
