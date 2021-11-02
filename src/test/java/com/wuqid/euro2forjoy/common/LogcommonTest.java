package com.wuqid.euro2forjoy.common;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/30 18:57
 */
@Log4j
class LogcommonTest {

    @Test
    void info() {
        Logger log = Logger.getLogger(LogcommonTest.class.getName());
        log.fine("Loading: ");
    }

    public static void main(String[] args) {
       Logcommon.info(log,"test", Logcommon.TAG.OUTPUT,null);
    }
}