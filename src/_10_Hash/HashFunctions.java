package _10_Hash;

public class HashFunctions {
    //hash决定index的分散程度 避免冲突 (尤其是针对拉链发 分散程度越大 算法拉链法效率越高)
    //prime 是基数 也是桶的个数

    /**
     * 取余法计算Hash
     *
     * @param key
     * @param prime
     * @return
     */
    static int hash1(Object key, int prime) {
        return key.hashCode() % prime;
    }

    /**
     * 加法计算Hash
     *
     * @param key
     * @param prime
     * @return
     */
    static int additiveHash(Object key, int prime) {
        String objStr = key.toString();
        int hash = objStr.length();
        for (int i = 0; i < objStr.length(); i++) {
            hash += objStr.charAt(i);
        }
        return hash % prime;
    }

    /**
     * 旋转Hash 利用位运算 尽量让hash分散
     *
     * @param key
     * @param prime
     * @return
     */
    static int rotatingHash(String key, int prime) {
        int hash = key.length();
        for (int i = 0; i < key.length(); i++) {
            hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);
        }
        return hash % prime;
    }

    /**
     * 乘法
     *
     * @param key
     * @param prime
     * @return
     */
    static long bernstein(String key, int prime) {
        long hash = 0;
        long seed = 31;
        for (int i = 0; i < key.length(); i++) {
            hash = seed * hash + key.charAt(i);
        }
        return hash % prime;
    }
}
