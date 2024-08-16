//import java.util.LinkedList;

import java.util.LinkedList;

public class LList{
    public static class Node{
        int data;
        Node next;//refrence variable

        public Node (int data){
            this.data = data;//constructor
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add first

    public void addFirst(int data){
        //step 1 - create new node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        
        //step 2
        newNode.next = head;//link kiya hai ek node se next node ko
        //step3
        head=newNode;
    }

    public void addLast(int data){
        Node newnNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newnNode;
            return;
        }
        tail.next=newnNode;
        tail = newnNode;


    }
    public void print(){
        if(head==null){
            System.out.print("ll is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

    }
    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        size++;
        Node newNode=new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        //i=idx-1; temp->prev
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){
        int val = head.data;
        head = head.next;
        return val;
    }

    public int removeLast() {
        if(size==0){
            System.out.println("ll is empty");
        }else if(size==1){
            int val = head.data;
            head=tail=null;
            size =0;
            return val;
        }
        //prev : i + size-2
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }

        int val = prev.next.data;//tail data
        prev.next= null;
        tail=prev;
        size--;
        return val;
    }
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;

        while(temp!=null){
            if(temp.data==key){//key found
            return i;
            }
            temp = temp.next;
            i++;

        }
        //key not found-
        return -1;
    }
    public int helper(Node head , int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx==-1){
            return-1;
        }
        return idx+1;

    }
    public int recSearch(int key){
        return helper(head, key);

    }

    public void reverse(){
        Node prev = null;
        Node curr= tail = head;
        Node next;

        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
            
        }
        head= prev;


    }
    public void deleteNthfromEnd(int n){
        //calclualte size
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }
        if(n==sz){//if i want to delete my headd itself
            head = head.next;
            return;
        }

        int i=1;
        int iToFind = sz-n;
        Node prev= head;
        while(i< iToFind){
            prev=prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return; 

    }
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next != null) {
            slow = slow.next;//+1
            fast = fast.next.next;//+2
            
        }
        return slow;

    }

    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        //1stem - find mid
        Node midNode = findMid(head);

        //step 2- reverse second half
        Node prev=null;
        Node curr= midNode;
        Node next;
        while (curr !=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
            
        }
        Node right= prev;
        Node left = head;

        //step 3- compare 1 & 2half
        while (right!=null) {
            if(left.data != right.data){
                return false;
            }
              left = left.next;
              right = right.next;
        }
        return true;
    }
     public static boolean isCycle(){
        Node slow = head;
        Node fast  = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;//+1
            fast = fast.next.next;//+2
            if(slow==fast){
                return true;
            }
        }
        return false;

        
     }
     public static void removeCycle(){
        //detetc cycle
        Node slow= head;
        Node fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        //find meeting point 
        slow =head;
        Node prev = null;//iisme lasat node store ho jayega/
        while(slow!=fast){
           prev = fast;
           slow = slow.next;
           fast = fast.next;  
        }
        //remove cycle - fast.next = null;
        prev.next = null;
     }
     //Merge sort
        private Node getMid(Node head){
            Node slow = head;
            Node fast = head.next;
            while (fast !=null && fast.next !=null) {
                slow = slow.next;
                fast = fast.next.next;

                
            }
            return slow; //mid
        }

        private Node merge(Node head1 , Node head2){
            Node mergedLL = new Node(-1);
            Node temp = mergedLL;

            while (head1 != null && head2 !=null) {
                if(head1.data <= head2.data){
                    temp.next = head1;
                    head1 = head1.next;
                    temp = temp.next;
                }else{
                    temp.next = head2;
                    head2 = head2.next;
                    temp =  temp.next;
                }
            }
        
            while (head1 !=null) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            while (head2 !=null) {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            return mergedLL;
        }
      
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
    
        //RS LS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //Merge
        return merge(newLeft,newRight);
    }
  
     public void zigZag(){
        //find mid
        
            Node slow = head;
            Node fast = head.next;
            while (fast !=null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;
        

        // reverse 2nd half
         Node curr = mid.next;
         mid.next = null;
         Node prev = null;
         Node next;

         while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
         }
         Node left = head;
         Node right = prev;
         Node nextL,nextR;
        //alternate merge
        while (left !=null && right !=null) {
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;
            
            left = nextL;
            right = nextR;
        }
    }
       

    
    public static void main(String[] args) {
        LList ll = new LList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

      ll.print();
      ll.zigZag();
      ll.print();


        //ll.print();
       // ll.head = ll.mergesort(ll.head);
        // 5-4-3-2-1


        //LList ll = new LList();
       
        //ll.addLast(1);
        
        //ll.addLast(3);
       
        //ll.addLast(2);
        
        //ll.addLast(3);

        //ll.addLast( 1);
        
        //ll.print();
        //System.out.println(ll.checkPalindrome());
       // ll.reverse();
     // ll.deleteNthfromEnd(3);
      //  ll.print();

    

       // System.out.println(ll.recSearch(3));
       // System.out.println(ll.recSearch(10));

       // ll.removeFirst();
        //ll.print();

        //ll.removeLast();
       // ll.print();
        
       
        //ll 1 2  3 
       //System.out.println(ll.size);
     //  head = new Node(1);
      // Node temp = new Node(2);
      // head.next = temp;
      // head.next.next = new Node(3);
      // head.next.next.next = temp;
       //1->2->3->2

      // System.out.println(isCycle());
      // removeCycle();
      // System.out.println(isCycle());
    }
    
}