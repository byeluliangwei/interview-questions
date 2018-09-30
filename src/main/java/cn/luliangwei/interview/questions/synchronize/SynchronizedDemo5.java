package cn.luliangwei.interview.questions.synchronize;
/**
 * 同步代码块，锁住的是类对象（Class对象）
 */
public class SynchronizedDemo5 {

    public void methodA() {
        synchronized (SynchronizedDemo5.class) {
            System.out.println("method A sync block");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodB() {
        synchronized (SynchronizedDemo5.class) {
            System.out.println("method B sync block");
        }
    }
    
    public static void main(String[] args) {
        SynchronizedDemo5 demo1 = new SynchronizedDemo5();
        SynchronizedDemo5 demo2 = new SynchronizedDemo5();
        
        Thread t1 = new Thread(()->{demo1.methodA();});
        t1.start();
        
        Thread t2 = new Thread(()->{demo2.methodB();});
        t2.start();
    }
}
