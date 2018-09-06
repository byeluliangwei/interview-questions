package cn.luliangwei.interview.questions.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*
     * 小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：
     * 第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
     * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
     */
    public static int countPrice(int n) {
        int sum = 1;
        int count = 1;
        while(sum <= n) {
            count++;
            sum += count;
        }
        return n == 1 ? 1 : n - 2*(count -2);
    }
    
   //---------------------------------------------------------------------- 
    /*
     * 判断一个数组的子数组翻转过后，是不是升序数组
     */
    public static String inverseArray(int[] array) {
        
        int low = 0;
        int high = 0;
        for(int i = 0 ; i< array.length-1 ; i++) {
            if(array[i] > array[i+1]) {
                low = i;
                break;
            }
        }
        for(int j = array.length-1 ; j >0;j--) {
            if(array[j] < array[j-1]) {
                high = j;
                break;
            }
        }
        if(low < high) {
            int[] cut = Arrays.copyOfRange(array, low, high);
            for(int i = 0 ; i< cut .length-1 ;i++) {
                if(cut[i] < cut[i+1]) return "no";
            }
            //处理端点的情况
            if(low == 0 && cut[low] > array[high + 1]) return "no";
            if(high == array.length-1 && cut[high] < array[high - 1]) return "no"; 
            
            return "yes";
        }
        return "no";
    }
    
  //---------------------------------------------------------------------- 
    /*
     * 解法2：
     * 
     * 思路：复制这个数组，并将其进行排序
     * 例如原始数组为：
     *            1,2,5,4,3,6
     * copy排序后：     1,2,3,4,5,6
     *                i   j
     * 
     * 找到i和j，循环判断i和j的值是否相同，直到循环完成
     * 如果都相同，则yes，否则no
     */
    
    public static String reverseArray_2(int[] array,int[] copy) {
        
        int low = 0;
        int high = array.length -1;
        while(low < high && copy[low] == array[low]) low++;
        while(low < high && copy[high] == array[high]) high--;
        
        int k;
        for(k = 0 ;k <= high-low; k++) {
            if(copy[low+k] != array[high-k])
                break;
        }
        if(k > low-high) {
            return "yes";
        }else {
            return "no";
        }
    }
    /*
     * 计算比率
     */ 
    public static String similarRatio(char[] history,char[] light) {
        
        int len = history.length;
        int count = 0;
        for(int i = 0 ;i < len ;i++) {
            if(history[i] >= 'a' && history[i] <= 'z' || 
                    history[i] >= 'A' && history[i] <= 'Z' ||
                    history[i] >= '0' && history[i] <= '9') {
                history[i] = '1';
            }else {
                history[i] = '0';
            }
            
            if(history[i] == light[i]) count++;
        }
        return String.format("%.2f%%",( (double)count/(double)len ) * 100);
    }
    /*
     * 跳台阶
     */
    public static int walkStep(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        return walkStep(n-1) + walkStep(n-2);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int j = 0;j<n;j++) {
            System.out.println(walkStep(scanner.nextInt()));
        }
        scanner.close();
    }
}
