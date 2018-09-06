package cn.luliangwei.interview.questions.staticproblem;

public class StaticProblem1 {

    static {
       cnt = 6;
    }
    static int cnt = 100;
    
    public static void main(String[] args) {
        System.out.println(cnt);
        /*
         * 执行顺序为：
         *  cnt = 6        cnt = 100       cnt = 100/2 = 50
         *  
         *  静态代码块可以在静态变量使用之前定义
         */
    }
    
    static {
        cnt/= 2;
    }
}
