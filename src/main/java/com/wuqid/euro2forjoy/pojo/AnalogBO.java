package com.wuqid.euro2forjoy.pojo;

import lombok.Data;

import java.util.Objects;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>摇杆</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/31 13:04
 */
@Data
public class AnalogBO {
    private String gUID;
    private Direction direction;

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

    public boolean equals(AnalogBO analogBO) {
        if (this == analogBO) {
            return true;
        }
        return getDirection().equals(analogBO.getDirection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDirection());
    }
}