package Interview;
//用两个栈实现队列
import java.util.Stack;

/**
 * 进队列时,要判断栈B是否为空。如果栈B不为空，则需把栈B中的所有元素入栈A，再压入x元素；栈B为空，直接压入x元素。
 * 出队列时，如果栈A不为空,则需把栈A中的所有元素入栈B；如果栈A为空，直接弹出栈顶元素。
 */
public class ImplementQueueByTwoStacks {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    //入队列
    public void push(int node) {
        while (!B.isEmpty()) {
            A.push(B.pop());
        }
        A.push(node);
    }

    //出队列
    public int pop() {
        //当栈A和栈B同时为空时，抛出异常。
        if (A.isEmpty() && B.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        while (!A.isEmpty()) {
            B.push(A.pop());
        }
        return B.pop();
    }

    //获取队首元素
    public int peek() {
        if (A.isEmpty() && B.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        while (!A.isEmpty()) {
            B.push(A.pop());
        }
        return B.peek();
    }

    //判断队列是否为空
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
