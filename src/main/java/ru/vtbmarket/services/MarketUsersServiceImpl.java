package ru.vtbmarket.services;

import org.springframework.stereotype.Service;
import ru.vtbmarket.entities.MarketUsersEntity;
import ru.vtbmarket.repository.MarketUsersRepository;
import ru.vtbmarket.services.interfaces.MarketUsersService;

import java.util.Collection;

@Service
public class MarketUsersServiceImpl implements MarketUsersService {

    private MarketUsersRepository marketUsersRepository;

    public MarketUsersServiceImpl(MarketUsersRepository marketUsersRepository) {
        this.marketUsersRepository = marketUsersRepository;
    }

    @Override
    public void print() {
        System.out.println(
                marketUsersRepository.findAll());
    }

    @Override
    public Collection<MarketUsersEntity> getAll() {
        return marketUsersRepository.findAll();
    }
}
