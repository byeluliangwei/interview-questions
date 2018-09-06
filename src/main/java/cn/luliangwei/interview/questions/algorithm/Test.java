package cn.luliangwei.interview.questions.algorithm;


/*
 * 测试类
 */
public class Test {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            //打印前10个月兔子数
            System.out.println("第"+i+"个月,兔子对数为："+AlgorithmProblem.rabbitBornProblem(i));
        }
        //-------------------------------------------------------------------------------------
        int count = 0;
        for(int i=2;i<100;i++) {
            if(AlgorithmProblem.isPrimeNumber(i)) {
                System.out.print(i+ " ");
                count ++ ;
            }
        }
        System.out.println();
        System.out.println("101-200之间的素数总共：" + count + "个");
    }
}
