//合并两个排序链表
/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
package Interview;
public class MergeListedNode {
    class ListNode {
        int val;
    ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null&&list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode newHead=new ListNode(-1);
        ListNode newTail=newHead;
        while(list1!=null&&list2!=null){
            ListNode p=list1.val<list2.val?list1:list2;
            if(p==list1){
                newTail.next=new ListNode(list1.val);
                newTail=newTail.next;
                list1=list1.next;
            }else{
                newTail.next=new ListNode(list2.val);
                newTail=newTail.next;
                list2=list2.next;
            }
        }
        if(list1==null){
            newTail.next=list2;
        }
        if(list2==null){
            newTail.next=list1;
        }
        return newHead.next;
    }
}
