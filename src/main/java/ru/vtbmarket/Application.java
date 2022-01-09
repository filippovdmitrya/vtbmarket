package ru.vtbmarket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.vtbmarket.services.PriceList;
import ru.vtbmarket.services.UserList;

@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        log.info("ru.vtbmarket start");
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);

        final PriceList priceList = ctx.getBean(PriceList.class);
        final UserList userList = ctx.getBean(UserList.class);

        priceList.show();

        log.info("смотрим описание");
        System.out.println(priceList.showDescription(2));

        log.info("положим товар в корзину");
        userList.putBasket(priceList.get(2),1);

        log.info("оформление заказа на товар в корзине");
        userList.makeOrder();

        log.info("ru.vtbmarket finish");
    }
}
