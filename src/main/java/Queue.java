package src.main.java;

/*
 * Implements array based TrieNode queue with resizing
 * 
 * Author: Jin Kim
 */

public class Queue {
    private TrieNode[] queue;
    private int front;
    private int back;
    private int size;
    private int capacity;
    private int initialCapacity;

    public Queue() {
        this(100);
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        this.initialCapacity = capacity;
        this.queue = new TrieNode[capacity];
        this.front = 0;
        this.back = -1;
        this.size = 0;
    }

    public void enqueue(TrieNode node) {
        checkResize();

        back = (back + 1) % capacity;
        queue[back] = node;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public TrieNode peek() {
        if (size == 0) {
            return null;
        }

        return queue[front];
    }

    public TrieNode dequeue() {
        if (size == 0) {
            return null;
        }

        TrieNode node = queue[front];
        front = (front + 1) % capacity;
        size--;

        checkResize();

        return node;
    }

    private void checkResize() {
        // borrowed resizing logic from previous PA
        if (size == capacity) {
            resize(capacity * 2);
        } else if (size <= capacity / 4 && capacity / 2 >= initialCapacity) {
            resize(capacity / 2);
        }
    }

    private void resize(int cap) {
        TrieNode[] newQueue = new TrieNode[cap];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % capacity];
        }
        queue = newQueue;
        capacity = cap;

        front = 0;
        back = size;
    }
}
