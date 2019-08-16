package com.suki.pojo;

public class Cat {

    private String skin;

    private int leg;

    @Override
    public String toString() {
        return "Cat{" +
                "skin='" + skin + '\'' +
                ", leg=" + leg +
                '}';
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public int getLeg() {
        return leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }
}
