package test;

import io.utils.Logs;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crazystone on 17-8-10.
 */
public class Maths {

    public static void main(String... args) {
//        float a = 0.323F;
//        float b = 0.00212F;
//        Logs.l(a / b);

//        Logs.l(">>>>");
//        Logs.l(calDigit(345));
//
//        Logs.l(appendZero(23,calDigit(345)));

//        Logs.l(0 % 5);
//        Logs.l(1 % 5);
//        Logs.l(2 % 5);

        calXY(2, 5);

        int a = 5;
        retry:
        if (a > 4) {
            Logs.l("success");
        } else if (a < 4) {
            break retry;
        } else {
            Logs.l("other");
        }

    }

    private static void calXY(int x, int y) {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < x * y; i++) {
            Point point = new Point();
            list.add(point.setX(i % x).setY(i / x));
        }
        traverseList(list);
    }

    private static void traverseList(List<Point> list) {
        if (list != null && list.size() > 0) {
            for (Point point : list) {
                Logs.l(point);
            }
        }
    }

    private static int calDigit(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    private static String appendZero(int number, int digit) {
        int current = calDigit(number);
        StringBuilder sb = new StringBuilder();
        for (int i = current; i < digit; i++) {
            sb.append(0);
        }
        return sb.append(number).toString();
    }

    public static int factorial(int a, int number) {

        return 0;
    }

    private static class Point {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public Point setX(int x) {
            this.x = x;
            return this;
        }

        public int getY() {
            return y;
        }

        public Point setY(int y) {
            this.y = y;
            return this;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
