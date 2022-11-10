package seminar_4;

import java.util.Stack;

public class ImplementQueueUsingStacks232 {

    // 232. Implement Queue using Stacks
    class MyQueue {
        Stack<Integer> input;
        Stack<Integer> output;
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if (output.isEmpty()){
                while (!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()){
                while (!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
