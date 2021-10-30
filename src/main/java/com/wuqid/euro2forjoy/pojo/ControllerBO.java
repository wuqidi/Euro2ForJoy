package com.wuqid.euro2forjoy.pojo;

import lombok.Data;
import lombok.extern.log4j.Log4j;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *           -1
 *      -1        1
 *           1
 *
 * @author: 泥猴桃
 * @date 2021/10/30 22:35
 */
@Log4j
@Data
public class ControllerBO {
    private Analog analog = new Analog();

    private ComponenBO button_1;
    private ComponenBO button_2;
    private ComponenBO button_3;
    private ComponenBO button_4;
    private ComponenBO button_5;
    private ComponenBO button_6;
    private ComponenBO button_7;
    private ComponenBO button_8;
    private ComponenBO button_9;
    private ComponenBO button_10;
    private ComponenBO button_11;
    private ComponenBO button_12;

    @Data
    public static class Analog {
        public enum Direction {
            /*             0 -1
             *       -1 -1       1 -1
             *      -1 0            1 0
             *        -1 1       1 1
             *             0 1
             */
            UP_LEFT(-1.0f, -1.0f), UP(0.0f, -1.0f), UP_RIGHT(1.0f, -1.0f),
            DOWN_LEFT(-1.0f, 1.0f), DOWN(0.0f, 1.0f), DOWN_RIGHT(1.0f, 1.0f),
            LEFT(-1.0f, 0.0f), RIGHT(1.0f, 0.0f), CENTER(0.0f, 0.0f);
            private final float x;
            private final float y;

            public float getX() {
                return x;
            }

            public float getY() {
                return y;
            }

            Direction(float x, float y) {
                this.x = x;
                this.y = y;
            }

            public static Direction getDirection(ComponenBO x, ComponenBO y) {
                for (Direction direction : Direction.values()) {
                    if (direction.getX() == x.getPollData() && direction.getY() == y.getPollData()) {
                        return direction;
                    }
                }
                return CENTER;
            }
        }

        private Direction direction;
    }
}
