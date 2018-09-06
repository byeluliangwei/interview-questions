package cn.luliangwei.interview.questions.arrays;

/*
 * 自定义JAVA链表数据结构
 */
public class ListNode {

    /*
     * 不定义属性的权限范围,方便直接引用
     */
     public int val;
     public ListNode next = null;
    
    public ListNode(int val) {
        this.val = val;
    }

//    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public ListNode getNext() {
//        return next;
//    }
//
//    public void setNext(ListNode next) {
//        this.next = next;
//    }
    
    public ListNode next(int val) {
        this.next = new ListNode(val);
        return this.next;
    }
    
}
