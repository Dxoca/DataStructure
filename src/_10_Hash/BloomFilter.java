package _10_Hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 简化版本布隆过滤器的实现
 */
public class BloomFilter {
    public static final int NUM_SLOTS = 1024 * 1024 * 8;//位图的长度
    public static final int NUM_HASH = 8;//hash函数的个数，一个Hash函数的结果用于标记一个位
    private BigInteger bitmap = new BigInteger("0");//可能超出Int 所以用big

    public static void main(String[] args) {

        BloomFilter bf = new BloomFilter();
        ArrayList<String> contents = new ArrayList<>();
        contents.add("dxoca.cn");
        contents.add("as34h3f");
        contents.add("ah34a,yj,");
        contents.add("a.7fh.f");
        contents.add("3srtsdbnv.s");

        for (int i = 0; i < contents.size(); i++) {
            bf.addElement(contents.get(i));
        }
        System.out.println(bf.check("dxoca.cn"));
        System.out.println(bf.check("2019年11月10日 17:55:01"));

    }

    /**
     * 将message+n映射到0~NUM_SLOTS-1之间的一个数值
     *
     * @param message
     * @param n
     * @return
     */
    private int hash(String message, int n) {

        message = message + n;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");//将任意输入映射成128位(16个字节 [2^128 -1]很大的数字)整数的hash函数
            byte[] bytes = message.getBytes();
            md5.update(bytes);
            BigInteger bi = new BigInteger(md5.digest());//至此 过的message+n的md5结果 (128位整数)
            return Math.abs(bi.intValue()) % NUM_SLOTS;//小于NUM_SLOTS长度
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BloomFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     * 处理原始数据 生成图
     * 1.hash1（msg）标注一个位....   hash的值域0~NUM_SLOTS-1
     *
     * @param message
     */
    public void addElement(String message) {
        for (int i = 0; i < NUM_HASH; i++) {
            int hashCode = hash(message, i);//代表若干hash 1..2.3 代表一个位
            //用于标注位图该位为1
            if (!bitmap.testBit(hashCode)) {//r判断hashCode位是否为1 如果不为1 这则把该位标记为 1
                bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashCode));//先生成hashCode位为1的二进制数 再和 bitmap或运算  hashCode 位变成1
            }
        }
    }

    /**
     * 查找
     * @param message 新的串~
     * @return
     */
    public boolean check(String message) {
        for (int i = 0; i < NUM_HASH; i++) {
            //hashCode代表一个位置 便利每个位置
            int hashCode = hash(message, i);
            //如果位图的hashCode位为0 那么message一定不存在
            if (!this.bitmap.testBit(hashCode)) {//判断 hashCode位是否为1
                return false;
            }
        }
        return true;//对应位不精确 有可能误判
    }
}
