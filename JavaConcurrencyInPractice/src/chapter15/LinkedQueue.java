package chapter15;

import util.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 10:17
 * 版本：1.0
 * 内容描述：Michael-Scott非阻塞算法中的插入算法
 */
@ThreadSafe
public class LinkedQueue<E> {

    private final Node<E> dummy = new Node<>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    public boolean put(E item) {
        Node<E> newNode = new Node<>(item, null);
        while (true) {
            Node<E> curTail = tail.get();
            Node<E> tailNext = curTail.next.get();
            if (curTail == tail.get()) { // A.
                if (tailNext != null) {
                    // 队列处于中间状态，推进尾节点
                    tail.compareAndSet(curTail, tailNext);
                } else {
                    // 处于稳定状态，尝试插入新节点
                    if (curTail.next.compareAndSet(null, newNode)) {
                        //插入新节点操作成功，尝试推进尾节点
                        tail.compareAndSet(curTail, newNode);
                        return true;
                    }
                }
            }
        }
    }

    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }

}
