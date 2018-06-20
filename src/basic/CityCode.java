package basic;

import io.utils.Logs;

/**
 * Created by crazystone on 18-4-11.
 */
public enum CityCode implements ICode {

    FIRST,
    SECOND,
    THIRD;

    public static void main(String... args) {
        Logs.l(FIRST.getCode());
        Logs.l(SECOND.getCode());
        Logs.l(THIRD.ordinal());
    }

    @Override
    public int getCode() {
        return ordinal() + 1;
    }

}
