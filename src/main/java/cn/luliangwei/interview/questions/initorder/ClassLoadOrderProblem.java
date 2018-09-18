package cn.luliangwei.interview.questions.initorder;
/**
 * <pre>
 * static 代码块，只在类初始化的时候执行一次
 * 实例化代码块，每次生成对象的时候都会执行，优于构造方法执行
 * </pre>
 * 
 */
public class ClassLoadOrderProblem {

    public static void main(String[] args) {
        new ClassB();

        System.out.println("------------------------------------");
       new ClassA();
        System.out.println("------------------------------------");
       new ClassA();
    }
}
