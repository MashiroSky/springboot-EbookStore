package com.bookstore.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;
    Date time;

    @Column(name="userID")
    int userID;
    double price;

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userId) {
        this.userID = userId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
