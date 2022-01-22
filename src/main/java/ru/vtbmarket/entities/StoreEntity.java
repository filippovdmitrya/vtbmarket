package ru.vtbmarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
public class StoreEntity {
    @Id
    private Integer id;

    @Column(name = "goods_id")
    private Integer goods_id;

    @Column(name = "price")
    private Integer price;

    @Column(name = "balance")
    private Integer balance;

//    @OneToMany(mappedBy = "goods_id", targetEntity = GoodsEntity.class)
//    private List<GoodsEntity> goods;

    @Version
    private int version;

    public StoreEntity() {
    }

    public StoreEntity(Integer id, Integer goods_id, Integer price, Integer balance) {
        this.id = id;
        this.goods_id = goods_id;
        this.price = price;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  String.format("\n\t (%d) goods_id = %d; price(int) = %d; balance = %d", id, goods_id, price, balance);
    }
}
