package cn.luliangwei.interview.questions.arrays;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;


/**
 * 
 * 数组相关的问题.
 * </p>
 * 一维数组和二维数组.
 *
 * @author luliangwei
 */
public class ArrayQuestion {

    /**
     * <1>查找
     * <pre>
     * 时间限制：1秒 空间限制：32768K 
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 
     * 结果：
     * 运行时间：236ms
     * 占用内存：16268K
     * </pre>
     */
    public static boolean isContainTarget(int target, int[][] array) {
        if(array.length == 0){
            return false;
        }
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * <2>链表
     * <pre>
     * 输入一个链表，从尾到头打印链表每个节点的值。
     * 
     * 结果：
     * 运行时间： 23ms
     * 占用内存： 9432K
     * </pre>
     */
    
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
       Stack<Integer> stack = new Stack<>();
       while(listNode != null) {
           stack.push(listNode.val);
           listNode = listNode.next;
       }
       ArrayList<Integer> list = new ArrayList<>();
       while(!stack.isEmpty()) {
           list.add(stack.pop());
       }
       return list;
    }
    
    /**
     * <3>数组
     * 就是求一个数组中的最小的值
     */
    public static int minNumberInRotateArray(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        int min=array[0];
        for(int i=1;i<array.length;i++) {
            if(array[i]<min) {
                min = array[i];
            }
        }
        return min;
    }
    
    /**
     * <4>斐波那契数列
     * 
     * 要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     */
    public static int fibonacci(int n) {
        if(n==0) {
            return 0;
        }
        if(n==1 || n==2) {
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
//-----------------------------------Test for this class------------------------------------------------------    
    public static final class UnitTest{
        
        @Test
        public void testMinNumberInRotateArray() {
            int array[] = {1,2,3,4,5,1,2};
            int min = ArrayQuestion.minNumberInRotateArray(array);
           System.out.println(min);
        }
        
        @Test
        public void testFibonacci() {
            Assert.assertEquals(ArrayQuestion.fibonacci(0), 0);
            Assert.assertEquals(ArrayQuestion.fibonacci(1), 1);
            Assert.assertEquals(ArrayQuestion.fibonacci(2), 1);
            Assert.assertEquals(ArrayQuestion.fibonacci(3), 2);
            Assert.assertEquals(ArrayQuestion.fibonacci(4), 3);
            Assert.assertEquals(ArrayQuestion.fibonacci(5), 5);
            Assert.assertEquals(ArrayQuestion.fibonacci(6), 8);
            Assert.assertEquals(ArrayQuestion.fibonacci(7), 13);
            Assert.assertEquals(ArrayQuestion.fibonacci(8), 21);
            
        }
    }
    
}
