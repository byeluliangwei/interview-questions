package cn.luliangwei.interview.questions.orderproblem;

public class ClassB extends ClassA{
    public ClassB() {
        System.out.println("ClassB constructor");
    }
    
    //实例化代码块
    {
        System.out.println("I'm B class ");
    }
    
    //静态代码块
    static {
        System.out.println("ClassB static");
    }
}
