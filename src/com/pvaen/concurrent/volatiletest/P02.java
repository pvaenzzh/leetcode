package com.pvaen.concurrent.volatiletest;

public class P02 {

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("进入操作数据线程");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //调用方法 赋值
                myData.changeData();
                System.out.println(Thread.currentThread().getName() + " :  " + myData.data);
            }
        }, "操作数据线程").start();

        // 主线程查看数据是否改了
        while (myData.data == 0) ;
        System.out.println("main线程结束");
    }

    static class MyData {
        static int data = 0;

        public void changeData() {
            this.data = 2020;
        }

    }

}

