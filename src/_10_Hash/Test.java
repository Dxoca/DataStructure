package _10_Hash;

import java.math.BigInteger;

public class Test {

    public static void main(String[] args) {
        BigInteger bi;

        Boolean b1, b2, b3, b4;

        //testBit方法说明：
        //1.该方法的index是从后往前计算的。比如14，就是二进制的：1110.那么index为0，就是0；index为1、2、3的时候都是1
        //2.如果该位置值为1，那么返回true；如果是0，那么返回false
        //3.所以14-->1110
        //4.index=0  -->false
        //index=1  -->true
        //index=2  -->true
        //index=3  -->true
        //5.该方法可以用于权限管理的计算，暂且不表
        bi = new BigInteger("14");

        b1 = bi.testBit(0);
        b2 = bi.testBit(1);
        b3 = bi.testBit(2);
        b4 = bi.testBit(3);

        String str1 = "Test Bit on " + bi + " at index 0 returns " + b1;
        String str2 = "Test Bit on " + bi + " at index 1 returns " + b2;
        String str3 = "Test Bit on " + bi + " at index 2 returns " + b3;
        String str4 = "Test Bit on " + bi + " at index 3 returns " + b4;

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
//
//————————————————
//        版权声明：本文为CSDN博主「翘臀小王子」的原创文章，遵循 CC 4.0 BY - SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https:
////blog.csdn.net/liuyishan1993/article/details/79883044
    }
}
