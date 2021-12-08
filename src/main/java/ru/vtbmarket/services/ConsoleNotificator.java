package ru.vtbmarket.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.vtbmarket.services.interfaces.Notificator;

@Component
@Lazy
public class ConsoleNotificator implements Notificator {
    @Override
    public void notify(Object o) {
        System.out.println("-> " + o);
    }
}
