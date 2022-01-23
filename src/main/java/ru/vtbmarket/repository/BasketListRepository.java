package ru.vtbmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtbmarket.entities.BasketListEntity;

public interface BasketListRepository extends JpaRepository<BasketListEntity, Integer> {
}
