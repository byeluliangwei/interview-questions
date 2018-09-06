package cn.luliangwei.interview.questions.stack;
/**
 * 用两个栈来实现一个队列，完成push和pop操作，队列中的元素类型为int
 */

import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
/**
 * 用两个栈实现一个队列
 * </p>
 * 思路：</br>
 *  将入队的元素放入head栈中</br>
 *  出队时，如果rear栈不是空，那么就从它去除元素</br>
 *  如果是空，那么就将head中的所有元素放入rear栈中
 */
public class StackToQueue<T> {

    Stack<T> head = new Stack<>();
    Stack<T> rear = new Stack<>();

    public void push(T element) {
        this.head.push(element);
    }

    public T pop() {
        if(rear.isEmpty()) {
            while(!head.isEmpty()) {
                rear.push(head.pop());
            }
        }
        return this.rear.pop();
    }
//----------------------------Test this queue----------------------------------------
    public static final class TestQueue {
        StackToQueue<Integer> queue = new StackToQueue<>();

        @Before
        public void before() {
            queue.push(1);
            queue.push(2);
            queue.push(3);
        }

        @Test
        public void test() {
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            queue.push(4);
            System.out.println(queue.pop());
            queue.push(5);
            System.out.println(queue.pop());
        }
    }
}
