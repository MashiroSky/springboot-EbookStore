package com.bookstore.repository;

import com.bookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "from Cart where userID = :userId")
    List<Cart> findByUserId(@Param("userId") int userId);

    @Query(value = "from Cart where bookID = ?1")
    List<Cart> findByBookId(int id);
}
