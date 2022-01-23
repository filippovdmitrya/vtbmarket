package ru.vtbmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtbmarket.entities.BasketEntity;

public interface BasketRepository extends JpaRepository<BasketEntity, Integer> {
}
