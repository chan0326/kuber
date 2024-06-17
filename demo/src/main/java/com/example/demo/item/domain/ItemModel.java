package com.example.demo.item.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.order.domain.OrderModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Entity
@Data
@Table(name = "items")

public class ItemModel {
    @Id
    @Column(name = "item_id")
    private long itemId;
    @Column(name = "item_brand")
    private String itemBrand;
    @Column(name = "model_no")
    private String modelNo;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_color")
    private String itemColor;
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "sold_out")
    private Boolean soldOut;
    @OneToMany(mappedBy = "item")
    private List<OrderModel> orders = new ArrayList<>();







    @Builder
    public ItemModel(long itemId, String itemName, String itemColor, String releaseDate, String modelNo, String itemBrand, Boolean soldOut, List<OrderModel> orders) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemColor = itemColor;
        this.releaseDate = releaseDate;
        this.modelNo = modelNo;
        this.itemBrand = itemBrand;
        this.soldOut = soldOut;
        this.orders = orders;
    }
}
