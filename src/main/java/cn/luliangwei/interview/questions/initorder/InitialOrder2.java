package cn.luliangwei.interview.questions.initorder;
/**
 * 
 * 父类中的静态语句块要优于子类的变量赋值操作B=2
 * 
 */
public class InitialOrder2 {

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
    
    static class Parent{
        public static int A = 1;
        
        static {
            A = 2;
        }
    }
    
    static class Sub extends Parent{
        public static int B = A;
    }
}
