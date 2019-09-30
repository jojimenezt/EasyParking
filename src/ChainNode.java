/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class ChainNode<String> {
    String element;
    ChainNode<String> next;

    ChainNode(){
        this(null,null);
    }
    
    ChainNode(String element){
        this(element,null);
    }
    
    ChainNode(String element, ChainNode<String> next){
        this.element=element;
        this.next=next;
    }
    
}
