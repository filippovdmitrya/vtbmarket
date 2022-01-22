package ru.vtbmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.vtbmarket.entities.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {

    @Query("select g.name from StoreEntity s join GoodsEntity g ON g.id = s.goods_id where s.id = :id")
    String getStoreGoodsName(int id);
}
