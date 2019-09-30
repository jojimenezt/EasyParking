/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

        
        
public class ArrayStack<T> implements Stack<T>{
    int top;
    T[] stack;
    

    public ArrayStack(int iniCapacity) {
        if(iniCapacity < 1) throw new IllegalArgumentException ("Initial Capacity must be >=1");
        
        stack = (T[]) new Object[iniCapacity];
        
        top=-1; 
    }

    public ArrayStack() {
        this(10);
    }
    
    @Override
    public boolean isEmpty(){
        return top < 0;
    }
    
    @Override
    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return stack[top];      
    }
    
    @Override
    public void push(T element){
        if(top == stack.length-1){
            T[] old = stack;
            stack = (T[]) new Object[2*stack.length];
            System.arraycopy(old, 0,stack, 0, old.length);
        }
        
        top++;
        stack[top] = element;
    }
    
    @Override
    public T pop(){
        if(isEmpty()) throw new EmptyStackException();
        T topElement = stack[top];
        stack[top] = null;
        top--;
        return topElement;
    }
    
    
    public ArrayStack<T> invert(){
        ArrayStack arr2 = new ArrayStack<T>();
        
        while(!this.isEmpty()){
            arr2.push(this.pop());
        }
        
        return arr2;
    }
    
}
