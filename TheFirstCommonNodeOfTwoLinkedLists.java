//两个链表的第一个公共节点
/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 */
package Interview;
public class TheFirstCommonNodeOfTwoLinkedLists {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        int length1=getLength(pHead1);
        int length2=getLength(pHead2);
        //求链表一和链表二长度差值
        int size=Math.abs(length1-length2);
        //链表一长度大于链表二。链表一先走size步，两个链表长度相同。
        if(length1>length2){
            for(int i=0;i<size;i++){
                pHead1=pHead1.next;
            }
        }
        //链表二长度大于链表一。链表二先走size步，两个链表长度相同。
        else{
            for(int i=0;i<size;i++){
                pHead2=pHead2.next;
            }
        }
        //同步向后走，找第一个地址相同的节点,找到了直接返回；两个节点都为空也没找到，返回null
        while(pHead1!=null&&pHead2!=null){
            if(pHead1==pHead2){
                return pHead1;
            }
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return null;
    }
    //求链表长度
    private int getLength(ListNode node){
        int length=0;
        for(ListNode cur=node;cur!=null;cur=cur.next){
            length++;
        }
        return length;
    }
}
