class MyStack {

    Queue<Integer>  mainQueue;
    // Queue<Integer> supportingQueue; 
    public MyStack() {
        mainQueue = new LinkedList();
        // supportingQueue = new LinkedList();
    }
    
    public void push(int x) {
        mainQueue.add(x);
        //reverse the queue till the recently added elements which moves to front automatically
        for (int i = mainQueue.size()-1; i>0;i--) {
            mainQueue.add(mainQueue.poll());
        }
    }
    
    public int pop() {
        return mainQueue.poll();
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