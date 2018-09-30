package cn.luliangwei.interview.questions.synchronize;
/**
 * 同步非静态方法
 * 
 */
public class SynchronizedDemo2 {

    public synchronized void mehtodA() {
        System.out.println("method A ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    
    public synchronized void methodB() {
        System.out.println("method B ");
    }
    
    
    public static void main(String[] args) {
        SynchronizedDemo2 demo = new SynchronizedDemo2();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.mehtodA();
            }
        });
        t1.start();
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.methodB();
                
            }
        });
        t2.start();
        
    }
}
