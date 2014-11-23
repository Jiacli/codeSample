import java.util.Stack;


public class LeetCode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinStack st = new MinStack();
        
        st.push(512);
        st.push(-1024);
        st.push(-1024);
        st.push(512);
        st.pop();
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());

    }
    
    

}

class MinStack {
    
    // based on arrayList
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    int min = Integer.MAX_VALUE;
    
    public void push(int x) {
        stack.push(x);
        
        if (x <= min) {
            minStack.push(x);
            min = x;
        }
    }


    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
            if (minStack.isEmpty())
                min = Integer.MAX_VALUE;
            else
                min = minStack.peek();
        }
        
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
