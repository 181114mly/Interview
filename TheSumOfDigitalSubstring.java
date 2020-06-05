package Interview;
//字符串中数字子串求和
import java.util.Scanner;

/**
 * 题目：
 * 给定一个字符串str，求其中全部数字串所代表的数字之和。
 *
 * 要求：
 * 1.忽略小数点,例如"A1.3",其中包含两个数字1和3.
 * 2.考虑'-'，如果有连续奇数个，则为负，如果有连续偶数个时，就为正数。
 * 例如：“A-1BC--12”,其中包含两个数字-1和12.
 *
 * 举例：
 * str="A1CD2E33",返回36
 * str="A-1B--2C--D6E",返回7
 */

public class TheSumOfDigitalSubstring {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(theSumOfDigitalSubstring(str));
    }
    private static int theSumOfDigitalSubstring(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        //子符串中数字之和
        int sum=0;
        //字符串中每一位的值
        int num=0;
        //符号位，初始情况下为正
        boolean flag=true;
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            //cur表示第i位的数字值
            int cur=arr[i]-'0';
            //表示当前的位数是数字
            if(cur>=0&&cur<=9){
                num=num*10+(flag?cur:-cur);
            }
            //当前位数不是数字，需要将num加到sum上
            else{
                sum+=num;
                //num需要清0，防止再num=num*10+(flag?cur:-cur);出错
                num=0;
                //表示当前位是'-'字符
                if(arr[i]=='-'){
                    //需要判断当前位是不是第一个字符,或者当前位的前一位是否为'-'字符
                    if(i==0||arr[i-1]=='-'){
                        flag=!flag;
                    }
                    //如果当前位不是第一位，或者当前位的前一位不是'-'，表示则将falg置为false,
                    else{
                        flag=false;
                    }
                }//end if(arr[i]=='-')
                else{
                    flag=true;
                }
            }//end else 当前位数不是数字字符
        }//end for
        //如果s="123",但是累加求和sum在非数字字符中，为了防止数字累加失败，应该在for循环外加上 sum+=num;
        sum+=num;
        return sum;
    }
}
