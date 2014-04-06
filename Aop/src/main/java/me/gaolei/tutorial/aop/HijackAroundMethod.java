package me.gaolei.tutorial.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

public class HijackAroundMethod implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {


        String methodName = methodInvocation.getMethod().getName();
        String arguments = Arrays.toString(methodInvocation.getArguments());
        // same with MethodBeforeAdvice
        System.out.println("HijackAroundMethod : Before method hijacked " + methodName + "(" + arguments + ")");

        try {
            // proceed to original method call
            Object result = methodInvocation.proceed();

            // same with AfterReturningAdvice
            System.out.println("HijackAroundMethod : Before after hijacked " + methodName + "(" + arguments + ")");

            return result;

        } catch (IllegalArgumentException e) {
            // same with ThrowsAdvice
            System.out.println("HijackAroundMethod : Throw exception hijacked " + methodName + "(" + arguments + ")");
            throw e;
        }
    }
}