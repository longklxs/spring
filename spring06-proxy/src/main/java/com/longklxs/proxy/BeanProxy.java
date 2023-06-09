package com.longklxs.proxy;

import com.longklxs.bean.Account;
import com.longklxs.service.AccountService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanProxy {

    AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService createAccountService(){
       return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {


            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("增强了");
                if(method.getName().equals("findAccount")){
                    Account invoke = (Account)method.invoke(accountService, args);
                    return invoke;
                }else {
                    method.invoke(accountService,args);
                    return null;
                }


            }
        });
    }

}
