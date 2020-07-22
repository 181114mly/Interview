//从尾到头打印链表
//题目描述
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
package Nowcoder;
import java.util.Stack;
import java.util.ArrayList;
 class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
   }

   //方法一：使用栈实现
public class PrintLinkedListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        if(listNode==null){
            return list;
        }
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.peek());
            stack.pop();
        }
        return list;
    }
}

//方法二：递归
class PrintLinkedListFromTailToHead2{
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        printListFromTailToHeadCore(list,listNode);
        return list;
    }
    public void printListFromTailToHeadCore(ArrayList<Integer> list,ListNode listNode){
        if(listNode==null){
            return;
        }
        printListFromTailToHeadCore(list,listNode.next);
        list.add(listNode.val);
    }
}
