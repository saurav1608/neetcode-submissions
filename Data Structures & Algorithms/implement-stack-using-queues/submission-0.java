class MyStack {

    Queue<Integer>  mainQueue;
    Queue<Integer> supportingQueue; 
    public MyStack() {
        mainQueue = new LinkedList();
        supportingQueue = new LinkedList();
    }
    
    public void push(int x) {
        while (!mainQueue.isEmpty()) {
            supportingQueue.add(mainQueue.remove());
        }
        mainQueue.add(x);
        while (!supportingQueue.isEmpty()) {
            mainQueue.add(supportingQueue.remove());
        }
    }
    
    public int pop() {
        return mainQueue.remove();
    }
    
    public int top() {
        return mainQueue.peek();
    }
    
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */