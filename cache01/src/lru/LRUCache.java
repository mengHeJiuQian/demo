package lru;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 创建人：yang.liu
 * 创建时间：2020/3/30 13:59
 * 版本：1.0
 * 内容描述：LRU策略实现的本地缓存，LinkedHashMap实现方式。
 */
public class LRUCache<K, V> {

    private static final float loadFactories = 0.75F;
    private int cacheSize;
    private LinkedHashMap<K, V> map;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new LinkedHashMap<K, V>(cacheSize, loadFactories, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                boolean remove = size() > cacheSize;
                if (remove) {
                    System.out.println("移除的元素为：" + eldest.getValue());
                }
                return remove;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key,value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedSize() {
        return map.size();
    }

    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(4);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(1,1);
        lru.put(5,5);
        lru.put(6,6);
        lru.put(3,3);
        lru.print();
    }

}
