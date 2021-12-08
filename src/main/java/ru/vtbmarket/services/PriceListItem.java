package ru.vtbmarket.services;

public class PriceListItem {
    private final String    name;
    private final String    description;
    private final float     price;
    private final int       balance;

    @Override
    public String toString() {
        return  "| " + "наименование ='" + name + '\'' +
                ", цена = " + price +
                ", остаток = " + balance + '|';
    }

    public String getDescription() {
        return description;
    }

    public PriceListItem(String name, String description, float price, int balance) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.balance = balance;
    }

}
