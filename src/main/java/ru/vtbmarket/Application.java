package ru.vtbmarket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.vtbmarket.services.PriceList;
import ru.vtbmarket.services.StoreServiceImpl;
import ru.vtbmarket.services.UserList;
import ru.vtbmarket.services.interfaces.*;

@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        log.info("ru.vtbmarket start");
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);

        final UserList userList = ctx.getBean(UserList.class);
        userList.build("user1");

        // старая версия vtbmarket
//        final PriceList priceList = ctx.getBean(PriceList.class);
//        priceList.show();
        //        log.info("смотрим описание");
//        System.out.println(priceList.showDescription(2));

//------------------------------------------------------------------------------

        final StoreService storeService = ctx.getBean(StoreService.class);
        final GoodsService goodsService = ctx.getBean(GoodsService.class);

//        final MarketUsersService marketUsersService  = ctx.getBean(MarketUsersService.class);
//        log.info("смотрим table market_users из БД");
//        marketUsersService.print();// debug output

        log.info("смотрим price list из БД");
//        storeService.print(); // debug output
        storeService.printPricelist();

        log.info("смотрим описание из БД");
//        goodsService.print(); // all table for debug
        goodsService.printDescription(2);

//        log.info("положим товар в корзину");
//        userList.putBasket(priceList.get(2),1);
//
//        log.info("оформление заказа на товар в корзине");
//        userList.makeOrder();
        //------------------------------------------------------------------------------
        final BasketService basketService = ctx.getBean(BasketService.class);
        log.info("смотрим table basket из БД");
        basketService.print();// debug output

        final BasketListService basketListService = ctx.getBean(BasketListService.class);
        log.info("смотрим table basket_list из БД");
        basketListService.print();// debug output
        //------------------------------------------------------------------------------

        log.info("ru.vtbmarket finish");
    }
}
