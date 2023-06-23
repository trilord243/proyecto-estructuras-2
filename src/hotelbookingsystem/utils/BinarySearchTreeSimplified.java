/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.utils;

/**
 *
 * @author Gabriel Mena
 */
public class BinarySearchTreeSimplified {
       private NodeSimplified root;
    
 
    
    public boolean exists(int data){
        return exists(this.root, data);
    }
    
    
    public boolean exists(NodeSimplified n, int data){
        if(n==null){
            return false; //No existe el nodo para empezar
        }
        if(n.getData()==data){
            return true;
        }else if (data < n.getData()){
            return exists(n.getLeft(),data);
        }else{
           return exists(n.getRight(),data);
        }
    }
    
    
    public void insert(int data,String name){
        NodeSimplified nodo = new NodeSimplified(data,name);
        if(this.root==null){
            this.root=nodo;
        }
        else{
            this.insert(this.root,data,name);
        }
    
    }
    
    public void insert(NodeSimplified father, int data,String name){
        if(data>father.getData()){
            if(father.getRight()==null){
                father.setRight(new NodeSimplified(data,name));
            }else{
                this.insert(father.getRight(),data,name);
                
            }
        }else{
            if(father.getLeft()==null){
                father.setLeft(new NodeSimplified(data,name));
            }else{
                this.insert(father.getLeft(),data,name);
                
            }
        
        }
    
   }
    
   public void inOrder(NodeSimplified n){
       if(n!=null){
           inOrder(n.getLeft());
           System.out.println(n.getData());
           System.out.println(n.getName());
           inOrder(n.getRight());
       }
   
   } 
   
    public void postOrder(NodeSimplified n){
       if(n!=null){
           postOrder(n.getLeft());
           postOrder(n.getRight());
           System.out.println(n.getData());
           System.out.println(n.getName());
           
       }
    }
    public void preOrder(NodeSimplified n){
        if(n!=null){
           System.out.println(n.getData());
           System.out.println(n.getName());
           preOrder(n.getLeft());
           preOrder(n.getRight());
        }
    
    }
    
    public void inOrder(){
        this.inOrder(this.root);
    }
    
    
    public void preOrder(){
        this.preOrder(this.root);
    }
   public void postOrder(){
        this.postOrder(this.root);
    }
   } 
    

