package com.pvaen.concurrent.volatiletest;

/**
 * 可见
 */
public class P03 {

    public static void main(String[] args) throws InterruptedException {
        //开始制作咖啡
        new Thread(() -> {
            CoffeeMaker.makeCoffee(Thread.currentThread().getName());
        }).start();

//        Thread.sleep(10);
        Thread.sleep(100);

        //关掉咖啡机
        new Thread(() -> {
            CoffeeMaker.shutdown();
        }).start();
    }

    static class CoffeeMaker {
        private static boolean shutdown = false;

        /**
         * 关闭关闭咖啡机
         */
        public static void shutdown() {
            shutdown = true;
            System.out.println("关闭了咖啡机...");
            try {

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 生成开发
         */
        public static void makeCoffee(String name) {
            System.out.println("咖啡机开始为客户制作咖啡...");
            while (!shutdown) ;
            System.out.println("咖啡机已经停止工作,不再对外提供服务!");
        }
    }
}


