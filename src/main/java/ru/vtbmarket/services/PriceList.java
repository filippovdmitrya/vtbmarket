package ru.vtbmarket.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.vtbmarket.services.model.PricelistItem;

import java.util.HashMap;
import java.util.Map;

@Service
@Lazy
public class PriceList {
    private final Map<Integer, PricelistItem> goods = new HashMap<>();
    private void  init() {
        System.out.println("инициализирую прайс лист");
        goods.put(1, new PricelistItem("Товар 1", "Описание товара 1", 150,20, 1));
        goods.put(2, new PricelistItem("Товар 2", "Описание товара 2", 11000,1, 2));
        goods.put(3, new PricelistItem("Товар 3", "Описание товара 3", 1000,88, 3));
    }

    public PriceList() {
        init();
    }

    public void show() {
        System.out.println("Показываю прайс лист");
        for (Map.Entry<Integer, PricelistItem> entry: goods.entrySet()) {
            System.out.println("N пп = " + entry.getKey() + entry.getValue().toString());
        }
    }

    public String showDescription(int n) {
        if (goods.containsKey(n)) {
            return goods.get(n).getDescription();
        } else {
            return "описание не найдено для элемента " + n;
        }
    }

    public PricelistItem get(int n) {
        return goods.get(n);
    }
}
