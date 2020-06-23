package gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * 创建人：yang.liu
 * 创建时间：2020/5/22 9:37
 * 版本：1.0
 * 内容描述：通过ManagementFactory类查看垃圾收集器的运行情况
 */
public class ShowGC {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gc: garbageCollectorMXBeans) {
            System.out.println(gc.getName() + ":" + gc.getCollectionCount() + ":" + gc.getCollectionTime());
        }
    }
}
