package ru.vtbmarket.services;

import org.springframework.stereotype.Service;
import ru.vtbmarket.repository.StoreRepository;
import ru.vtbmarket.services.interfaces.StoreService;

@Service
public class StoreServiceImpl implements StoreService {
    private StoreRepository storeRepository;

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
}
