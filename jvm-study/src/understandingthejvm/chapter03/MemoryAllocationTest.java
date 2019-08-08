package understandingthejvm.chapter03;

import org.junit.jupiter.api.Test;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/8 13:44
 * 版本：1.0
 * 内容描述：验证内存分配策略
 */
public class MemoryAllocationTest {

    /**
     * 虚拟机参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    @Test
    public void testAllocationToEden() {
        int _1MB = 1 << 20;
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB]; //
        allocation2 = new byte[2 * _1MB]; //
        allocation3 = new byte[2 * _1MB]; //
        allocation4 = new byte[6 * _1MB]; //出现一次 Minor GC
    }

    /**
     * 大对象直接进入老年代
     *
     * -XX:PretenureSizeThreshold=3145728 设置超过固定大小的对象直接分配到老年代
     * 虚拟机参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 （3MB）
     */
    @Test
    public void testPretenureSizeThreshold() {
        int _1MB = 1 << 20;
        byte[] allocation1;
        allocation1 = new byte[8 * _1MB]; // 超过设置的3MB，直接进入老年代
    }

    /**
     * 长期存活的对象进入老年代
     * -XX:MaxTenuringThreshold=1 经过一次Monitor GC就进入老年代
     * 虚拟机参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     */
    @Test
    public void testTenuringThreshold() {
        int _1MB = 1 << 20;
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        // 进入老年代的时机取决于MaxTenuringThreshold的值
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }


}
