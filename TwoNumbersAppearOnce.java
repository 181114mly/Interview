//数组中只出现一次的数字
/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

//1、将所有数字进行异或，结果为result。
//2、因为数组中有两个只出现一次的数字，所以result不为0。找到result的比特位为1的位数。
//3、将所有数据按照该位是否为1，分为两组。每一组中其余数据异或后为0，只剩下只出现一次的数字。

package Interview;
public class TwoNumbersAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //1、整体异或
        int result=0;
        for(int i=0;i<array.length;i++){
            result^=array[i];
        }
        //2、找比特位为1的位数
        int bit=1;   //00000000 00000000 00000000 00000001
        for(int i=31;i>=0;i--){
            if((result&bit)!=0){
                break;
            }else{
                bit<<=1;
            }
        }
        //3、将数据进行分组。
        for(int i=0;i<array.length;i++){
            if((array[i]&bit)!=0){
                num1[0]^=array[i];
            }else{
                num2[0]^=array[i];
            }
        }
    }
}
