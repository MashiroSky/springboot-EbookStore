package com.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "book_in_order")
public class BookinOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderID;
    private int bookID;
    private int userID;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderid) {
        this.orderID = orderid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getBookID() {
        return bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setBookID(int bookid) {
        this.bookID = bookid;
    }

    public void setUserID(int userid) {
        this.userID = userid;
    }
}
