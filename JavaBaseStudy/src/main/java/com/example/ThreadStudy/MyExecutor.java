package com.example.ThreadStudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
newFixedThreadPool（固定大小线程池）
创建一个可重用固定线程集合的线程池，以共享的无界队列方式来运行这些线程（只有要请求的过来，就会在一个队列里等待执行）。
如果在关闭前的执行期间由于失败而导致任何线程终止，那么一个新线程将代替它执行后续的任务（如果需要）。
*/
public class MyExecutor extends Thread {
    private int index;
    public MyExecutor(int i) {
        this.index = i;
    }
    public void run() {
        try {
            System.out.println("[" + this.index + "] start....");
            Thread.sleep((int) (Math.random() * 10000));
            System.out.println("[" + this.index + "] end.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            service.execute(new MyExecutor(i));
            // service.submit(new MyExecutor(i));
        }
        System.out.println("submit finish");
        service.shutdown();
    }
}