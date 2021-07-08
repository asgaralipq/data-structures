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
		//Node head = null;
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
	}
}
