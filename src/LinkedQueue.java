/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Estudiante
 */
public class LinkedQueue<T> implements Queue<T> {
    protected ChainNode<T> front;
    protected ChainNode<T> rear;
    
    public LinkedQueue(){
        front=rear=null;
    }
    
    public boolean isEmpty(){
        return front==null;
    }
    
    public T getFrontElement(){
        return isEmpty() ? null:front.element;
    }
    
    public T getRearElement(){
        return isEmpty() ? null:rear.element;
    }
    
    public void put(T theElement){
        ChainNode<T> p=new ChainNode<T>(theElement,null);
        if (front==null) front=p;
        else rear.next=p;
        rear=p;
    }
    
    public T remove(){
        if (isEmpty()) return null;
        T frontElement=front.element;
        front=front.next;
        if (isEmpty()) rear =null;
        return frontElement;
    }
}
