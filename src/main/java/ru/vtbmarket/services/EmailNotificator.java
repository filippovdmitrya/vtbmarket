package ru.vtbmarket.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.vtbmarket.services.interfaces.Notificator;

@Component
@Lazy
@Profile("!console")
public class EmailNotificator implements Notificator {
    @Override
    public void notify(Object o) {
        System.out.println("Send by email " + o);
    }
}
