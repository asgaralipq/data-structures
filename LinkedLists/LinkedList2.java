import java.util.*;

class NodeDLL{
    int data;
    NodeDLL next;
    NodeDLL prev;

    void createNewNode(int d){
        this.data = d;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList2{
    Scanner sc = new Scanner(System.in);

    static NodeDLL addNodeAtBegin(NodeDLL head){
        NodeDLL ptr = head;
        NodeDLL newNode = new NodeDLL();
        newNode.createNewNode(0);

        if(ptr == null){
            head = newNode;
            return head;
        }
        else{
            ptr.prev = newNode;
            newNode.next = ptr;
            head = newNode;
            return head;
        }
    }


    static NodeDLL addNodeAtEnd(NodeDLL head){
        NodeDLL ptr = head;
        // NodeDLL prev = null;
        NodeDLL newNode = new NodeDLL();
        newNode.createNewNode(4);

        if(ptr == null){
            head = newNode;
            return head;
        }
        else{
            while(ptr.next != null){
                ptr = ptr.next;
            }
        }
        ptr.next = newNode;
        newNode.prev = ptr;

        return head;
    }


    static void print(NodeDLL head){
        NodeDLL ptr = head;
        System.out.println("Normal");

        while(ptr != null){
            System.out.print(ptr.data+"-->");
            ptr = ptr.next;
        }

        System.out.println("Null");
    }

    static void printReverse(NodeDLL head){
        NodeDLL ptr = head;
        // int count = 0;
        System.out.println("Reverse");
        // System.out.print(ptr.data+" Before");
        while(ptr.next != null){
            ptr = ptr.next;
            // System.out.println(count++);
        }
        // System.out.print(ptr.data+" After");
        
        while(ptr!= null){
            System.out.print(ptr.data+"-->");
            ptr = ptr.prev;
        }

        System.out.println("Null");
    }

    public static void main(String[] args){

        // NodeDLL head = null;
        NodeDLL first = new NodeDLL();
        NodeDLL second = new NodeDLL();
        NodeDLL third = new NodeDLL();
        first.createNewNode(1);
        second.createNewNode(2);
        third.createNewNode(3);

        NodeDLL head = first;
        first.next = second;
		second.next = third;
        second.prev = first;
        third.prev = second;

        head = addNodeAtEnd(head);
        // System.out.println(first.data);
        print(head);
        printReverse(head);

        head = addNodeAtBegin(head);
        // System.out.println(first.data);
        print(head);
        printReverse(head);
    }
}