package cn.luliangwei.interview.questions.initorder;
/**
 * 
 * 初始化顺序：
 *      静态变量,静态代码块--->初始化代码块,变量--->构造器
 */
public class InitialOrder1 {

    public static String static_field = "静态变量";
    
    public String normal_field = "普通变量";
    
    {
        System.out.println(normal_field);
        System.out.println("初始化代码块");
    }
    
    static {
        System.out.println(static_field);
        System.out.println("静态代码块");
    }
    
    public InitialOrder1() {
        System.out.println("构造方法");
    }
    public static void main(String[] args) {
        new InitialOrder1();
    }
}
