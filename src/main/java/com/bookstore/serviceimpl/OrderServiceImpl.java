package com.bookstore.serviceimpl;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookinOrder;
import com.bookstore.entity.Order;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.BookinOrderRepository;
import com.bookstore.repository.OrderRepository;
import com.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BookinOrderRepository bookinOrderRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public Order NewOrder(int userID, double totprice) {
        Order order = new Order();
        Date time = new Date();
        order.setTime(time);
        order.setUserID(userID);
        order.setPrice(totprice);
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> FindAllByUserId(int userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public boolean Insert(int orderID, int userID, int bookID) {
        BookinOrder bookinOrder = new BookinOrder();
        bookinOrder.setBookID(bookID);
        bookinOrder.setUserID(userID);
        bookinOrder.setOrderID(orderID);
        bookinOrderRepository.save(bookinOrder);
        return true;
    }

    @Override
    public List<Book> FindByOrderID(int orderID) {
        List<BookinOrder> li = bookinOrderRepository.findAllByOrderID(orderID);
        List<Book> ret = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            int bookID = li.get(i).getBookID();
            ret.add(bookRepository.findById(bookID).get());
        }
        return ret;
    }


}
