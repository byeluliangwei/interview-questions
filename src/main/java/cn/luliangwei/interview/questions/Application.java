package cn.luliangwei.interview.questions;

import java.util.ArrayList;

import cn.luliangwei.interview.questions.arrays.ArrayQuestion;
import cn.luliangwei.interview.questions.arrays.ListNode;

/**
 * Hello world!
 *
 */
public class Application 
{
    public static void main( String[] args )
    {
        int [][] array = {{1,3,5,6}
                         ,{2,4,6,8}
                         ,{3,6,9,10}
                         ,{4,8,12,14}};
        System.out.println(ArrayQuestion.isContainTarget(6, array));
        
        ListNode head = new ListNode(1);
        head.next(1).next(2).next(3);
        ArrayList<Integer> list = ArrayQuestion.printListFromTailToHead(head);
        System.out.println(list);
    }
}
