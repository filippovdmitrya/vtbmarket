package ru.vtbmarket.services.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FinancialMessage {

    @Pointcut("@annotation(ru.vtbmarket.annotation.Controllable)")
    public void messenger() {}

    @Before("messenger()")
    public void before(JoinPoint point) {
        messenger("Перед стартом метода " + point.getSignature().getName());
    }

    @After("messenger()")
    public void after(JoinPoint point) {
        messenger("ПОСЛЕ завершения процесса : " + point.getSignature().getName());
    }

    private void messenger(String s) {
        System.out.println("fiscal report: -> " + s);
    }
}
