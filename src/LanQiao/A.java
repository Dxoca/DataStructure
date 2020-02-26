package LanQiao;

/**
 * 一个数被称为质数（或素数）是指除开1和它本身两个约数外，没有其他的约数。
 * 　　不超过10000的数中，最大的质数是多少?
 */
public class A {
    public static void main(String[] args) {
        for (int i = 10000; i >0 ; i--) {
            if(inPrime(i)){
                System.out.println(i);
                break;
            }

        }
    }
    public static boolean inPrime(long num) {
        for (int i = 2; i * i <= num; i++)//i^2 <=> sqrt
            if (num % i == 0) return false;
        return true;
    }
}
