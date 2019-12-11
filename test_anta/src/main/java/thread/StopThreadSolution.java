package thread;

/**
 * 面试题。操作三个线程A,B,C。让它们的启动顺序A-B-C, 结束顺序是C-B-A。
 */
public class StopThreadSolution {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task());
        t1.setName("t1");
        Thread t2 = new Thread(new Task(t1));
        t2.setName("t2");
        Thread t3 = new Thread(new Task(t2));
        t3.setName("t3") ;

        t1.start();
        Thread.sleep(500);
        t2.start();
        Thread.sleep(500);
        t3.start();
        Thread.sleep(500);
    }

    static class Task implements Runnable {

        Thread t;

        public Task() {
        }

        public Task(Thread t) {
            this.t = t;
        }

        @Override
        public void run() {
            if (t == null) {
                System.out.println("先执行自己的任务");
            } else {
                System.out.println(t.getName());
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
