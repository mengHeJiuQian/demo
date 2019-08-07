package chapter15;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/6 21:35
 * 版本：1.0
 * 内容描述：通过CAS来维持包含多个变量的不变性条件
 */
public class CasNumberRange {

    private static class IntPair {
        final int lower; // 不变性条件 lower <= upper
        final int upper;

        public IntPair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    private final AtomicReference<IntPair> values = new AtomicReference<>(new IntPair(0, 0));

    public int getLower() {
        return values.get().lower;
    }

    public int getUpper() {
        return values.get().upper;
    }

    public void setLower(int i) {
        while (true) {
            IntPair oldv = values.get();
            if (i > oldv.upper) {
                throw new IllegalArgumentException("Cant not set lower to " + i + " > upper");
            }
            IntPair newv = new IntPair(i, oldv.upper);
            if (values.compareAndSet(oldv, newv)) {
                return;
            }
        }
    }

    // 对upper也可以采用setLower的方法
    public void setUpper(int i) {

    }

}
