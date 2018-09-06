package cn.luliangwei.interview.questions.algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    /*
     * 小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化： 第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
     * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
     */
    public static int countPrice(int n) {
        int sum = 1;
        int count = 1;
        while (sum <= n) {
            count++;
            sum += count;
        }
        return n == 1 ? 1 : n - 2 * (count - 2);
    }

    // ----------------------------------------------------------------------
    /*
     * 判断一个数组的子数组翻转过后，是不是升序数组
     */
    public static String inverseArray(int[] array) {

        int low = 0;
        int high = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                low = i;
                break;
            }
        }
        for (int j = array.length - 1; j > 0; j--) {
            if (array[j] < array[j - 1]) {
                high = j;
                break;
            }
        }
        if (low < high) {
            int[] cut = Arrays.copyOfRange(array, low, high);
            for (int i = 0; i < cut.length - 1; i++) {
                if (cut[i] < cut[i + 1])
                    return "no";
            }
            // 处理端点的情况
            if (low == 0 && cut[low] > array[high + 1])
                return "no";
            if (high == array.length - 1 && cut[high] < array[high - 1])
                return "no";

            return "yes";
        }
        return "no";
    }

    // ----------------------------------------------------------------------
    /*
     * 解法2：
     * 
     * 思路：复制这个数组，并将其进行排序 例如原始数组为： 1,2,5,4,3,6 copy排序后： 1,2,3,4,5,6 i j
     * 
     * 找到i和j，循环判断i和j的值是否相同，直到循环完成 如果都相同，则yes，否则no
     */

    public static String reverseArray_2(int[] array, int[] copy) {

        int low = 0;
        int high = array.length - 1;
        while (low < high && copy[low] == array[low])
            low++;
        while (low < high && copy[high] == array[high])
            high--;

        int k;
        for (k = 0; k <= high - low; k++) {
            if (copy[low + k] != array[high - k])
                break;
        }
        if (k > low - high) {
            return "yes";
        } else {
            return "no";
        }
    }

    // ----------------------------------------------------------------------
    /*
     * 计算比率
     */
    public static String similarRatio(char[] history, char[] light) {

        int len = history.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (history[i] >= 'a' && history[i] <= 'z' || history[i] >= 'A' && history[i] <= 'Z'
                    || history[i] >= '0' && history[i] <= '9') {
                history[i] = '1';
            } else {
                history[i] = '0';
            }

            if (history[i] == light[i])
                count++;
        }
        return String.format("%.2f%%", ((double) count / (double) len) * 100);
    }

    // ----------------------------------------------------------------------
    /*
     * 跳台阶
     */
    public static int walkStep(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        return walkStep(n - 1) + walkStep(n - 2);
    }

    // ----------------------------------------------------------------------
    /*
     * 一个公交车经过n个站点，乘客从前门上车，从后门下车。现在统计了在第i个站，下车人数a[i]，以及上车人数b[i]。
     * 问公交车运行时候车上最多有多少乘客
     * 
     * 第一行读入一个整数n(1<=n<=100)，表示有n个站点接下来n行，每行两个数值，分别表示在第i个站点下车人数和上车人数
     */
    public static int maxPeopleInCar(int[] in, int[] out) {
        int current = in[0] - out[0];

        int max = current;
        for (int i = 1; i < in.length; i++) {
            current += in[i] - out[i];
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    public static void main_1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] in = new int[n];
        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            out[i] = scanner.nextInt();
            in[i] = scanner.nextInt();
        }
        System.out.println(maxPeopleInCar(in, out));
        scanner.close();
    }

    // ----------------------------------------------------------------------
    /*
     * 成绩依次为 政治 英语 数学 专业课
     */
    public static String admission(int[] record) {
        int total = record[0] + record[1] + record[2] + record[3];
        if (record[0] < 60 || record[1] < 60 || record[2] < 90 || record[3] < 90) {
            return "Fail";
        }
        if (total < 310) {
            return "Fail";
        }
        if (total < 350) {
            return "Zifei";
        }
        return "Gongfei";
    }

    public static void main_2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] record = new int[4];
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            record[0] = scanner.nextInt();
            record[1] = scanner.nextInt();
            record[2] = scanner.nextInt();
            record[3] = scanner.nextInt();
            result.add(admission(record));
        }
        for (String s : result) {
            System.out.println(s);
        }
        scanner.close();
    }

    // ----------------------------------------------------------------------
    /*
     * 接金币
     */
    public static int getGoldenCoin() {

        return 0;
    }

    public static void main_3() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    }

    // ===========================================================================================
    /*
     * 接金币
     */
    public static void main_01(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] pos = new int[n];
        int[] tim = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
            tim[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (tim[j] < tim[i]) {
                    swap(pos, i, j);
                    swap(tim, i, j);
                }
            }
        }
        int curPos = 5;
        int curTim = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (curPos == pos[i]) {
                count++;
                curPos = pos[i];
                curTim = tim[i];
            } else if (curPos + (tim[i] - curTim) - pos[i] == 0 || curPos - (tim[i] - curTim) - pos[i] == 0) {
                count++;
                curPos = pos[i];
                curTim = tim[i];
            }
        }
        System.out.println(count);
    }

    public static void swap(int a[], int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    // --------------------------------------------------------------------------------------
    /*
     * 下起楼来我最快
     */
    public static void main_02(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        long t1 = sc.nextInt();
        long t2 = sc.nextInt();
        long t3 = sc.nextInt();
        long t4 = sc.nextInt();
        long s1 = (Math.abs(n - m) + n - 1) * t1 + 2 * t2 + t3;
        long s2 = (n - 1) * t4;
        System.out.println(s1 > s2 ? s2 : s1);
    }

    // --------------------------------------------------------------------------------------
    /*
     * 回文串
     */
    public static void getValue(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {
                if (reverse.charAt(j - 1) == s.charAt(k - 1)) {
                    dp[j][k] = dp[j - 1][k - 1] + 1;
                } else {
                    dp[j][k] = Math.max(dp[j - 1][k - 1], dp[j - 1][k]);
                    dp[j][k] = Math.max(dp[j][k], dp[j][k - 1]);
                }
            }
        }
        if (n - dp[n][n] > 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    public static void main_03(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            getValue(s);
        }
    }

    // --------------------------------------------------------------------------------------
    /*
     * 搬圆桌
     */
    public static void main04(String[] args) {
        Scanner in = new Scanner(System.in);
        long r = in.nextLong();
        long x = in.nextLong();
        long y = in.nextLong();
        long x1 = in.nextLong();
        long y1 = in.nextLong();
        in.close();
        double d = Math.sqrt(Math.pow((x - x1), 2) + Math.pow((y - y1), 2));
        int result = 0;
        if (d % (2 * r) == 0) {
            result = (int) (d / (2 * r));
        } else {
            result = (int) (d / (2 * r)) + 1;
        }
        System.out.println(result);
    }
 // --------------------------------------------------------------------------------------
    /*
     *文艺青年爱文学
     */
    public static void main05(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int [] b = new int[m+1];
        int [] c = new int[m+1];
        for(int i=1;i<=m;i++) {
          b[i] = sc.nextInt();
          c[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
          int [] dp = new int[a[i]+1];
          int temp = completePackFullMin(dp,b,c);
          if (temp < min){
            min = temp;
          }
        }
        if(min == Integer.MAX_VALUE) System.out.println("It is not true!");
        else System.out.println(min);
      }
    public static int completePackFullMin(int[] f,int[] weight,int[] value){
            for(int i = 1;i < f.length;i++){
                f[i] = Integer.MAX_VALUE;
            }
            for(int i = 1;i < weight.length;i++){
                for(int j = weight[i];j < f.length;j++){
                    f[j] = Math.min(f[j], 
                            f[j - weight[i]] == Integer.MAX_VALUE?Integer.MAX_VALUE:f[j - weight[i]] + value[i]);
                }
            }
            return f[f.length-1];
        }
    //-----------------------------------------------------------------------
    /*
     * 认老乡
     */
    private static final int XIAO_SAI = 1;
    public static void main06(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> laoXiang = new HashSet<Integer>();
        List<Integer> arr = new ArrayList<Integer>();
        
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m==0 && n==0)
                break;
            for(int i=0;i<m;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                
                if(a==XIAO_SAI)
                {
                    laoXiang.add(b);
                }
                else if(b==XIAO_SAI)
                    laoXiang.add(a);
                else if(laoXiang.contains(a))
                    laoXiang.add(b);
                else if(laoXiang.contains(b))
                    laoXiang.add(a);
                else {
                    arr.add(a);
                    arr.add(b);
                }
            }
            
            for(int i=0;i<arr.size()-1;i++){
                int j = i+1;
                if(laoXiang.contains(arr.get(i)))
                    laoXiang.add(arr.get(j));
                if(laoXiang.contains(arr.get(j)))
                    laoXiang.add(arr.get(i));
            }
                        
            System.out.println(laoXiang.size());
            arr.clear();
            laoXiang.clear();
        }
    }
  //-----------------------------------------------------------------------
    /*
     * 字符判断
     */
    public static void main07(String[] args) throws IOException {
        HashMap<Integer,Integer> mp1=new HashMap<>(),mp2=new HashMap<>();
        int a;
        while ((a=System.in.read())!='\n'){
            mp1.put(a,mp1.getOrDefault(a,0)+1);
        }
        while ((a=System.in.read())!='\n'){
            mp2.put(a,mp2.getOrDefault(a,0)+1);
        }
        int flag=1;
        for (Integer s : mp2.keySet()){
            Integer p1=mp1.get(s),p2=mp2.get(s);
            if (p1==null||p1.compareTo(p2)<0){
                flag=0;
                break;
            }
        }
        System.out.println(flag);
    }
    
    //--------------------------------------------------------------------
    /*
     * 路灯
     */
    public static void main08(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int n = cin.nextInt();
        int l = cin.nextInt();
        for(int i = 0; i < n; i++) {
            list.add(new Integer(cin.nextInt()));
        }
        Collections.sort(list);
        cin.close();
        double min = ((double)maxDistance(list)) / 2.0;
        double d2 = list.get(0);
        double d3 = l - list.get(list.size() - 1);
        if (d2 > 0.0) {
            min = min > d2 ? min : d2;
        }
        if (d3 > 0.0) {
            min = min > d3 ? min : d3;
        }
        System.out.printf("%.2f", min);
        
    }
    
    public static int maxDistance(List<Integer> list) {
        int distance = 0;
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i).intValue();
            int b = list.get(i - 1).intValue();
            if (a - b > distance) {
                distance = a - b;
            }
        }
        return distance;
    }
}
