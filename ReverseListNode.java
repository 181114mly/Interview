//反转链表
/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
package Interview;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//方法一
public class ReverseListNode {
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=null;
        ListNode cur=head;
        ListNode newHead=null;
        while(cur!=null){
            ListNode next=cur.next;
            if(next==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return newHead;
    }
}
//方法二
class ReverseListNode2 {
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=null;
        while(head!=null){
            ListNode p=head;
            head=head.next;
            p.next=newHead;
            newHead=p;
        }
        return newHead;
    }
}
