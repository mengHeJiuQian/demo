package chapter11;

import util.ThreadSafe;

import java.util.Set;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/29 18:03
 * 版本：1.0
 * 内容描述：基于散列的Map中使用锁分段技术
 */
@ThreadSafe
public class StripedMap {

    private static final int N_LOCKS = 16;
    private final Node[] buckets;
    private final Object[] locks;

    private static class Node{
        Object key;
        Object value;
        Object data;
        Node next;
    }

    public StripedMap(int numBuckets) {
        buckets = new Node[numBuckets];
        locks = new Object[N_LOCKS];
        for (int i = 0; i < N_LOCKS; i++) {
            locks[i] = new Object();
        }
    }

    /**
     * 计算元素在哪个桶中
     */
    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    /**
     * 从buckets中取元素
     */
    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash % N_LOCKS]) {
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) {
                    return m.value;
                }
            }
        }
        return null;
    }

    /**
     * 清空buckets中的元素。一个桶一个桶的清空。清空每个桶之前需要获取操作每个桶的锁。
     */
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i % N_LOCKS]) {
                buckets[i] = null;
            }
        }
    }

}
