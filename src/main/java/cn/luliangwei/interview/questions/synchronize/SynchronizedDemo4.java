package cn.luliangwei.interview.questions.synchronize;
/**
 * 同步代码块
 */
public class SynchronizedDemo4 {

    private String str = "I'm a String Object";
    
    public void methodA() {
        synchronized (str) {
            System.out.println("method A sync block");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodB() {
        synchronized (str) {
            System.out.println("method B sync block");
        }
    }
    
    public void methodC() {
        synchronized (this) {
            System.out.println("method C sync block");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void methodD() {
        synchronized (this) {
            System.out.println("method D sync block");
        }
    }
    
    public static void main(String[] args) {
        SynchronizedDemo4 demo = new SynchronizedDemo4();
        
        Thread t1 = new Thread(()->{demo.methodA();});
        t1.start();
        
        Thread t2 = new Thread(()->{demo.methodB();});
        t2.start();
        
        Thread t3 = new Thread(()->{demo.methodC();});
        t3.start();
        
        Thread t4 = new Thread(()->{demo.methodD();});
        t4.start();
    }
}
