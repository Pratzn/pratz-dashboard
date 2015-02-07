package org.pratz.aop;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeCallAdvice implements MethodBeforeAdvice{

    public void before(Method method, Object[] args, Object target) {
        System.out.println("Before Calling the Method");
    }

}
