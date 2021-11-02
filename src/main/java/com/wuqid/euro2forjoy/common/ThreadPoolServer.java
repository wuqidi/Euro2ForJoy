package com.wuqid.euro2forjoy.common;

import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.wuqid.euro2forjoy.config.SystemConfig.CONTROLLER_NUMS;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>线程池</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/2 23:54
 */
@Log4j
public class ThreadPoolServer {
    @Data
    private static class ControllerExe {
        private static final ThreadPoolExecutor controllerExecutor = new ThreadPoolExecutor(CONTROLLER_NUMS, CONTROLLER_NUMS + 1,
                200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(CONTROLLER_NUMS + 4));
    }

    public static ThreadPoolExecutor getControllerExe() {
        return ControllerExe.controllerExecutor;
    }
}