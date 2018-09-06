package cn.luliangwei.interview.questions.staticproblem;

public class StaticProblem2 {

    static int count = 6;
    static {
        count += 9;
    }
    
    public static void main(String[] args) {
        System.out.println(count);
    }
    static {
        count /= 3;
    }
}
