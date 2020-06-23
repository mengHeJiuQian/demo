package lru;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 创建人：yang.liu
 * 创建时间：2020/3/30 15:44
 * 版本：1.0
 * 内容描述：LRU-K算法，最近最少使用K次才被缓存。
 * 防止缓存污染，缓存效率低的问题
 *
 * LRU-K需要多维护一个队列，用于记录所有缓存被访问的历史。只有数据访问次数达到K次才能放入缓存。
 * 当淘汰数据时，淘汰第K次访问距离当前时间最长的数据。
 */
public class LRU_K2<K, V> {

    private static final float loadFactories = 0.75F;
    private LinkedHashMap<K, HistoryCounter> histories;
    private LinkedHashMap<K, V> map;
    private int historyLength, cacheSize;
    private int K_SIZE = 2; // 进入缓存的最小访问次数

    class HistoryCounter {
        // 资源hash值
        private K key;
        // 使用次数
        private int visited;

        public HistoryCounter(K key, int visited) {
            this.key = key;
            this.visited = visited;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public int getVisited() {
            return visited;
        }

        public void setVisited(int visited) {
            this.visited = visited;
        }
    }

    public LRU_K2(int historyLength, int cacheSize) {
        this.historyLength = historyLength;
        this.cacheSize = cacheSize;
        histories = new LinkedHashMap(historyLength, loadFactories, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > historyLength;
            }
        };

        map = new LinkedHashMap(cacheSize, loadFactories, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }

    public synchronized void put(K key, V value) {
        V existsValue = map.get(key);
        if (existsValue != null) {
            return;
        }
        addToHistory(key, value);
    }

    private void addToHistory(K key, V value) {
        HistoryCounter hc;
        hc = histories.get(key);
        if (null != hc) {
            // 如果已经存在于历史队列中，则自增访问次数
            hc.visited++;
            if (hc.visited >= K_SIZE) {
                histories.remove(key);
                map.put(key, value);
            }
        } else {
            hc = new HistoryCounter(key, 1);
            histories.put(key, hc);
        }
    }

    public synchronized V get(K key) {
        V value = map.get(key);
        if (value != null) {
            return value;
        }
        return null;
    }

    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        LRU_K2 lru = new LRU_K2(4, 2);
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
