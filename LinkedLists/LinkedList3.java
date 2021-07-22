class NodeDLL2{
    int data;
    NodeDLL2 next;
    NodeDLL2 prev;

    NodeDLL2(int d){
        this.data = d;
        this.next = null;
        this.prev = null;
    }
}

public class LinkedList3 {

    public static void printDLL(NodeDLL2 head){
        NodeDLL2 ptr = head;

        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr = ptr.next;
        }
        System.out.print("Null");
    }

    public static NodeDLL2 reverseDLL(NodeDLL2 head){
        NodeDLL2 temp = null;
        NodeDLL2 ptr = head;

        while(ptr != null){
            temp = ptr.prev;
            ptr.prev = ptr.next;
            ptr.next = temp;
            ptr = ptr.prev;
        }

        if(temp!=null){
            head = temp.prev;
        }

        return head;
    }

    public static NodeDLL2 mergeKSortedNodes(NodeDLL2 head){
        if(head == null || head.next == null){
            return head;
        }

        NodeDLL2 ptr = head;

        for(NodeDLL2 i = ptr.next; i!=null; i = i.next){
            NodeDLL2 j = i;
            while(j.prev != null && j.data < j.prev.data){
                NodeDLL2 temp1 = j.prev.prev;
                NodeDLL2 temp2 = j.prev;
                NodeDLL2 temp3 = j.next;
                j.prev.next = temp3;
                j.prev.prev = j;
                j.next = temp2;
                j.prev = temp1;
                if(temp1 != null){
                    temp1.next = j;
                }
                if(temp3 != null){
                    temp3.prev = temp2; 
                }
            }

            if(j.prev == null){
                ptr = j;
            }
        }
        return ptr;
    }
    public static void main(String[] args){


        NodeDLL2 first = new NodeDLL2(3);
        NodeDLL2 second = new NodeDLL2(2);
        NodeDLL2 third = new NodeDLL2(6);
        NodeDLL2 fourth = new NodeDLL2(12);
        NodeDLL2 fifth = new NodeDLL2(56);
        NodeDLL2 sixth = new NodeDLL2(8);

        first.next = second;
        second.next = third;
        second.prev = first;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;
        fifth.next = sixth;
        sixth.prev = fifth;

        
        NodeDLL2 head = first;
        printDLL(head);
        // System.out.println();
        // printDLL(reverseDLL(head));

        head = mergeKSortedNodes(head);
        printDLL(head);
    }
    
}
