package ru.vtbmarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtbmarket.annotation.Controllable;
import ru.vtbmarket.services.interfaces.Notificator;
import ru.vtbmarket.services.model.BasketItem;
import ru.vtbmarket.services.model.PriceListItem;
import ru.vtbmarket.services.model.User;
import ru.vtbmarket.services.model.UserSession;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserList {
    private final Map<String, User> customers = new HashMap<>();
    private UserSession session;

    @Autowired
    private Notificator notificator;

    private void  init() {
        System.out.println("инициализация списка пользователей");

        customers.put("user1", new User(1, "Ivan", "Ivanov",
                "ivan@supermail.ru", "*", "user1"));
        customers.put("user2", new User(2, "Masha", "Ivanova",
                "maria@supermail.ru", "*", "user2"));
    }

    public UserList() {
        init();
        this.session = userLogin("user1", "*");
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

    public void putBasket(PriceListItem goods, int qty) {
        BasketItem i = new BasketItem(goods, qty);
        notificator.notify("положили в корзину товар = " + goods.toString() + " в количестве = " + qty);
        session.putBasket(i);
    }

    @Controllable
    public void makeOrder() {
        int k = session.getBasketSize();
        double s = session.getBasketSum();
        notificator.notify("оформление заказа, в корзине " + k + " позиций; на сумму = " + s);
    }
}
