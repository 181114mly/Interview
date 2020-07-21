//数组中出现次数超过一半的数字
/**
 * 链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?source=relative
 * 来源：牛客网
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
package Nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//方法一 使用Map
public class MoreThanHalfOfTheNumber {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int size=array.length/2;
        for(int i=0;i<array.length;i++){
            int value=map.getOrDefault(array[i],0);
            map.put(array[i],value+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>size){
                return entry.getKey();
            }
        }
        return 0;
    }
}

//方法二：数组排序，判断中间数字出现的次数是否大于一半。若是，则返回中间数值，否则返回0.
class MoreThanHalfOfTheNumber2{
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int halfLength=array.length/2;
        int midNum=array[halfLength];
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==midNum){
                count++;
            }
        }
        if(count>halfLength){
            return midNum;
        }else{
            return 0;
        }
    }
}