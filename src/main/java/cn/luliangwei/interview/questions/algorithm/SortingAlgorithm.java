package cn.luliangwei.interview.questions.algorithm;
/**
 * 一些经典排序算法
 * 
 */
public class SortingAlgorithm {

    /**
     * 冒泡排序
     * <pre>
     * 
     * 算法：
     *      每次比较相邻的两个元素
     * 特点：
     *  stability：stable
     *  time complexity:
     *      AVG :    O(n<sup>2</sup>)
     *      WORST :  O(n<sup>2</sup>)
     *      BEST :   O(n)
     * </pre>
     */
    public static int[] bubbleSort(int[] array) {
        if(array == null ) return null;
        for(int i = 0 ; i< array.length ; i++) {
            for(int j = 0 ; j< array.length-1;j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
    
    /**
     * 选择排序
     * <pre>
     * 
     * 算法：
     *      先从序列中选取一个最小值，放在序列最前面；再从剩余的序列中选取最小的，放入第一个元素后，依次类推
     * 特点：
     *  stability：unstable
     *  time complexity:
     *      AVG :    O(n<sup>2</sup>)
     *      WORST :  O(n<sup>2</sup>)
     *      BEST :   O(n<sup>2</sup>)
     * </pre>
     */
    public static int[] selectSort(int[] array) {
        if(array == null ) return null;
        for(int i = 0 ; i< array.length - 1 ; i++) {
            int minIndex = i;
            for(int j = i+1 ; j < array.length;j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
    /**
     * 插入排序
     * <pre>
     * 
     * 算法：将第一个元素当成一个有序的序列，剩下依次从无序序列中取出一个数，从后与有序序列比较，然后插入有序序列
     *      
     * 特点：
     *  stability：stable
     *  time complexity:
     *      AVG :    O(n<sup>2</sup>)
     *      WORST :  O(n<sup>2</sup>)
     *      BEST :   O(n)
     * </pre>
     */
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int pre = i - 1;
            int current = array[i];
            while (pre > 0 && array[pre] > current) {
                array[pre + 1] = array[pre];
                pre--;
            }
            array[pre + 1] = current;
        }
        return array;
    }
    
    public static void main(String[] args) {
        int[] array = {1,5,3,7,9,34,6,8,43,87,36,76};
        int[] result = insertSort(array);
        System.out.println(result);
    }
}
