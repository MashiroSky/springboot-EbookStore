package com.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private int bookID;
    private int userID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public int getBookID() {
        return bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
