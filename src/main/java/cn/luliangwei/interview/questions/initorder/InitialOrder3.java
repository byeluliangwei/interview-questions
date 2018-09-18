package cn.luliangwei.interview.questions.initorder;


/**
 * 这段代码按照顺序执行：i = 3, i = 1 , j = 1,j = 3
 * 
 */
public class InitialOrder3 {

    static {
        i = 3; //编译正确，不报错
//        System.out.println(i);编译会报错，因为向前引用了
    }
    
    static int i = 1;
    static int j = 1;
    
    static {
        j = 2;
    }
    
    public static void main(String[] args) {
        System.out.println(InitialOrder3.i);
        System.out.println(InitialOrder3.j);
    }
}
