//链表中倒数第K个结点
/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
package Nowcoder;
//方法一：求链表长度length。倒数第k个节点，即为正数第length-k节点。
public class TheLastKthNode {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        int length = getLength(head);
        if (k > length) {
            return null;
        }
        int size = length - k;
        ListNode cur = head;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private int getLength(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        return length;
    }
}
//方法二：前后指针。前后指针都从head出发。
//让前指针先走k步，后指针走（链表总长度-k）步，当前指针为空时，后指针刚好指向倒数第k个结点。
class TheLastKthNode2 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<0){
            return null;
        }
        ListNode front=head;
        ListNode behind=head;
        while(k>0&&front!=null){
            front=front.next;
            k--;
        }
        while(front!=null){
            front=front.next;
            behind=behind.next;
        }
        return k>0?null:behind;
    }
}