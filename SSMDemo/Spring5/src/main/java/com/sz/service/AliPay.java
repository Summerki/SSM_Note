package com.sz.service;

public class AliPay implements Pay {
    @Override
    public void pay() {
        System.out.println("Ali支付");
    }
}
