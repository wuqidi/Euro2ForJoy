package com.wuqid.euro2forjoy.common;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/3 1:09
 */
class ThreadPoolServerTest {

    @Test
    void getControllerExe() throws Exception{
        ThreadPoolExecutor controllerExe = ThreadPoolServer.getControllerExe();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        controllerExe.execute(()->{
            System.out.println("你好1"+System.currentTimeMillis());
            countDownLatch.countDown();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        controllerExe.execute(()->{
            System.out.println("你好2"+System.currentTimeMillis());
            countDownLatch.countDown();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        countDownLatch.await();
        System.out.println("世界");
    }
}