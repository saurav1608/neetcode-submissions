class MinStack {

    private Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack();    
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0l);
            min = val;
        } else {
            stack.push((long)val - min);
            if (val < min) {
                min = val;
            }
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        long pop = stack.pop();
        if (pop < 0) min = min - pop;    
    }
    
    public int top() {
        long top = stack.peek();
        if (top < 0) return (int)min;
        else return (int) (top + min);
    }
    
    public int getMin() {
        return (int) min;  
    }
}
