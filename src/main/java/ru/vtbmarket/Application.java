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

        ctx.getBean(PriceList.class).show();

        log.info("смотрим описание");
        System.out.println(ctx.getBean(PriceList.class).showDescription(2));

        log.info("положим товар в корзину");
        ctx.getBean(UserList.class).putBasket(ctx.getBean(PriceList.class).get(2),1);

        log.info("ru.vtbmarket finish");
    }
}
