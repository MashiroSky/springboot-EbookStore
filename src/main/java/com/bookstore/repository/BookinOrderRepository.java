package com.bookstore.repository;

import com.bookstore.entity.BookinOrder;
import com.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookinOrderRepository extends JpaRepository<BookinOrder, Integer> {

    @Query("from BookinOrder where orderID = ?1")
    List<BookinOrder> findAllByOrderID(int orderID);
}
