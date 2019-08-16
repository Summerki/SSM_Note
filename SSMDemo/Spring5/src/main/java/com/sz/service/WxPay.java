package com.sz.service;

public class WxPay implements Pay {
    @Override
    public void pay() {
        System.out.println("WX支付");
    }
}
