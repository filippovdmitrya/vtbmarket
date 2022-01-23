package ru.vtbmarket.entities;

import javax.persistence.*;

@Entity
@Table(name = "basket_list")
public class BasketListEntity {
    @Id
    private Integer id;

    @Column(name = "basket_id")
    private Integer basket_id;

    @Column(name = "goods_id")
    private Integer goods_id;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "price")
    private Integer price;

    public BasketListEntity() {
    }

    public BasketListEntity(Integer basket_id, Integer goods_id, Integer qty, Integer price) {
        this.basket_id = basket_id;
        this.goods_id = goods_id;
        this.qty = qty;
        this.price = price;
    }

    public BasketListEntity(Integer id, Integer basket_id, Integer goods_id, Integer qty, Integer price) {
        this.id = id;
        this.basket_id = basket_id;
        this.goods_id = goods_id;
        this.qty = qty;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(Integer basket_id) {
        this.basket_id = basket_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("(%d) \t basket_id = %d; goods_id = %d; qty = %d; price(int) = %d; \n",
                            id, basket_id, goods_id, qty, price);
    }
}
