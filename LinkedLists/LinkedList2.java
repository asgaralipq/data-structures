import java.util.*;

class NodeDLL{
    int data;
    Node next;
    Node prev;

    void createNewNode(int d){
        this.data = d;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList2{
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        NodeDLL node = new NodeDLL();
        node.createNewNode(1);

        System.out.println(node.data);
    }
}