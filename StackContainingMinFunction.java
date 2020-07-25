//包含min函数的栈
/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
package Interview;
import java.util.Stack;
public class StackContainingMinFunction {
    //数据栈，保存数据
    Stack<Integer> data_stack=new Stack<>();
    //辅助栈，保存当前数据中的最小值
    Stack<Integer> min_stack=new Stack<>();
    public void push(int node) {
        //如果辅助栈为空或者辅助栈的栈顶元素大于新数据，新数据入辅助栈
        if(min_stack.isEmpty()||min_stack.peek()>node){
            min_stack.push(node);
       //如果辅助栈非空并且辅助栈的栈顶元素小于等于新数据，栈顶元素入辅助栈
        }else{  //!min_stack.isEmpty()&&min_stack.peek()<=node
            min_stack.push(min_stack.peek());
        }
        data_stack.push(node);
    }

    public void pop() {
        //两个栈都出栈
        data_stack.pop();
        min_stack.pop();
    }

    public int top() {
        //返回数据栈栈顶元素
        return data_stack.peek();
    }

    public int min() {
        //返回数辅助栈顶元素
        return min_stack.peek();
    }
}
