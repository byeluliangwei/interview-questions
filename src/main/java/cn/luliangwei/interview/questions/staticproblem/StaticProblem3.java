package cn.luliangwei.interview.questions.staticproblem;

public class StaticProblem3 {

    public static void main(String[] args) {
        System.out.println(new B().c);
    }
    
    public static class A {
        static {
            System.out.println("A");
        }
    }
    
    public static class B extends A{
        static {
            System.out.println("B");
        }
        public final static  String c = "C";
    }
}
