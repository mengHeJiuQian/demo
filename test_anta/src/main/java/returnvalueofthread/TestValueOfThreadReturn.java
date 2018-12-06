package returnvalueofthread;

import com.google.common.base.Strings;

class MyThread extends Thread {
    private String returnVal;

    public String getReturnVal() {
        return returnVal;
    }

    @Override
    public void run() {
        returnVal = "计算后，要返回的值";
    }
}

public class TestValueOfThreadReturn {


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myThread.getReturnVal());
    }

    // 使用join()方法，相当于把程序的异步变为同步
    /*public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myThread.getReturnVal());
    }*/

    /*
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        while (Strings.isNullOrEmpty(myThread.getReturnVal())) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(myThread.getReturnVal());
    }
    */
}
