package com.test.just.java.finalizeattack;

import org.junit.Test;

public class TestFinalizeAttack {
    @Test
    public void 일반사람() {
        Account account = new Account("혁수");
        account.transfer(1000, "성영");
    }

    @Test
    public void 푸틴() throws InterruptedException {
        Account account;
        try {
            account = new HackedAttack("푸틴"); //이공격을 막기위해 finalize 함수를 final 로 상속을 막는다.
        } catch (Exception e) {
            System.out.println("푸틴에게 보낼 수 있어");
        }
        System.gc();
        Thread.sleep(3000L);
    }
 }
