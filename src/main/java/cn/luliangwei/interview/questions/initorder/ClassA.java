package cn.luliangwei.interview.questions.initorder;

public class ClassA {

    public ClassA() {
        System.out.println("class A constructor");
    }
    {
        System.out.println("I'm A class");
    }
    
    static {
        System.out.println("ClassA static ");
    }
}
