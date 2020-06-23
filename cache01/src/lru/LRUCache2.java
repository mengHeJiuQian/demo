package lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 创建人：yang.liu
 * 创建时间：2020/3/30 13:59
 * 版本：1.0
 * 内容描述：LRU策略实现的本地缓存，HashMap实现方式。
 */
public class LRUCache2<K, V> {

    // LRU内部的实体类
    class Entry<K, V> {
        K key;
        V value;
        Entry pre;
        Entry next;
    }

    private static final float loadFactories = 0.75F;
    private int cacheSize;
    private Entry head;
    private Entry last;
    private HashMap<K, Entry<K, V>> map;


    public LRUCache2(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        moveToHead(entry);
        return entry.value;
    }

    public void put(K key, V value) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            if (map.size() >= cacheSize) { // 缓存空间已满，删除old entry.
                map.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.value = value;
        moveToHead(entry);
        map.put(key, entry); // 如果value变了，则需要替换旧value
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedSize() {
        return map.size();
    }

    public void moveToHead(Entry entry) {
        if (entry == head) {
            return;
        }
        if (entry == last) {
            last = last.pre;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (head == null || last == null) {
            head = last = entry;
            return;
        }
        entry.next = head;
        head.pre = entry;
        head = entry;
        entry.pre = null;
    }

    // 删除最老的元素
    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) {
                head = null;
            } else {
                last.next = null;
            }
        }
    }

    public Entry<K, V> getEntry(K key) {
        Entry<K, V> entry = map.get(key);
        return entry;
    }

    public void print() {
        Entry first =  head;
        while (first != null){
            System.out.println(first.key + "---" + first.value);
            first = first.next;
        }
    }



    public static void main(String[] args) {
        LRUCache2 lru = new LRUCache2(4);
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
