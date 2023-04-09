package com.test.just.java.finalizeattack;

public class HackedAttack extends Account {

    public HackedAttack(String name) {
        super(name);
    }

//    @Override
    protected void finalize1() throws Throwable {  //finalize 재정의를 못하게 막아 놓아서 실행되지 않는다.
        this.transfer(1000, "김정은");
        super.finalize();
    }
}
