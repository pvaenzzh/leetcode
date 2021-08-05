package com.pvaen.concurrent.volatiletest.a0;


public class P01 {

    private static int errorCount = 0;

    public static void main(String[] args) throws InterruptedException {

        int count = 1;

        O1 o1 = new O1();

        new Thread(() -> {
            int reader = o1.reader();
            System.out.println(reader);
        }).start();

//        Thread.sleep(100);//

        new Thread(() -> {
            o1.writer();
        }).start();

        System.out.println("主线程结束, errorCount: " + errorCount);

    }

    static class O1 {
        private int a = 0;
        boolean flag = false;//

        public void writer() {
            System.out.println("开始写了");
            a = 1;
            flag = true;
            System.out.println("写完毕");
        }

        public int reader() {
            System.out.println("开始读了, a: " + a);
            System.out.println(flag);
            while (!flag) ;

            System.out.println("读完毕");
            return a;
        }
    }


}

