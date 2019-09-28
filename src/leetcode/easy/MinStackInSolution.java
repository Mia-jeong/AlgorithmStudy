package leetcode.easy;

import java.util.Stack;

public class MinStackInSolution {
    Stack<Integer> main = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
       main.push(x);
       if(min.isEmpty() || min.peek() <= x) min.push(x);
    }

    public void pop() {
        if(main.pop().equals(min.peek())) min.pop();
    }

    public int top() {
        return main.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
