package test;

/**
 * Created by crazystone on 17-10-12.
 */
public class BitTest {

//  3的低16位  0000 0000 0000 0011
//  a<<8  为  0000 0011 0000 0000
//  a>>8 为   0000 0000 0000 0000
//  a>>8|a<<8 为 0000 0011 0000 0000
// 转为十进制为 768


    public static void main(String... args) {
        int a = 0x5555;
        System.out.println((short) (a << 8 | a >> 8));

        int b = 0;
        int c = 3;
        Logs.l(~b);
        Logs.l(~c);

    }


}
