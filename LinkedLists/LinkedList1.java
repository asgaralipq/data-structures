import java.util.*;

class Node{
	int data;
	Node next;

	void createNewNode(int d){
		this.data = d;
		this.next = null;
	}

}

class LinkedList1{

	Scanner sc = new Scanner(System.in);

	static void print(Node head){
		
		Node ptr = head;
		while(ptr!= null){
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.print("Null");
	}
	public static void main(String args[]){

		System.out.println("Hello World");

		Node first = new Node();
		Node second = new Node();
		Node third = new Node();
		first.createNewNode(1);
		second.createNewNode(2);
		third.createNewNode(2);

		Node head = first;
		first.next = second;
		second.next = third;
		
		print(head);
	}
}
