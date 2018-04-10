/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author ASUS
 */

/*

AVL Tree is a balanced tree (balaced tree is a tree which keeps the heights of both subtrees(i.e. left and right) of almost equal wrt all the nodes).

Q)Why we need balanced tree?
A)In a regular binary tree operations for search, max, min , insert, delete etc operations generally take O(h) ( normally h=log(n) | n = no of nodes in the tree)
time but in a skewed binary tree (shown below)
  ex=>          
                100
                    \
                      110
                          \ 
                            120
                                \
                                  130
                                      \
                                        140

it might take O(n) time when h=n so balancing is used to keep a check on the height of the tree.



*/

class AVLNode{
    
    int data;//,height;
    AVLNode left;
    AVLNode right;
    
    AVLNode(int data){
        this.data=data;
        left=null;
        right=null;
    }
    
}

public class AVL {
    
    private AVLNode root = null;
    
    public void BuiTree(int data){
        root=buildTree(data, root);
        //System.out.println("root.data:"+root.data);
    }
    
    public AVLNode leftRotate(AVLNode root){
        
        AVLNode y = root.right;
        AVLNode t = y.left;
        
        y.left=root;
        root.right=t;
        
        return y;
        
    }
    
    public AVLNode rightRotate(AVLNode root){
        
        AVLNode x = root.left;
        AVLNode t = x.right;
        
        root.left=t;
        x.right=root;
        
        return x;
        
    }
    
    private AVLNode buildTree(int data, AVLNode root){
        if(root==null){
            //System.out.println("root=null");
            root=new AVLNode(data);
            //System.out.println("putting data:"+data);
            return root;
        }
        else{
            if(data>root.data){
                root.right=buildTree(data,root.right);
            }
            if(data<root.data){
                root.left=buildTree(data,root.left);
                //System.out.println(root.left.data);
            }
        }
        
        //root.height = findH(root);
        
        int h = findH(root.left)-findH(root.right);
        
        /* either left-left or left-right */
        if(h>1){
            if(data<root.left.data){
                return rightRotate(root);
            }
            else if(data>root.left.data){
                root.left=leftRotate(root.left);
                return rightRotate(root);
            }
        }
        /* either right-right or right-left */
        else if(h<-1){
            if(data>root.right.data){
                return leftRotate(root);
            }
            if(data<root.right.data){
                root.right=rightRotate(root.right);
                return leftRotate(root);
            }
        }
        
        return root;
    }
    
    public void Traverse(){
        Trav(root);
    }
    
    private void Trav(AVLNode root){
        if(root==null)
            return;
        System.out.println(root.data);
        Trav(root.left);
        Trav(root.right);
    }
    
    private int findH(AVLNode root){
        
        if(root==null)
            return -1;
        int left=findH(root.left);
        int right=findH(root.right);
        return (left>right)?left+1:right+1;
        
    }
    
}
