package bit;

import io.utils.Logs;

/**
 * Created by crazystone on 18-2-18.
 */
public interface Direction {

    int LEFT = 0X1;
    int RIGHT = 0X2;
    int TOP = 0X4;
    int BOTTOM = 0X8;

    default void main() {
        int direction = LEFT | RIGHT | TOP;
        checkDirection(direction);

    }

    default void checkDirection(int direction) {
        if (LEFT == (direction & LEFT)) {
            Logs.l("has left direction");
        }
        if (RIGHT == (direction & RIGHT)) {
            Logs.l("has right direction");
        }
        if (TOP == (direction & TOP)) {
            Logs.l("has top direction");
        }
        if (BOTTOM == (direction & BOTTOM)) {
            Logs.l("has bottom direction");
        }
    }

}
