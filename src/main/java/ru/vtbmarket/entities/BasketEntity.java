package ru.vtbmarket.entities;

import javax.persistence.*;

@Entity
@Table(name = "basket")
public class BasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    public BasketEntity() {
    }

    public BasketEntity(String username) {
        this.username = username;
    }

    public BasketEntity(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("\n\t (%d) username = %s;", id, username);
    }
}
