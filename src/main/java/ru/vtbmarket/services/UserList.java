package ru.vtbmarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.vtbmarket.annotation.Controllable;
import ru.vtbmarket.services.interfaces.*;
import ru.vtbmarket.services.model.BasketItem;
import ru.vtbmarket.services.model.PricelistItem;
import ru.vtbmarket.services.model.User;
import ru.vtbmarket.services.model.UserSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserList {
    private final Map<String, User> customers = new HashMap<>();
    private UserSession session;

    @Autowired
    private Notificator notificator;

    @Autowired
    private MarketUsersService marketUsersService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private BasketListService basketListService;

    @Autowired
    private StoreService storeService;

    /*
    private void  init() {
        System.out.println("инициализация списка пользователей");

        customers.put("user1", new User(1, "Ivan", "Ivanov",
                "ivan@supermail.ru", "*", "user1"));
        customers.put("user2", new User(2, "Masha", "Ivanova",
                "maria@supermail.ru", "*", "user2"));
    } */

    public UserList() {
//        init();
//        this.session = userLogin("user1", "*");
    }

    public void build(String userName) {
        System.out.println("инициализация списка пользователей из DB");
        reload();
        this.session = userLogin(userName, "*");
    }

    private void reload() {
        marketUsersService.getAll().forEach(
                p -> customers.put(p.getUsername(), new User(p.getId(), p.getName(), p.getLastname(),
                        p.getEmail(), "*", p.getUsername()))
        );
    }

    public String getStatus() {
        return "В базе пользователей " + customers.size() + " участников.";
    }

    public UserSession userLogin(String userName, String password) {
        if (customers.containsKey(userName)) {
            if (customers.get(userName).checkPassword(password)) {
                System.out.println("login user = " + userName);
                return new UserSession(userName);
            }
        }
        return null;
    }

    public void putBasket(PricelistItem goods, int qty) {
        if (goods.getBalance() >= qty) {
            BasketItem i = new BasketItem(goods, qty);
            notificator.notify("положили в корзину товар = " + goods.toString() + " в количестве = " + qty);
            session.putBasket(i);
        }
        else {
            notificator.notify("Остаток товара на складе " + goods.toString()
                    + " недостаточен, чтобы положить в корзину количество = " + qty);
        }
    }

    @Controllable
    public void makeOrder() {
        int k = session.getBasketSize();
        double s = session.getBasketSum();
        notificator.notify("оформление заказа, в корзине " + k + " позиций; на сумму = " + s);
        notificator.notify("сохранение корзины, сессия пользователя " + session.getUsername());
        processOrder();
    }

    @Transactional(
            propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.DEFAULT,
            timeout = 30,
            readOnly = false,
            rollbackFor = {RuntimeException.class}
    )
    public void processOrder(){
        if (session.getBasket().size() > 0) {
            int basket_id = basketService.create(session.getUsername());

            List<BasketItem> basket = session.getBasket();
            for (BasketItem basketItem : basket) {
                storeService.update(basketItem.getGoods().getStore_id(),
                        basketItem.getGoods().getGoods_id(),
                        basketItem.getGoods().getPrice(),
                        basketItem.getGoods().getBalance(),
                        basketItem.getQty());
                basketListService.create(basket_id, basketItem.getGoods().getGoods_id(),
                        basketItem.getQty(), basketItem.getGoods().getPrice());
            }
            notificator.notify("корзина сохранена; basket_id = " + basket_id);
        }
        else {
            notificator.notify("Корзина пуста; пользователь = " + session.getUsername());
        }
    }
}
