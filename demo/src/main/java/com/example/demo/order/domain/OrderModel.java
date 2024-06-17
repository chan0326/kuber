package com.example.demo.order.domain;

import com.example.demo.item.domain.ItemModel;
import com.example.demo.user.domain.UserModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity @Data
@Table(name = "orders")
public class OrderModel {
    @Id @Column(name = "order_id")
    private long orderId;
    @Column(name = "price")
    private long price;
    @Column(name = "order_status")
    private String count;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private ItemModel item;
}