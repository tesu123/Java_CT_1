class MyThread extends Thread {
    public void run() {
        System.out.println("\nThread running using Thread class ...");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("\nThread running using Runnable interface...");
    }
}

public class ThreadExample {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();
    }
}
