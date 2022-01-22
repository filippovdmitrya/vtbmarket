package ru.vtbmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtbmarket.entities.GoodsEntity;

import java.util.List;

public interface GoodsRepository extends JpaRepository<GoodsEntity, Integer> {
    List<GoodsEntity> findAllByNameContains(String textContains);
}
