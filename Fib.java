//斐波那契数列
/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */
package Nowcoder;

import java.util.HashMap;
import java.util.Map;
//方法一：迭代
public class Fib {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int first = 1;
        int second = 1;
        //如果n=1或者n=2时，third=1.
        int third = 1;
        while (n > 2) {
            third = first + second;
            first = second;
            second = third;
            n--;
        }
        return third;
    }
}
//方法二：递归
class Fib2 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
//方法三：Map剪枝重复计算，降低控件复杂度。
class Fib3 {
    private Map<Integer, Integer> map = new HashMap<>();
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int ppre = 0;
        if (map.containsKey(n - 2)) {
            ppre = map.get(n - 2);
        } else {
            ppre = Fibonacci(n - 2);
            map.put(n - 2, ppre);
        }
        int pre = 0;
        if (map.containsKey(n - 1)) {
            pre = map.get(n - 1);
        } else {
            pre = Fibonacci(n - 1);
            map.put(n - 1, pre);
        }
        return ppre + pre;
    }
}
