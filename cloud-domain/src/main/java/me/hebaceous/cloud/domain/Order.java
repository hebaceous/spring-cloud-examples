package me.hebaceous.cloud.domain;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private static final long serialVersionUID = -2224568430533528507L;
    private Long id;
    private Date date;
    private Long userId;
    private User user;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Order setDate(Date date) {
        this.date = date;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Order setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
