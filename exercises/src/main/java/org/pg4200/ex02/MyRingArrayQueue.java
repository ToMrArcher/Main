package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue implements MyQueue {

    protected Object[] data;

    private int head = -1;
    private int tail = -1;

    public MyRingArrayQueue(){
        this(10);
    }

    public MyRingArrayQueue(int capacity){
        data = new Object[capacity];
    }

    @Override
    public void enqueue(Object value) {
        if(isEmpty()){
            tail = 0;
            head = 0;
        }
        else if(tail == data.length - 1 && !isFull()){
            tail = 0;
        }
        else if(!isFull()){
            tail++;
        }
        else{
            doubleSize();
            tail++;
        }
        data[tail] = value;
    }

    @Override
    public Object dequeue() {
        Object v;
        if(isEmpty()){
            throw new RuntimeException("Fuck off, why you wanna dequeue an empty queue?");
        }
        v = data[head];
        if(head + 1 != data.length){
            head++;
        }
        else{
            head = 0;
        }
        return v;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public int size() {
        if(head < 0){
            return 0;
        }
        else if(tail >= head){
            return tail-head+1;
        }
        return data.length - (head - tail - 1);
    }

    public boolean isFull(){
        if(size() >= data.length){
            return true;
        }
        return false;
    }

    private void doubleSize(){
        int oldSize = data.length;
        Object[] newData = new Object[data.length * 2];
        for(int i = 0; i < oldSize; i++){
            newData[i] = data[i];
        }
        Object[] temp = new Object[oldSize];
        for(int i = head; i < oldSize; i++){

        }
        data = newData;
    }
}
