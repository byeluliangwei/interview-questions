package cn.luliangwei.interview.questions.synchronize;
/**
 * 同步静态方法，锁的是当前类的Class对象（全局锁）
 * 
 */
public class SynchronizedDemo3 {

    public synchronized static void mehtodA() {
        System.out.println("method A ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public synchronized static void methodB() {
        System.out.println("method B ");
    }
    
    
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        SynchronizedDemo3 demo1 = new SynchronizedDemo3();
        SynchronizedDemo3 demo2 = new SynchronizedDemo3();
        
        Thread t1 = new Thread(()-> {demo1.mehtodA();});
        t1.start();
        
        Thread t2 = new Thread(() -> {demo2.methodB();});
        t2.start();
        
    }
}
