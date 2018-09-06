package cn.luliangwei.interview.questions.algorithm;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.lang.model.element.Element;

import cn.luliangwei.interview.questions.arrays.ListNode;
import cn.luliangwei.interview.questions.tree.TreeNode;

/**
 * 
 * 主要包含了一些常见的经典算法问题.
 * </p>
 *
 * @author luliangwei
 * @since 2018年8月18日14:29:16
 */
public class AlgorithmProblem {

    /**
     * 斐波那契数列原型
     * <pre>
     * 题目：
     *    有一对兔子，从出生后第3个月起，每个月都生一对兔子，小兔子长到第3个月，每个月又生一对兔子
     *    假如兔子不死，问每个月的兔子总数为多少？
     * 
     * 分析：
     * 从第一个月算起，每个月的兔子对数为：
     * 1 1 2 3 5 8 13 21...
     * 
     * 每个月的兔子对数，是前两个月兔子数的和
     * 那么当前月的兔子对数，就是上一个月兔子数+上两个月兔子数
     * </pre>
     */
    public static int rabbitBornProblem(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException("月份必须大于 0");
        }
        if (x == 1 || x == 2)
            return 1;
        return rabbitBornProblem(x - 1) + rabbitBornProblem(x - 2);
    }

    // -------------------------------------------------------------------------------------------------

    /**
     * 题目： 判断101-200之间有多少个素数，并输出所有素数
     * 
     * 素数：大于1的自然数中，除了1和它本身以外不再有其他因数
     * 
     * Math.sqrt(num)可以换成 num/2
     */
    public static boolean isPrimeNumber(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("计算区间不合法");
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    // ---------------------------------------------------------------------------------------------------

    /**
     * <pre>
     * 题目： 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
     *  
     *  例如：153是一个 "水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
     *  
     *  分析：由于是一个三位数，所以可以确定范围是100-999
     *  
     *  结果：153 370 371 407 
     * </pre>
     */
    public static void daffodilNumber() {
        for (int i = 100; i <= 999; i++) {
            String num = String.valueOf(i);
            int a = Integer.valueOf(num.substring(0, 1));
            int b = Integer.valueOf(num.substring(1, 2));
            int c = Integer.valueOf(num.substring(2, 3));
            if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == i) {
                System.out.print(i + " ");
            }
        }
    }

    /*
     * 解法2
     */
    public static void daffodilNumber2() {
        for (int i = 100; i < 1000; i++) {
            int a = i / 100;// 百位
            int b = (i % 100) / 10;// 十位
            int c = i % 10; //个位
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.print(i + " ");
            }
        }
    }
    
    //-------------------------------------------------------------------------------

    /**
     * 题目：将一个正整数分解质因数。例如：输入 90 ,打印出 90=2*3*3*5。
     * 
     * 分析：
     *    首先找一个最小的素数2，然后遍历
     *    如果num能被i整除，就打印i，并取出num/i的商作为新的正整数
     *    如果不能整除，i+1，继续循环
     */
    public static void  disintegrationPrimeNumber(int num) {
        for(int i = 2;i <= num/2 ; i++) {
            if(num%i == 0) {
                System.out.print( i + "*");
                disintegrationPrimeNumber(num/i);
            }
        }
        System.out.println(num);
        System.exit(0);
    }
    /**
     * 解法2
     * 上面那个解法效率高点
     */
    public static void  disintegrationPrimeNumber2(int num) {
        String s = "";
        int k = 2;
        while(num>k) {
            if(num%k ==0) {
                s += k+"*";
                num = num/k;
            }
            k++;
        }
        System.out.println(s.substring(0, s.length()-1));
    } 
    
    //-----------------------------------------------------------------------------
    /**
     * 斐波那契数列原型
     * </p>
     * 题目：</br>
     *      一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     *      求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *   
     */
    public static int jumpFloor(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        return jumpFloor(n-1)+jumpFloor(n-2);
    }
    
    //-----------------------------------------------------------------------------
    /**
     * 变态跳：每次都是前一次的2倍
     * </p>
     * 题目：</br>
     *      一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     *      求该青蛙跳上一个n级的台阶总共有多少种跳法
     */
    public static int jumpFloorII(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return jumpFloorII(n-1)<<1;
    }
    
    //-----------------------------------------------------------------------------
    /**
     * 斐波那契数列
     * </p>
     * 题目：</br>
     *      我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
     * 
     */
    public static int rectCover(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        return rectCover( n-1) + rectCover(n-2);
    }
    
    /**
     * 采用大数实现，效率比递归要高
     */
    public static BigDecimal fibonacci(int n) {
        BigDecimal[] f = new BigDecimal[n+2];
        f[0] = BigDecimal.valueOf(0);
        if(n == 0) return f[0];
        f[1] = f[2] = BigDecimal.valueOf(1);
        if(n == 1 || n ==2) return f[1];
        for(int i = 3 ;i<=n ;i++) {
            f[i] = f[i-1].add(f[i-2]);
        }
        return f[n];
    }
    
    //--------------------------------------------------------------------------------
    /**
     * 
     * </p>
     * 题目：</br>
     *      输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     *      
     * 思路：</br>
     *      1、正整数十进制转二进制，除2取余，倒排序，高位补0</br>
     *      2、负整数十进制转二进制，将对应的正整数转二进制，取反，结果再加1
     *      
     *  本题中说明了负数用补码表示，直接算0的个数即可
     *  
     *  直接用自带的方法算出二进制，然后算1的个数即可
     */
    public static int numberOf1(int n) {
        return Integer.toBinaryString(n).replace("0", "").trim().length();
    }
    
    /**
     * 解法2
     * </p>
     * 将一个整数和比它小1的整数做&运算,会把最右边的1去掉（除了符号位），有多少个1就可以&多少次
     */
    public static int numberOf1_2(int n) {
        int count = 0;
        if(n == 0) return count;
        while(n!=0) {
            n &= n-1;
            count++;
        }
        return count;
    }
    
    /**
     * 解法3
     * </p>
     * 此方法只能对正整数进行运算
     */
    public static int numberOf1_3(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) !=0 ) {
                count++;
            }
            n >>=1;
        }
        return count;
    }
    
    //--------------------------------------------------------------------------------
    /*
     * 题目：
     *      给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     */
    
    public static double baseExp(double base,int exponent) {
        double result = 1;
        if(exponent == 0) return 1;
        else if(exponent > 0) {
            if(base == 0) return 0;
            for(int i=0;i<exponent;i++) {
                result *= base;
            }
            return result;
        }else {
            if(base == 0) throw new IllegalArgumentException();
            for(int i=0;i<-exponent ;i++) {
                result *= base;
            }
            return 1/result;
        }
    }
    
    //--------------------------------------------------------------------------------
    /**
     * 最笨的办法
     * </p>
     * 题目：</br>
     *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，</br>
     *      所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。</br>
     *      
     * 思路：</br>
     *    1、不管相对位置</br>
     *      如果只把奇数放在前面，偶数放在后面，那么只需要维护头尾两个指针，</br>
     *      如果头指针为偶数，判断尾指针是不是奇数，是的话，交换位置</br>
     *    2、要管相对位置</br>
     *      遍历数组，每找到一个偶数，就将其取出，其余后面的数往前移动一位，再将其这个偶数放在末尾
     *      
     * 17ms
     * 9420k
     *    
     */
    public static void reOrderArray(int[] array) {
        int temp = 0;;
        int[] result = new int[array.length];
        for(int i=0 ; i< array.length ;i++) {
            if(array[i]%2 != 0) {
                result[temp++] = array[i]; 
            }
        }
        for(int j=0 ;j<array.length;j++) {
            if(array[j]%2 == 0) {
                result[temp++] = array[j];
            }
        }
        for(int i=0;i<array.length;i++){
            array[i] = result[i];
        }
    }
    
    /**
     * 解法2
     * </p>
     * 遍历数组，每找到一个偶数，就将其取出，其余后面的数往前移动一位，再将其这个偶数放在末尾</br>
     * 
     * 13ms
     * 9300k
     * 
     * 时间复杂度O(n<sup>2</sup>)
     */
    public static int[] reorderArray2(int[] array) {
        int temp = 0;
        //没移动一次，index前移一位
        int index = array.length;
        for(int i=0;i<index;) {
            if(array[i]%2 == 0) {
                temp = array[i];
                for(int j=i;j<array.length-1;j++) {
                    array[j] = array[j+1];
                }
                array[array.length-1] = temp;
                index--;
                continue;
            }
            i++;
        }
        return array;
    }
    
    /**
     * 扩展
     * </p>
     * 
     * 不管相对位置:</br>
     *      如果只把奇数放在前面，偶数放在后面，那么只需要维护头尾两个指针，</br>
     *      如果头指针为偶数，判断尾指针是不是奇数，是的话，交换位置</br>
     * 
     */
    public static int[] reOrderArray3(int[] array) {
        int temp;
        for(int i=0, j=array.length-1;i<j;) {
            if(array[i]%2 == 0) {
                if(array[j]%2 != 0) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j]  = temp;
                    j--;
                    i++;
                }else {
                    j--;
                    continue;
                }
            }
            i++;
            continue;
        }
        return array;
    }
    
    //--------------------------------------------------------------------------------
    /**
     * 题目：
     *      输入一个链表，输出该链表中倒数第k个结点。
     * </p>
     * 19ms
     * 9548k
     */
    public static ListNode findKthTial(ListNode head,int k) {
        if(k == 0) return null;
        int len = 1;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }
        if(k>len) return null;
        int index = 0;
        while(head!=null) {
            index++;
            if(index == len-k) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
    
    /*
     * 用栈来解决
     * 
     * 39ms
     * 9420k
     */
    public static ListNode findKthTial2(ListNode head,int k) {
        Stack<ListNode> stack = new Stack<>();
        while(head!=null) {
            stack.push(head);
            head = head.next;
        }
        if(stack.isEmpty()) return null;
        if(k>stack.size()) return null;
        return stack.get(stack.size()-k);
    }
    
    //--------------------------------------------------------------------------------
    /**
     * </p>
     * 题目：</br>
     *      输入一个链表，反转链表后，输出新链表的表头。</br>
     * <pre>
     *  head = 1 -> 2 -> 3 -> 4 ->5
     *  node = null
     *  取表头下来
     *  temp = head.next = 2 -> 3 -> 4 -> 5
     *  head.next = node
     *  node = head  当前断开的阶段赋值给node
     *  head = temp
     * </pre>
     * 13ms
     * 9564k
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode node = null;
        while(head!=null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }
    
    /**
     * 递归解法
     * </p>
     * 
     *  1、递归找到最后一个节点，返回，测试的head = 5 -> 6 -> null,node指向的是当前的head ，node = 6 -> null
     *  2、head.next.next = head;此时head变成了 5 -> 6 ->5 -6...的循环链表
     *  3、head.next = null;切断循环链表，head = 5 -> null; node由于指向的是当前head，所以此时node变成 node = 6-> 5 -> null
     *  4、递归退回上一层
     *  
     *  
     * 19ms
     * 9676k
     * 
     */
    public static ListNode reverseList2(ListNode head) {
        //当前链表为空，或者是next为空，直接返回当前节点
        if(head == null || head.next == null) return head;
        
        //递归获取链表最后一个节点,此时node的指针是指向head的，因为return的是head
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    //--------------------------------------------------------------------------------
    /**
     * 
     * 题目：</br>
     *      输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。</br>
     *      
     *      20ms
     *      9160k
     */
    public static ListNode merge(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null) return list1 == null ? list2 : list1;
        ListNode head = null;
        if(list1.val < list2.val) {
            head = list1;
            head.next = merge(list1.next, list2);
        }else {
            head = list2;
            head.next = merge(list1, list2.next);
        }
        return head;
    }
    //---------------------------------------------------------------------------------------------
    /**
     * 题目：</br>
     *      输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）</br>
     *      
     *      20ms
     *      9256k
     */
    public static boolean hasSubTree(TreeNode root1,TreeNode root2 ){
        if(root2 == null) return false;
        if(root1 == null && root2 != null) return false;
        boolean flag = false;
        //比较当前根节点是否相等，是的话就判断是否是子树，否，就判断root1的左子树和右子树
        if(root1.val == root2.val) {
            flag = isSubTree(root1, root2);
        }
        return flag || hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }
    
    //当根节点相同时，判断左、右子树是否相等
    public static boolean isSubTree(TreeNode root1,TreeNode root2 ) {
        if(root2 == null) return true;
        if(root1 == null && root2 != null) return false;
        if(root1.val == root2.val) {
           return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
        return false;
    }
    
    //---------------------------------------------------------------------------------------------
    /**
     * 
     * 题目：</p>
     * 操作给定的二叉树，将其变换为源二叉树的镜像。</br>
     * <pre>
     *        8
     *      /   \
     *     6    10
     *    / \   /  \
     *   5  7  9   11
     *   
     *   镜像
     *        8
     *      /   \
     *     10    6
     *    / \   / \
     *   11  9 7   5
     *  </pre>
     *  </p>
     * 18ms</br>
     * 9564k</br>
     * </p>
     */
    public static void mirrorOfTree(TreeNode root) {
        if(root == null) return;
        TreeNode temp = null;
        if(root!=null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        if(root.left != null) mirrorOfTree(root.left);
        if(root.right != null) mirrorOfTree(root.right);
        
    }
    //---------------------------------------------------------------------------------------------
    /**
     * 做不出来这个题
     * 总算是看答案看明白了
     * </p>
     * 题目：</p>
     *      输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     *      <pre>
     *      例如，如果输入如下4 X 4矩阵
     *                      1  2  3  4  
     *                      5  6  7  8
     *                      9  10 11 12
     *                      13 14 15 16
     *      输出：1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     *      
     *      如果输入4 X 3的矩阵
     *                      1, 2, 3, 4
     *                      5, 6, 7, 8
     *                      9,10,11,12
     *      输出:1,2,3,4,8,12,11,10,9,5,6,7,11,10
     *      </pre>
     * 要求能输出 N x M 类型的矩阵
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        // 矩阵的行数
        int rows = matrix.length;
        // 矩阵的列数
        int columns = matrix[0].length;

        /**
         * <pre>
         * 让循环继续的条件是当前行数大于该圈循环开始的行数的两倍
         * 以及当前列数大于该圈循环开始的列数的两倍（每圈循环开始的行数、列数相同）
         * 
         * 从(0,0)开始循环,圈数：start=0第一圈，start=1第二圈...以此类推 
         * 每圈左上角的起始点，永远都是x，y相等的
         * </pre>
         */
        int start = 0;
        while (rows > start * 2 && columns > start * 2) {

            //每圈右下角的x和y坐标
            int endX = rows - 1 - start;
            int endY = columns - 1 - start;

            // 开始一圈圈打印，每打印一圈分为四步，从左到右、从上到下、从右到左、从下到上
            // 从左到右，第一步一定会走
            for (int i = start; i <= endY; i++) {
                result.add(matrix[start][i]);
            }
            // 从上到下，最后一行大于开始行
            if (endX > start) {
                for (int i = start + 1; i <= endX; i++) {
                    result.add(matrix[i][endY]);
                }
            }
            // 从右到左，最后一行大于开始行，最后一列大于开始列
            if (endX > start && endY > start) {
                for (int i = endY - 1; i >= start; i--) {
                    result.add(matrix[endX][i]);
                }
            }
            // 要从下到上,至少是三行两列，也就是最后一行大于开始行加2，最后一列大于开始列
            if (endX >= start + 2 && endY > start) {
                for (int i = endX - 1; i > start; i--) {
                    result.add(matrix[i][start]);
                }
            }
            start++;//下一圈
        }
        return result;
    }
    
    /**
     * 这个例子只能输出 N x N的矩阵
     */
    public static ArrayList<Integer> printNxNMatrix(int[][] matrix){
        ArrayList<Integer> result = new ArrayList<>();
        int startX = 0; 
        int startY = 0;
        int endX = matrix.length-1;
        int endY = matrix.length-1;
        while( (endX>startX) && (endY>startY) ) {
            //从左到右
            for(int i = startX ; i <= endX ; i++) {
                result.add(matrix[startY][i]);
            }
            //从上到下
            for(int i = startY+1;i <= endY;i++) {
                result.add(matrix[i][endX]);
            }
            //从右到左
            for(int i = endX-1 ; i>=startX ;i--) {
                result.add(matrix[endY][i]);
            }
            //从下到上
            for(int i = endY-1 ; i>startY;i--) {
                result.add(matrix[i][startX]);
            }
            startX++;
            endX--;
            startY++;
            endY--;
        }
        //单独剩一行
        if((startY == endY) && (startX<endX)) {
            for(int i=startX;i<=startY;i++) {
                result.add(matrix[startY][i]);
            }
        }
        //单独剩一列
        if((startX == endX)&&(endY>startY)) {
            for(int i=startY;i<=endY;i++) {
                result.add(matrix[i][startX]);
            }
        }
        //最后剩一个
        if((startY == endY) && (startX == endX)) {
            result.add(matrix[startX][endY]);
        }
        
        return result;
    }
    
    //---------------------------------------------------------------------------------------------
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
     * 
     */
     Stack<Integer> elements = new Stack<>();
     Stack<Integer> min = new Stack<>();
    public  void push(int node) {
        elements.push(node);
        
        if(min.isEmpty() || min.peek() > node) {
            min.push(node);
        }else {
            min.push(min.peek());
        }
        
    }
    
    public  void pop() {
        if(elements.isEmpty()) return;
        //保证两个栈中的size是一样的
        elements.pop();
        min.pop();
    }
    
    public  int top() {
        if(elements.isEmpty()) return 0;
        return elements.peek();
    }
    
    public  int min() {
        if(min.isEmpty()) return 0;
        return min.peek();
    }
    
    //---------------------------------------------------------------------------------------------
    /**
     * 
     * <pre>
     * 题目：
     *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     *      例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     *      但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     * 
     * 思路：
     *      辅助栈中装出栈的顺序
     *      如果入栈的序列不等于辅助栈的栈顶元素，那么就入栈，
     *      如果相等，辅助栈出栈，入栈序列入栈随后就出栈
     *      直到辅助栈为空
     * 
     * 13ms
     * 9416k
     * </pre>
     * 
     */
    public static boolean isPopOrder(int[] pushA,int[] popA) {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();
        for(int i = popA.length-1;i>=0;i--) {
            out.push(popA[i]);
        }
        int index = 0;
        while(!out.isEmpty()) {
            if((index < pushA.length) && (pushA[index] != out.peek()) ) {
                in.push(pushA[index++]);
            }else {
                if(index<pushA.length) {
                    in.push(pushA[index++]);
                    out.pop();
                    in.pop();
                }else if(in.pop() == out.pop()) {
                    continue;
                }else {
                    return false;
                }
            }
        }
        if(out.isEmpty() && in.isEmpty()) {
            return true;
        }
        return false;
    }
    
    //---------------------------------------------------------------------------------------------
    /**
     * 考察队列知识，广度优先遍历
     * <pre>
     * 题目：
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 
     * 19ms
     * 9488k
     * </pre>
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)  return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return list;
    }
    //---------------------------------------------------------------------------------------------
    /**
     * 
     * 概念盲区
     * <pre>
     * 题目：
     *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * 
     * 二叉搜索树（binary serarch tree）BST
     *      或者是一棵空树，或者是具有下列性质的二叉树：若它的左子树不为空，则左子树上所有结点的值均小于它的根结点的值;
     *      若它的右子树不为空，则右子树上所有结点的值均大于它的根节点的值。它的左、右子树也分别为二叉排序树。
     *      
     * 思路：
     *      1、如果数组是一个BST的后序遍历，那么最后一个值，是树的根节点
     *      2、找到第一个小于跟节点的值，它前面的就是这棵树的左子树
     *      3、大于根节点的值，它后面的就是这颗树的右子树
     *  
     *  11ms
     *  9216k
     *  
     * </pre>
     */
    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        int root = sequence[sequence.length - 1];
        // 第一个大于根节点的元素的索引
        int index = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] > root) {
                index = i;
                break;
            }
        }
        // index为0的情况有两种
        if (index == 0) {
            // 第一种是所有的数都比root小
            if (sequence[index] < root) {
                for (int i = 0; i < sequence.length - 1; i++) {
                    if (sequence[i] > root)
                        return false;
                }
            }
            // 第二种是所有的数都比root大
            if (sequence[index] > root) {
                for (int i = 0; i < sequence.length - 1; i++) {
                    if (sequence[i] < root)
                        return false;
                }
            }
            return true;
        }
        // 递归左子树
        boolean lt = true;
        if (index > 0) {
            int[] left = Arrays.copyOfRange(sequence, 0, index);
            lt = verifySquenceOfBST(left);
        }
        // 递归右子树
        boolean rt = true;
        if (sequence.length - 1 > index) {
            int[] right = Arrays.copyOfRange(sequence, index, sequence.length - 1);
            for (int j = 0; j < right.length; j++) {
                if (right[j] < root)
                    return false;
            }
            rt = verifySquenceOfBST(right);
        }
        return lt && rt;
    }
    
    //---------------------------------------------------------------------------------------------
    /**
     * 
     * <pre>
     * 题目：
     *      输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     *      路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *      (注意: 在返回值的list中，数组长度大的数组靠前)
     *
     *
     *  思路：
     *      树的遍历方式有深度优先(DFS depth first search)，广度优先(BFS breadth first search)；前序遍历，中序遍历，后序遍历，从这些方面入手
     *      关于树的遍历，要结合到栈和队列；DFS一般考虑栈，BFS一般考虑队列
     *      树的操作，要考虑递归
     *      
     *      
     *  本题：
     *      1、路径的定义是，从root节点开始，一直到叶子节点，称为路径。先序遍历是从头节点开始
     *      2、采用队列或者栈来存储遍历的结果
     *      3、从队列或者栈中取元素，进行判断
     *      
     *  22ms
     *  9236k
     *  
     * </pre>
     *
     */
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> array = new ArrayList<>();
    int sum = 0;
    
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if(root == null) return result;
        boolean isLeaf = root.left == null && root.right == null;
        sum+=root.val;
        array.add(root.val);
        if( sum == target && isLeaf) {
            ArrayList<Integer> path = new ArrayList<>();
            for(int i =0 ; i< array.size() ; i++) {
                path.add(array.get(i));
            }
            result.add(path);
        }
        if(sum < target && root.left != null) {
            findPath(root.left, target);
        }
        if(sum < target && root.right != null) {
            findPath(root.right, target);
        }
        sum -= root.val;
        array.remove(array.size()-1);
        
        return result;
    }
    
    //---------------------------------------------------------------------------------------------
    /**
     * 解法2 
     * 
     * 31ms
     * 9688k
     */
    public ArrayList<ArrayList<Integer>> findPath2(TreeNode root,int target) {
        if(root == null) return result;
        array.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null  && root.right == null) {
            result.add(new ArrayList<>(array));
        }
        findPath2(root.left, target);
        findPath2(root.right, target);
        target += root.val;
        array.remove(array.size() - 1);
        return result;
    }
    
    //---------------------------------------------------------------------------------------------
    /**
     * <pre>
     * 题目：
     *      输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     *      返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     *
     *  明确题意：
     *      1、复制链表
     *      2、返回复制后的head
     *      
     *  思路：
     *      1、复制主节点
     *      2、复制random节点
     *      3、拆分
     *      
     *  31ms
     *  9684k
     * </pre>
     */
    public static RandomListNode clone(RandomListNode pHead){
        if(pHead == null) return null;
        
        RandomListNode mainNode = pHead ;
        RandomListNode temp;
        //复制next节点
        while(mainNode != null){
            temp = mainNode.next;
            mainNode.next = new RandomListNode(mainNode.label);
            mainNode.next.next = temp;
            mainNode = mainNode.next.next;
        }
        //因为上次移动了过后，mianNode指向了null，所以将其重新指向头节点
        mainNode = pHead;
        //复制random节点
        while(mainNode != null) {
            mainNode.next.random = mainNode.random == null ? null : mainNode.random.next;
            mainNode = mainNode.next.next;
        }
        //因为上次移动了过后，mianNode指向了null，所以将其重新指向头节点，指向的是原链表
        mainNode = pHead;
        RandomListNode clone = pHead.next ;//指向复制后的链表
        //拆分节点
        while( mainNode != null) {
            temp = mainNode.next;
            mainNode.next = temp.next;//截取原来的链表
            temp.next = temp.next == null ? null : temp.next.next; //截取复制的链表
            mainNode = mainNode.next;
        }
        return clone;
    }
    //---------------------------------------------------------------------------------------------
    /**
     * 
     * <pre>
     *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *  
     *  思路：
     *      中序遍历将节点放入栈中，一直到左子树末尾。
     *  
     * </pre>
     */
    public static TreeNode convert(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null;
        boolean isFirst = true;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(isFirst) {
                root = current;
                pre = root;
                isFirst = false;
            }else {
                pre.right = current;
                current.left = pre;
                pre = current;
            }
            current = current.right;
        }
        return root;
    }
    //----------------------------------------------------------------------------
    /**
     * 解法2：这个没通过，但是结果貌似是对的
     * 
     * 思路：
     *    1、中序遍历将所有节点放在queue中
     *    2、构造双向链表
     * 
     */
    static Queue<TreeNode> orderQueue = new LinkedList<>();
    public static TreeNode convert2(TreeNode root) {
        Queue<TreeNode> queue = centerOrder(root);
        root = queue.poll();
        TreeNode pre = root;
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            pre.left = current;
            current.right = pre;
            current.left = null;
            pre = current;
        }
        pre.left = null;
        return root;
    }
    
    public static Queue<TreeNode> centerOrder(TreeNode root){
        if(root.left != null) {
            centerOrder(root.left);
        }
        orderQueue.offer(root);
        if(root.right != null) {
            centerOrder(root.right);
        }
        return orderQueue;
    }
    
    //----------------------------------------------------------------------------
    /**
     * 解法3：递归
     * 
     * 没看懂
     * 
     * 19ms
     * 9308k
     */
    public TreeNode convert3(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        
        TreeNode left = convert3(root.left);
        TreeNode current = left;
        
        while(current != null && current.right != null) {
            current = current.right;
        }
        
        if(left != null) {
            current.right = root;
            root.left = current;
        }
        
        TreeNode right = convert3(root.right);
        if(right!=null) {
            right.left = root;
            root.right = right;
        }
        
        return left != null ? left : root;
    }
    //----------------------------------------------------------------------------
    /**
     * 没做出来
     * <pre>
     * 题目
     *      输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     *      例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * 
     *  输入描述：
     *      输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     *      
     *      abcdefg
     *  基于回溯法思想
     *  学习下回溯法
     *  
     *  113ms
     *  11724k
     * </pre>
     */
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.isEmpty()) return list;
        char[] chars = str.toCharArray();
        permutate(chars, 0, list);;
        Collections.sort(list);//字典排序
        return list;
    }
    public static void permutate(char[] chars, int index,ArrayList<String> list) {
        //length-1 可以避免每次回溯多交换一次
        if(index == chars.length -1) {
            String val = String.valueOf(chars);
            if(!list.contains(val)) {
                list.add(val);
            }
        }else {
            for(int i = index;i<chars.length;i++) {
                swap(chars,index,i);//交换位置
                permutate(chars, index+1, list);//递归排序
                swap(chars, index, i);//回溯，复位
            }
        }
    }
    //交换chars[i] 和  chars[j]的位置
    public static void swap(char[] chars,int i,int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    //------------------------------------------------------------------------------
    /**
     * <pre>
     * 题目：
     *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     *      由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     *  
     *  132ms/223ms
     *  15160k
     * </pre>
     */
    public static int moreThanHalfNum(int[] array) {
        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i< array.length ;i++) {
            list.add(array[i]);
        }
        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(e->e, e->1, (i,j) -> i+j));
        for(Entry<Integer, Integer> entry:map.entrySet()) {
            if(entry.getValue() > list.size()/2) {
                return entry.getKey();
            }
        }
        return 0;
    }
    
    //----------------------------------------------------------------------------------
    /**
     * 解法2:使用map
     * 
     * 11ms
     * 9412k
     */
    public static int moreThanHalfNum2(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<array.length;i++) {
            if(!map.containsKey(array[i])) {
                map.put(array[i], 1);
            }else {
                map.put(array[i], (Integer)map.get(array[i]).intValue() + 1 );
            }
        }
        for(Entry<Integer, Integer> entry:map.entrySet()) {
            if(entry.getValue() > array.length/2) {
                return entry.getKey();
            }
        }
        return 0;
    }
    
    /**
     * 解法3
     * 
     * 假设第一个数就是我们要找的数，然后遍历数组，找出真正出现次数最多的数
     * 11ms
     * 9284k
     */
    public static int moreThanHalfNum3(int[] array) {
        if(array == null) return 0;
        int number = array[0];
        int count = 1;
        //搜索出现次数最多的数字number
        for(int i=1 ; i< array.length ;i++) {
            if(array[i] == number) count++;
            else count--;
            if(count == 0) {
                number = array[i];
                count = 1;
            }
        }
        //统计number出现的总次数
        count = 0;
        for(int i = 0;i<array.length;i++) {
            if(array[i] == number) count++;
        }
        if(count > array.length/2) return number;
        return 0;
    }
    
    /**
     * <pre>
     * 解法4：
     *      如果存在这样的出现次数超过数组长度一半的数，那么一定是中间的那个数，或者中间两个数（必然相等）
     *      先用快速排序，然后选择中间那个数，统计那个数出现的次数。
     *      
     *      12ms
     *      9312k
     * </pre>
     */
    public static int moreThanHalfNum4(int[] array) {
        if(array == null) return 0;
        int len = array.length;
        quickSort(array, 0, array.length-1);
        int num = array[array.length/2];
        int count = 0;
        for(int i = 0; i<len ;i++) {
            if(array[i] == num) count++;
        }
        if(count > len/2) return num;
        return 0;
    }
    
    /**
     * 快速排序算法：
     *      1、寻找一个基准数，从两端开始探测，将所有小于它的数放在其左边，大于它的数放在右边
     * 时间复杂度为nlog(n)
     */
    public static void quickSort(int[] array,int low,int high) {
        if(array == null || low>high) return;
        int temp = array[low];
        int i = low;
        int j = high;
        while(i != j) {
            while(array[j] >= temp && i<j) j--;
            
            while(array[i] <= temp && i<j) i++;
            
            if(i<j) {
                int x = array[i];
                array[i] = array[j];
                array[j] = x;
            }
        }
        array[low] = array[i];
        array[i] = temp;
        quickSort(array, low, i-1);
        quickSort(array, i+1, high);
    }
    //---------------------------------------------------------------------------
    /**
     * <pre>
     * 题目：
     *      输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     *      
     *   24ms
     *   9256k
     * </pre>
     */
    public static ArrayList<Integer> leastNumbers(int[] input,int k){
        ArrayList<Integer> numbers = new ArrayList<>();
        if(input == null || input.length == 0) return numbers;
        if(k>input.length || k<=0) return numbers; 
        quickSort(input, 0, input.length);
        for(int i = 0 ;i< k ;i++) {
            numbers.add(input[i]);
        }
        return numbers;
    }
    
    /**
     * 解法2：冒泡排序法，时间复杂度为n*n
     */
    public static void bubbleSort(int[] array) {
        if(array == null) return;
        for(int i = 0;i<array.length ;i++) {
            for(int j = 0;j<array.length -i-1;j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    //-----------------------------------------------------------------------------------
    /**
     * <pre>
     * 题目：
     *      给一个数组，返回它的最大连续子序列的和
     *      例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     *      
     *      
     * 思路：
     *      max表示最终的最大值，初始化为最小的整数，currentMax表示当前的最大值，初始化为0
     *      第一步，0 + 6 = 6 ,当前最大值为0.currentMax > max  所以max=6
     *      第二步，6 + (-3) = 3，currentMax = 3,max = 6
     *      第三步，3 + （-2） = 1，currentMap = 1,max = 6
     *      第四步,1 + 7 = 8,currentMax = 8,因为currentMax > max 所以max = 8
     *      第五步,8 + (-15) = -7 currentMax = -7 小于0
     *      再加上下一个数1，结果为-6，也就是比1的本身还小，那么就说明，此时的子数组和，会小于从1开始的子数组
     *      后面类推。
     *      
     * </pre>
     */
    public static int findMaxSumOfSubArray(int[] array) {
        if(array == null || array.length <1) 
            throw new IllegalArgumentException();
        int max = Integer.MIN_VALUE;
        int currentMax = 0;
        for(int i : array) {
            if(currentMax <= 0) {
                currentMax = i;
            }else {
                currentMax += i;
            }
            if(max < currentMax) {
                max = currentMax;
            }
        }
        return max;
    }
    //-----------------------------------------------------------------------------------
    /**
     * <pre>
     * 题目：
     *      计算1-N之间的数字中1出现的次数
     * 
     * 不会
     * </pre>
     */
    public static int countNumberOf1_N(int n) {
        
        return 0;
    }
    
    /**
     * <pre>
     * 题目：
     *      输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *      例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     *      
     * 思路：
     *    如题目中的例子，对 332 和323进行比较，然后排序，其余数字类推，排序完成后直接相加
     *    按字典序进行排序，然后相加
     *  </pre>
     */
    public static String printMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String s1 = a + "" + b;
                String s2 = b + "" + a;
                return s1.compareTo(s2);
            };
        });
        String num = "";
        for(Integer k : list) {
            num+=k;
        }
        return num;
    }
    
    /**
     * 输出字符串中出现次数最多的字母及其出现的次数
     * 
     */
    public static void printCharAndNumber(String str) {
        if(str == null || str.equals("")) return;
        char[] chars = str.toCharArray();
        Map<Character ,Integer> map = new HashMap<>();
        for(Character ch : chars) {
            if(ch > 'a' && ch < 'z' || ch >'A' && ch < 'Z') {
                Integer count = map.get(ch);
                map.put(ch, count == null ? 1 : count+1);
            }
        }
        System.out.println(Collections.max(map.keySet()));
    }
    
    
    public static void main(String[] args) {
       int a = 1,b = 32;
       System.out.println(a<<b);
       System.out.println(a<<32);
        
    }

}
