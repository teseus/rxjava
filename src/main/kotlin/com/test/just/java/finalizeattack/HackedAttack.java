package com.test.just.java.finalizeattack;

public class HackedAttack extends Account {

    public HackedAttack(String name) {
        super(name);
    }

    @Override
    protected void finalize() throws Throwable {
        this.transfer(1000, "김정은");
        super.finalize();
    }
}
