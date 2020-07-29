//和为s的正整数序列
/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
package Interview;
import java.util.ArrayList;

public class SequenceOFPositiveNumberWithSumOfS {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result=new ArrayList<ArrayList<Integer> >();
        if(sum==0){
            return result;
        }
        int left=1;
        int right=2;
        while(left<right){
            //注意：1、项数为right-left+1
            int s=(left+right)*(right-left+1)/2;
            //扩大区间
            if(s<sum){
                right++;
            }
            //缩小区间
            else if(s>sum){
                left++;
            }
            else if(s==sum){
                //2、创建list必须处于if语句中,否则不符合要求。
                //3、left和right不仅代表下标，还代表数值
                //4、向result添加list之后，left++.
                ArrayList<Integer> list=new ArrayList<Integer>();
                for(int i=left;i<=right;i++){
                    list.add(i);
                }
                result.add(list);
                left++;
            }
        }
        return result;
    }
}
