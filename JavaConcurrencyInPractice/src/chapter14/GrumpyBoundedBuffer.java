package chapter14;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/31 10:38
 * 版本：1.0
 * 内容描述：当不满足条件时，有界缓存不会执行相应的操作
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public GrumpyBoundedBuffer(int size) {
        super(size);
    }

    public synchronized void put(V v) throws BufferFullException {
        if (isFull()) {
            throw new BufferFullException();
        }
        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if (isEmpty()) {
            throw new BufferEmptyException();
        }
        return doTake();
    }
}
