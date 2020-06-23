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
public class LRU_K<K, V> {

    private static final float loadFactories = 0.75F;
    private ArrayList<History> histories;
    private LinkedHashMap<K, V> map;
    private int historyLength, cacheSize;
    private int K_SIZE = 2; // 进入缓存的最小访问次数

    class History {
        // 资源hash值
        private int hash;
        // 使用次数
        private int times;

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }
    }

    public LRU_K(int historyLength, int cacheSize) {
        this.historyLength = historyLength;
        this.cacheSize = cacheSize;
        histories = new ArrayList<>(historyLength);
        map = new LinkedHashMap(cacheSize, loadFactories, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
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

    public synchronized boolean moveToCache(K key) {
        int hashcode = key.hashCode();
        if (inHistory(hashcode)) {
            return modifyHistory(hashcode);
        } else {
            History history = new History();
            history.setHash(hashcode);
            history.setTimes(1);
            histories.add(history);
            return false;
        }
    }

    private boolean modifyHistory(int objectHash) {
        for (History item : histories) {
            if (item.getHash() != objectHash) {
                continue;
            }

            // 历史记录中找到了，更改次数
            if (item.getTimes() + 1 < K_SIZE) {
                item.setTimes(item.getTimes() + 1);
                histories.remove(item);
                histories.add(item);
                return false;
            }
            histories.remove(item);
            return false;
        }
        return false;
    }

    private boolean inHistory(int objectHash) {
        for (History item : histories) {
            if (item.getHash() == objectHash) {
                return true;
            }
        }
        return false;
    }

}
