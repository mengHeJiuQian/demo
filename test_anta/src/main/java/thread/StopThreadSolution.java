package thread;

/**
 * 面试题。操作三个线程A,B,C。让它们的执行任务顺序A-B-C, 结束顺序是C-B-A。
 */
public class StopThreadSolution {

    public static void main(String[] args) throws InterruptedException {
        Thread t3 = new Thread(new Task());
        t3.setName("t3");

        Thread t2 = new Thread(new Task(t3, "t2"));
        t2.setName("t2");

        Thread t1 = new Thread(new Task(t2, "t1"));
        t1.setName("t1") ;

        t1.start();
        t2.start();
        t3.start();
    }

    static class Task implements Runnable {

        Thread t;    // 等待线程X执行完成
        String name; //任务名称

        public Task() {
        }

        public Task(Thread t, String name) {
            this.t = t;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("先执行自己的任务" + name);
            if (t == null) {
            } else {
                try {
                    // join的县城只有active状态下才有效。
                    t.join();
                    System.out.println(t.getName() + "完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("执行完成" + name);
        }
    }

}
