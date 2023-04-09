package com.test.just.java.finalizeattack;

public class Account {
    private String name;

    public Account(String name) {
        if(name.equals("푸틴")) {
            throw new IllegalArgumentException("푸틴 계좌는 막는다.");
        }
        this.name = name;
    }

    public int transfer(int amount, String to) {
        System.out.println(to + "에게 " + amount + "보낸다.");
        return amount;
    }


    @Override
    protected final void finalize() throws Throwable {
        super.finalize();
    }
}
