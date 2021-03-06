package ru.vtbmarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.vtbmarket.entities.GoodsEntity;
import ru.vtbmarket.entities.StoreEntity;
import ru.vtbmarket.repository.StoreRepository;
import ru.vtbmarket.services.interfaces.GoodsService;
import ru.vtbmarket.services.interfaces.StoreService;
import ru.vtbmarket.services.model.PricelistItem;

@Service
public class StoreServiceImpl implements StoreService {
    private StoreRepository storeRepository;

    @Autowired
    private GoodsService goodsService;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public void print() {
        System.out.println(
                storeRepository.findAll());
    }

    @Override
    public void printPricelist() {
        System.out.println("Прайс-лист из БД");
        System.out.println("id \t наименование \t цена (руб.) \t остаток");
        storeRepository.findAll()
                .forEach(p -> System.out.printf("%d \t %s \t %.2f \t %d \n",
                        p.getId(), storeRepository.getStoreGoodsName(p.getId()), p.getPrice() * 0.01, p.getBalance()));
    }

    @Override
    public PricelistItem get(int id) {
        final StoreEntity storeEntity = storeRepository.findById(id).get();
        final GoodsEntity goodsEntity = goodsService.get(storeEntity.getGoods_id());
        return new PricelistItem(goodsEntity.getName(), goodsEntity.getDescription(),
                storeEntity.getPrice(), storeEntity.getBalance(), storeEntity.getGoods_id(), id);
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 30,
            readOnly = false,
            rollbackFor = {RuntimeException.class}
    )
    public void update(int id, int goods_id, int price, int balance, int qty) {
        final StoreEntity storeEntity = storeRepository.findById(id).get();
        if (balance == storeEntity.getBalance()) {
            storeRepository.save(
                    new StoreEntity(id, goods_id, price, balance - qty, storeEntity.getVersion())
            );
        }
        else  {
           throw new IllegalStateException();
        }
    }
}
