package cn.luliangwei.interview.questions.synchronize;
/**
 * 关于synchronized关键字的一些理解
 * 
 * 
 * 输出的结果是：
 *       method A 
 *       method C sync BLOCK
 *       //等待两秒
 *       method B sync block
 *       
 * 原因：methodA()在sleep的两秒里，一直占用着this对象
 *     所以在method()在使用了synchronized 代码块的时候，也是对this进行加锁
 *     需要等到methodA()中的锁释放了之后，methodB()才会使用this对象
 *     
 *     由于methodC()不是对this加锁，所以不需要等methodA()中的锁释放，就可以执行
 *     
 * 原理：
 *      synchronized关键字是给对象加锁，synchronized可以用在方法上，也可以用在代码块中
 *      用在方法上锁的范围大，用在代码块中，锁的范围小。
 *      一般同步的范围越大，性能就越差
 *      
 *      synchronized代码块，锁住的也是括号中的对象，而不是锁住代码块
 *      对于非static的synchronized方法，锁的就是对象本身也就是this。
 *      
 *      static synchronized方法，static方法可以直接类名加方法名调用，方法中无法使用this，
 *      所以它锁的不是this，而是类的Class对象，所以，static synchronized方法也相当于全局锁，相当于锁住了代码段。
 */
public class SynchronizedDemo {

    public synchronized void mehtodA() {
        System.out.println("method A ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    
    public void methodB() {
        synchronized (this) {
            System.out.println("method B sync block");
        }
    }
    
    public void methodC() {
        String s = "method c sync block";
        synchronized (s) {
            System.out.println("method C sync BLOCK");
        }
    }
    
    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        
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
        
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.methodC();
                
            }
        });
        t3.start();
    }
}
