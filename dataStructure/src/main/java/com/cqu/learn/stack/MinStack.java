package com.cqu.learn.stack;


/**
 * @author Feng
 * @date 2019/10/24
 */
public class MinStack implements Stack {

    private Node head = null;
    private Node curr = null;
    private int size = 0;

    public MinStack() {
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void push(int x) {
        if (isEmpty()) {
            head = new Node(null, null, x);
            curr = head;
        } else {
            Node next = new Node(curr, null, x);
            curr.setNext(next);
            curr = next;
        }
        size ++;
    }

    public void pop() {
        if (size != 0) {
            if (size == 1) {
                head = curr = null;
            } else {
                Node tempCurr = curr;
                curr = tempCurr.prev;
                tempCurr.release();
            }
            size --;
        }
    }

    public int top() {
        return curr.data;
    }

    public int getMin() {
        int result = Integer.MAX_VALUE;
        Node p = head;
        while (p != null) {
            result = Integer.min(result, p.data);
            p = p.next;
        }
        return result;
    }

    public void release(Node curr) {
        curr.release();
    }

    private static class Node {
        private Node prev;
        private Node next;
        private int data;

        @SuppressWarnings("unused")
		public Node() {
        }

        public Node(Node prev, Node next, int data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }

        @SuppressWarnings("unused")
		public Node getPrev() {
            return prev;
        }

        @SuppressWarnings("unused")
		public void setPrev(Node prev) {
            this.prev = prev;
        }

        @SuppressWarnings("unused")
		public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @SuppressWarnings("unused")
		public int getData() {
            return data;
        }

        @SuppressWarnings("unused")
		public void setData(int data) {
            this.data = data;
        }

        public void release() {
            this.prev = null;
            this.next = null;
            this.data = Integer.MAX_VALUE;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
