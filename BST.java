
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author mukul
 */

import java.util.*;

class Node{
    int data;
    Node right;
    Node left;
    
    Node(int data){
        this.data=data;
        right=null;
        left=null;
    }
    
}

public class BST {
    
    private Node head=null;
    private Node head2=null;
    
    public void addData(int data){
        head=add(head,data);
    }
    
    public Node add(Node ptr,int data){
        
        int val=0;
        
        //System.out.println("Adding data="+data);
        
        if(ptr==null){
            ptr=new Node(data);
            return ptr;
        }
        else if(data<ptr.data){
            ptr.left=add(ptr.left,data);
        }
        else if(data>ptr.data){
            ptr.right=add(ptr.right,data);
        }
        return ptr;
    }
    
    public void createRandTree(){
        head2=new Node(20);
        head2.left=new Node(8);
        head2.right=new Node(22);
        head2.left.left=new Node(5);
        head2.left.right=new Node(3);
        head2.right.right=new Node(25);
        head2.right.left=new Node(4);
        head2.left.right.left=new Node(10);
        head2.right.left.right=new Node(14);
    }
 
    Boolean b = false;
    
    public boolean Search(int ele){
        Srch(head,ele);
        return b;
    }
    
    public void Srch(Node Root,int ele){
        
        
        if(Root==null){
            b=false;
        }
        else if(ele>Root.data){
            Srch(Root.right,ele);
        }
        else if(ele<Root.data){
            Srch(Root.left,ele);
        }
        else if(ele==Root.data){
            b=true;
        }
    }
    
    private void MakeNonBST(){
        head2=new Node(15);
        head2.left=new Node(10);
        head2.right=new Node(20);
        head2.left.right=new Node(18);
        head2.right.left=new Node(19);
    }
    
    public void min(){
        System.out.println(FindMin(head));
    }
    
    public int FindMin(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root.data;
    }
    
    public void max(){
        System.out.println(FindMax(head));
    }
    
    public int FindMax(Node root){
        while(root.right!=null){
            root=root.right;
        }
        return root.data;
    }
    
    public void height(){
        System.out.println(Fheight(head));
    }
    
    int lh=0;
    int rh=0;
    
    public int Fheight(Node root){
        if(root.left==null && root.right==null){
            return 0;
        }
        if(root.left!=null){
        lh=Fheight(root.left)+1;
        System.out.println("height of left subtree at "+root.data+":"+lh);
        }
        if(root.right!=null){
        rh=Fheight(root.right)+1;
        System.out.println("height of right subtree at "+root.data+":"+rh);
        }
        return (lh>rh)?lh:rh;
    }
    
    public void traverse(){
        traverseTree(head);
    }
    
    private void traverseTree(Node root){
        
        //System.out.println(root.data);
        
        System.out.println(root.data);
        if(root.left!=null){
        //System.out.println("left dun dun dun dun");
        traverseTree(root.left);}
        if(root.right!=null){
        //System.out.println("right dun dun dun dun");
        traverseTree(root.right);}
        
        /*
        Code below traverses and prints data in incrasing order
        */
        /*
        if(root.left!=null){
        traverseTree(root.left);}
        System.out.println(root.data);
        if(root.right!=null){
        traverseTree(root.right);}
        */
        /*
        Code below traverses and prints data in decresing order
        */
        
        /*if(root.right!=null){
        traverseTree(root.right);}
        System.out.println(root.data);
        if(root.left!=null){
        traverseTree(root.left);}
        */
        
        /*
        code below prints the data of each node the last time it travels the node
        */
        
        /*if(root.right!=null){
        traverseTree(root.right);}
        if(root.left!=null){
        traverseTree(root.left);}
        System.out.println(root.data);*/
        
}
    
    public void lot(){
       // LevelOTrav(head);
    }
    
    /*private void LevelOTrav(Node root){
        
        if(root==null){
            return;
        }
        
        queue<Node> q = new queue<Node>();
        
        q.enqueue(root);
        
        while(!q.isEmpty()){
            
            Node Curr = q.peekF();
            System.out.println(Curr.data);
            if(Curr.left!=null){
                q.enqueue(Curr.left);
            }
            if(Curr.right!=null){
                q.enqueue(Curr.right);
            }
            q.dequeue();
            
        }
        
    }
    */
    public void CheckBST(){
        //Boolean var=cbst(head,-((int)Math.pow(2,31)-1),(int)Math.pow(2,31)-1);
        
        MakeNonBST();
        
        System.out.println(head2.data);
        
        Boolean var=cbst(head2,-((int)Math.pow(2,31)),(int)Math.pow(2,31)-1);
        
        if(var==true){
            System.out.println("Satya vachan");
        }
        else{
            System.out.println("No Bro");
        }
    }
    
 
    
    private Boolean cbst(Node root,int min, int max){
        
        if(root==null){
            return true;
        }
        
        if(root.data<max && root.data>min && cbst(root.left,min,root.data) && cbst(root.right,root.data,max)){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    
    /*
    
    the methods below(LeftView,leftView,findd) finds the leftview of a binary search tree using recursion 
    
    the logic is to keep count of depth and print the leftmost element at any current depth
    
    */
    
    public void LeftView(){
        //System.out.println("in LeftView");
        createRandTree();
        leftView(head,0);
    }
    
    int ld=0;
    int rd=0;
    int maxd=-1;
    
    Node[] n = new Node[100];
    
    /*
    logic of the leftView of a binary search tree is in the method below
    */
    
    private void leftView(Node root,int depth){
        
        System.out.println("ab a gaye leftView me");
        
        if(root==null){
            return;
        }
        
        System.out.println("root.data="+root.data);
        
        //System.out.println("abhi depth:"+depth+" maxdepth:"+maxd);
        
        if(depth>maxd){
            System.out.println(root.data);
            maxd=depth;
        }
        if(root.left!=null){
        leftView(root.left,findd(root.left));
        }
        if(root.right!=null){
        leftView(root.right,findd(root.right));
        }
        
        
        
    }
    
    
    /*
    the method below returns the depth to the method leftView
    */
    
    private int findd(Node temp){
        //System.out.println("data of root node:"+head.data);
        //System.out.println("calling with data:"+temp.data);
        Node node = head;
        Node tempval=null;
        int depth=0;
        while(node.data!=temp.data){
            //System.out.println("Inside While\nNODE.DATA="+node.data+" temp.data="+temp.data);
            //System.out.println("at depth:"+depth);
            if(node.data>temp.data){
                //System.out.println("left for data:"+temp.data);
                tempval=node.left;
            }
            if(node.data<temp.data){
                //System.out.println("right for data:"+temp.data);
                tempval=node.right;
            }
            node=tempval;
            depth++;
        }
        //System.out.println("depth="+depth+" for temp.data="+temp.data);
        return depth;
    }
    
    /*methods below givea thw leftview by taking Root node as an argument*/
    
    public void LeftVOArg(){
        LeftViewOArg(head,0);
    }
    
    int maxdep = -1;
    
    private void LeftViewOArg(Node root,int level){
        if(root==null){return;}
        if(level>maxdep){
            System.out.println(root.data);
            maxdep=level;
        }
        LeftViewOArg(root.left,level+1);
        LeftViewOArg(root.right,level+1);
    }
    
    
    public void del(int val){
        System.out.println("before deletion of:"+val);
        traverse();
        deleteNode(head,val);
        System.out.println("after deletion of:"+val);
        traverse();
    }
    
    Node tmpVal=null;
    
    public void deleteNode(Node root, int val){
        
        if(root==null){return;}
        
        if(val>root.data){
            tmpVal=root;
            deleteNode(root.right,val);
        }
        if(val<root.data){
            tmpVal=root;
            deleteNode(root.left,val);
        }
        if(val==root.data){
            if(root.left==null && root.right==null){
                tmpVal.left=null;
                tmpVal.right=null;
            }
        }
        if(root.left==null && root.right!=null){
            if(tmpVal.data>root.data){tmpVal.left=root.right;}
            if(tmpVal.data<root.data){tmpVal.right=root.right;}
        }
        if(root.left!=null && root.right==null){
            if(tmpVal.data>root.data){tmpVal.left=root.left;}
            if(tmpVal.data<root.data){tmpVal.right=root.left;}
        }
        if(root.left!=null && root.right != null){
            if(tmpVal.right==root){
                tmpVal.right=root.left;
                Node NewNode = root.left;
                while(NewNode.right!=null){
                    NewNode=NewNode.right;
                }
                NewNode.right=root.right;
            }
            if(tmpVal.left==root){
                tmpVal.left=root.left;
                Node NewNode = root.left;
                while(NewNode.right!=null){
                    NewNode=NewNode.right;
                }
                NewNode.right=root.right;
            }
            }
        }
    
    /*
    methods below gives bottom view of a Binary tree
    */
    
    int cDep = 0;
    int minVal=0;
    int maxVal=0;
    public void BottomView(){
        //createRandTree();
        BV(head,0,0);
        travForBV();
    }
    
    private void travForBV(){
        for(int i=minVal;i<=maxVal;i++){
            System.out.println(hm.get(i));
        }
    }
    
    HashMap hm =new HashMap();
    
    public void BV(Node root, int cDep, int horD){
        System.out.println("for "+root.data+" cDep="+cDep+" horD="+horD);
        if(horD>maxVal){
            maxVal=horD;
        }
        if(horD<minVal){
                minVal=horD;
            }
        if(hm.get(cDep)!=null && (int)hm.get(cDep)<=cDep){
            System.out.println("putting "+horD+" as key and "+cDep+" as value");
            hm.put(horD, root.data);
        }
        if(hm.get(cDep)==null){
            hm.put(horD, root.data);
        }
        ++cDep;
        if(root.left!=null){
            System.out.println("calling left for:"+root.data);
            BV(root.left,cDep,horD-1);}
        if(root.right!=null){
            System.out.println("calling right for:"+root.data+" horD="+horD);
            BV(root.right,cDep,horD+1);}
    }
    
    /*
    following method is to traverse a tree using stack
    */
    
    public void trav(){
        
        System.out.println("inside trav");
        
        Stack<Node> s = new Stack<Node>();
        Node tmp=null;
        s.add(head);
        tmp=head;
        int mBool=0;
        
        System.out.println("tmp.data="+tmp.data);
        
        while(!s.isEmpty()){
            if(mBool==1){
                s.pop();
                tmp=s.peek();
                mBool=0;
            }
            while(tmp!=null){
                System.out.println("adding data tmp.data="+tmp.data);
                tmp=tmp.left;
                s.add(tmp);
            }
            
            if(s.peek()==null && !s.isEmpty()){
                System.out.println("inside another if");
                s.pop();
                //System.out.println(tmp.data);
                tmp=s.peek();
                tmp=tmp.right;
                s.add(tmp);
                if(tmp==null){
                    s.pop();
                }
                mBool=1;
            }
        }
        
    }
    
    /*
    
    methods below are to merge two trees
    
    */
    
    public void merge2Tree(){
        m2t(head,head2);
    }
    
    private void m2t(Node root1, Node root2){
        
    }
    
    /*
    Below 2 methods find the nth smallest element in a bst in O(n) where n=no of elements in the tree
    */
    
    int nth=0;
    
    public void nthSmallestEle(int n){
        nth=n;
        nthSE(head);
    }
    
    private void nthSE(Node root){
        if(nth>=0){
        System.out.println("inside method and root.data="+root.data+" nth="+nth);
        if(root.left!=null){
            nthSE(root.left);
        }
        nth--;
        if(nth==0){
            System.out.println(root.data);
        }
        if(root.right!=null){
            nthSE(root.right);
        }
    }
    }
    
    }
    

