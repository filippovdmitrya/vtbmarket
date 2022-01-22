package ru.vtbmarket.services;

import org.springframework.stereotype.Service;
import ru.vtbmarket.entities.GoodsEntity;
import ru.vtbmarket.repository.GoodsRepository;
import ru.vtbmarket.services.interfaces.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

    private GoodsRepository goodsRepository;

    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public void print() {
        System.out.println(
                goodsRepository.findAll());
    }

    @Override
    public void printDescription(int id) {
        final GoodsEntity goodsEntity = goodsRepository.findById(id).get();
        final String goodsEntityDescription = goodsEntity.getDescription();
        System.out.println(goodsEntityDescription);
    }

    @Override
    public GoodsEntity get(Integer id) {
        return goodsRepository.getById(id);
    }
}
