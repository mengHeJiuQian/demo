package thread.threadpool.task1;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/10 12:56
 * 版本：1.0
 * 内容描述：定义执行的任务、执行结果
 */
public class MyTask {

    private int totalCount;

    public int runTaskAndGetResult(int n) throws InterruptedException {
        Thread.sleep(20);
        return n;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public synchronized void setTotalCount(int totalCount) {
        this.totalCount += totalCount;
    }
}
