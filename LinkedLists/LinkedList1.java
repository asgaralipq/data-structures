import java.util.*;

class Node {
	int data;
	Node next;

	void createNewNode(int d) {
		this.data = d;
		this.next = null;
	}

}

class LinkedList1 {

	Scanner sc = new Scanner(System.in);

	static void print(Node head) {

		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.print("Null");
	}

	static int linkLenght(Node head) {

		Node ptr = head;
		int count = 0;
		while (ptr != null) {
			ptr = ptr.next;
			count++;
		}
		return count;
	}

	static void linkSearch(Node head) {

		Node ptr = head;
		int searchFlag = 0;
		int searchElement = 2;

		while (ptr != null) {
			if(ptr.data == searchElement){
				searchFlag = 1;
				break;
			}
			else{
				ptr = ptr.next;
			}
		}

		if(searchFlag == 0){
			System.out.println("Not Found");
		}else{
			System.out.println("Found");
		}
	}

	static void linkDelete(Node head, int key) {

		Node ptr = head;
		Node prev = null;
		
		if(ptr != null && ptr.data == key){
			head = ptr.next;
			return;
		}

		while (ptr != null) {
			if(ptr.data == searchElement){
				searchFlag = 1;
				break;
			}
			else{
				ptr = ptr.next;
			}
		}

		if(searchFlag == 0){
			System.out.println("Not Found");
		}else{
			System.out.println("Found");
		}
	}
	static Node addNodeAtEnd(Node head, int data) {

		Node current = head;
		Node node = new Node();
		node.createNewNode(data);

		if (current == null) {
			head = node;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
		return head;

	}

	static Node addNodeAtStart(Node head, int data) {

		Node current = head;
		Node node = new Node();
		node.createNewNode(data);

		if (current == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}

		return head;
	}

	public static void main(String args[]) {

		System.out.println("Hello World");
		// Node head = null;
		Node first = new Node();
		Node second = new Node();
		Node third = new Node();
		first.createNewNode(1);
		second.createNewNode(2);
		third.createNewNode(3);

		Node head = first;
		first.next = second;
		second.next = third;

		print(head);

		head = addNodeAtStart(head, 0);
		print(head);

		System.out.println("Length is"+linkLenght(head));

		linkSearch(head);
		
	}
}
