//最小的K个数
/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
package Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class TheMinimumNumberOfK {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(input.length==0||k==0||k>input.length){
            return result;
        }
        //将优先队列元素按照从大到小（逆序）排序
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for(int i=0;i<input.length;i++){
            if(i<k){
                //将前K个数据入队列
                queue.offer(input[i]);
            }else{
                //元素个数大于K。将当前元素和队列的队首元素（即最大数）进行比较。
                //如果当前元素小于队首元素，进行更新，最大数出队列，当前元素入队列。
                if(input[i]<queue.peek()){
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }
        //将前K小放到ArrayList中，返回结果result。
        for(int i=0;i<k;i++){
            result.add(queue.poll());
        }
//        int[] arr=new int[k];
//        for(int i=0;i<k;i++){
//           arr[i]=queue.poll();
//        }
//        for(int i=0;i<k;i++){
//            result.add(arr[k-1-i]);
//        }
        return result;
    }
    public static void main(String[] args){
        int[] arr={4,5,1,6,2,7,3,8};
       ArrayList<Integer> list= GetLeastNumbers_Solution(arr,4);
        System.out.println(list);
    }
}
