import java.util.Stack;
class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    public void pop() {
        if (!mainStack.isEmpty()) {
            if (mainStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            mainStack.pop();
        }
    }
    public int top() {
        return mainStack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(14);
        minStack.push(8);
        minStack.push(7);
        minStack.push(11);
        minStack.push(3);

        System.out.println("Minimum Element: " + minStack.getMin());
        minStack.pop();
        System.out.println("Top Element: " + minStack.top());
        System.out.println("Minimum Element: " + minStack.getMin());
    }
}
