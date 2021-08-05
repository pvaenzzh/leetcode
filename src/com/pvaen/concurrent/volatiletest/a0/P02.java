package com.pvaen.concurrent.volatiletest.a0;

/**
 * 验证成功
 */
public class P02 {

    private static int errorCount = 0;

    public static void main(String[] args) throws InterruptedException {
        O1 o1 = new O1();

        new Thread(() -> {
            o1.reader();
        }).start();

        Thread.sleep(100);
        new Thread(() -> {
            o1.writer();
        }).start();

    }

    static class O1 {
        private int a = 0;
        boolean flag = false;

        public void writer() {
            a = 1;
            flag = true;
            System.out.println("写成功了");
        }

        public int reader() {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", start reader...");
            while (!flag) ;
            System.out.println("Thread: " + Thread.currentThread().getName() + ", read success");
            return a;
        }
    }
}

