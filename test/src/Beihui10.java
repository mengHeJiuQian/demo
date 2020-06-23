/**
 * 创建人：yang.liu
 * 创建时间：2020/5/15 9:57
 * 版本：1.0
 * 内容描述：北汇信息 笔试10
 */
public class Beihui10 {

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s:%s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable {
        @Override
        public void run() {
            String[] importantInfo = {"Helllo Jack", "Hello Mike"};
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    Thread.sleep(2000);
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I was not done!");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        long patience = 1000;
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        while (t.isAlive()) {
            threadMessage("Still waiting...");
            t.join(1000);
            if ((System.currentTimeMillis() - startTime) > patience && t.isAlive()) {
                threadMessage("Tired of waiting");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("Finally!");
    }

}
