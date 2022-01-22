package ru.vtbmarket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.vtbmarket.services.PriceList;
import ru.vtbmarket.services.StoreServiceImpl;
import ru.vtbmarket.services.UserList;
import ru.vtbmarket.services.interfaces.GoodsService;
import ru.vtbmarket.services.interfaces.StoreService;

@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        log.info("ru.vtbmarket start");
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);

        final PriceList priceList = ctx.getBean(PriceList.class);
//        final UserList userList = ctx.getBean(UserList.class);
        priceList.show();

        //        log.info("смотрим описание");
//        System.out.println(priceList.showDescription(2));

//        log.info("положим товар в корзину");
//        userList.putBasket(priceList.get(2),1);
//
//        log.info("оформление заказа на товар в корзине");
//        userList.makeOrder();

        final StoreService storeService = ctx.getBean(StoreService.class);
        final GoodsService goodsService = ctx.getBean(GoodsService.class);

        log.info("смотрим price list из БД");
        storeService.print(); // debug output
        storeService.printPricelist();

        log.info("смотрим описание из БД");
//        goodsService.print(); // all table for debug
        goodsService.printDescription(2);

        log.info("ru.vtbmarket finish");
    }
}
