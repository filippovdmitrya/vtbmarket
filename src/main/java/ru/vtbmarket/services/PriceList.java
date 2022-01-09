package ru.vtbmarket.services;

import org.springframework.stereotype.Service;
import ru.vtbmarket.services.model.PriceListItem;

import java.util.HashMap;
import java.util.Map;

@Service
public class PriceList {
    private final Map<Integer, PriceListItem> goods = new HashMap<>();
    private void  init() {
        System.out.println("инициализирую прайс лист");
        goods.put(1, new PriceListItem("Товар 1", "Описание товара 1", 1.50f,20));
        goods.put(2, new PriceListItem("Товар 2", "Описание товара 2", 110.0f,1));
        goods.put(3, new PriceListItem("Товар 3", "Описание товара 3", 10.0f,88));
    }

    public PriceList() {
        init();
    }

    public void show() {
        System.out.println("Показываю прайс лист");
        for (Map.Entry<Integer, PriceListItem> entry: goods.entrySet()) {
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

    public PriceListItem get(int n) {
        return goods.get(n);
    }
}
