package ru.vtbmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtbmarket.entities.MarketUsersEntity;

public interface MarketUsersRepository  extends JpaRepository<MarketUsersEntity, Integer> {
}
