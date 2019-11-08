package _10_Hash;

import java.util.Iterator;

public interface IMap<K, V> {
    /**
     * 清除所有键值对
     */
    void clear();

    /**
     * key是否已存在
     *
     * @param key
     * @return
     */
    boolean containsKey(K key);

    /**
     * value是否已存在
     *
     * @param value
     * @return
     */
    boolean containsValue(V value);

    /**
     * 根据key获得valye
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * map  是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 所有 key组成的数组
     * 和java api区分 所以用数组
     *
     * @return
     */
    MyHashSet<K> keySet();

    /**
     * 存入键值对
     *
     * @param key
     * @param value
     * @return
     */
    void put(K key, V value);

    /**
     * 把另外一个map中的所有键值对 存入到当前map中
     *
     * @param map
     */
    void putAll(IMap<? extends K, ? extends V> map);

    /**
     * 根据key删除一个键值对
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 键值对的个数
     * @return
     */
    int size();

    /**
     * 所有的value组成的数组
     * @return
     */
    V[] values();

    /**
     * 迭代器
     * @return
     */
    Iterator<MyHashMap.Node> iterator();

}
