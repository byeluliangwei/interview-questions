package cn.luliangwei.interview.questions.algorithm;

/**
 * <pre>
 * 复杂链表结构
 * 
 * 一个指针指向下一个节点
 * 
 * 一个指向任意一个节点
 * 
 * 一个代表节点value
 * 
 * 注：访问权限
 *      本类中的属性默认是default类型
 *      
 *      default 同一个包中可以访问
 *      public 不同包中可以访问
 *      private 仅同一个类中可以访问
 * </pre>
 */
public class RandomListNode {
    
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
    
    RandomListNode (int label){
        this.label = label;
    }
}
