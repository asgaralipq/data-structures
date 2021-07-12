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

	static Node linkShare(Node head) {

		Node ptr = head;
		int index = -1;

		if (index > linkLenght(ptr)-1 || index < 0) {
			System.out.println("Index doesn't exist");
			return ptr;
		}
		else {
			for (int i = 0; i < index; i++){
				ptr = ptr.next;
			}
			return ptr;
		}
	}

	static Node linkShareEnd(Node head) {

		Node ptr = head;
		int index = 3;

		if (index > linkLenght(ptr)-1 || index < 0) {
			System.out.println("Index doesn't exist");
			return ptr;
		}
		else {
			for (int i = linkLenght(ptr); i > index; i--){
				ptr = ptr.next;
			}
			return ptr;
		}
	}

	static void linkCount(Node head){
		Node ptr = head;
		int count = 0;
		int countElement = 2;

		while(ptr != null){
			if(countElement == ptr.data){
				count++;
			}
			ptr = ptr.next;
		}
		System.out.println("Count is "+count);
	}

	static void linkMinMax(Node head){
		Node ptr = head;
		int min = ptr.data;
		int max = ptr.data;

		while(ptr != null){
			if(ptr.data < min){
				min = ptr.data;
			}

			if(ptr.data > max){
				max = ptr.data;
			}

			ptr = ptr.next;
		}

		System.out.println("Min is: "+min+" Max is: "+max);
	}

	static Node linkDelete(Node head, int key) {

		Node ptr = head;
		Node prev = null;
		
		System.out.println("Inside");
		print(ptr);

		System.out.println("-----"+ptr.data+"-------"+key+"------");

		if(ptr != null && ptr.data == key){
			head = ptr.next;
			return head;
		}

		while (ptr != null && ptr.data != key) {
			prev = ptr;
			ptr = ptr.next;
		}

		if(ptr == null){
			return head;
		}

		prev.next = ptr.next;
		System.out.println("Inside");
		print(head);
		return head;

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

	static Node linkCircular(Node head){

		Node ptr = head;

		while(ptr.next != null){
			ptr = ptr.next;
		}
		ptr.next = head;

		return head;
	}

	static boolean linkPaldindrome(Node head){
		Node ptr = head;
		Node ptr2 = head;
		boolean checkPalin = false;
		int i = 0;

		Stack<Integer> stack = new Stack<Integer>(); 

		while(ptr != null){
			stack.push(ptr.data);
			ptr = ptr.next;
		}

		while(ptr2 != null){
			i = stack.pop();
			if(ptr2.data == i){
				checkPalin = true;
			}else{
				checkPalin = false;
				break;
			}
			ptr2 = ptr2.next;
		}

		return checkPalin;
	}

	static Node linkReverseIterative(Node head){
		Node next, prev = null;
		Node current = head;

		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	static Node linkReverseRecursion(Node head){
		Node first, rest = null;
		Node ptr = head;

		if(ptr == null){
			return ptr;
		}

		first = ptr;
		rest = first.next;

		if(rest == null){
			return ptr;
		}

		ptr = linkReverseRecursion(rest);

		rest.next = first;
		first.next = null;

		return ptr;

	}

	public static void main(String args[]) {

		// Node head = null;
		Node first = new Node();
		Node second = new Node();
		Node third = new Node();
		Node fourth = new Node();
		Node fifth = new Node();
		first.createNewNode(1);
		second.createNewNode(2);
		third.createNewNode(3);
		fourth.createNewNode(4);
		fifth.createNewNode(5);

		Node head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		print(head);

		System.out.println();

		// head = addNodeAtStart(head, 0);
		// print(head);

		System.out.println();

		System.out.println("Length is "+linkLenght(head));
		System.out.println();

		linkSearch(head);
		System.out.println();

		// head =  linkDelete(head, 3);
		// System.out.println();

		print(head);
		System.out.println();

		linkSearch(head);
		System.out.println();

		// System.out.println(linkShare(head).data);

		System.out.println();
		linkCount(head);

		System.out.println();
		linkMinMax(head);

		System.out.println();
		print(head);

		System.out.println("Is it palindrome: "+linkPaldindrome(head));

		// System.out.println(linkShareEnd(head).data);
		// head = linkCircular(head);
		// print(head);

		// head = linkReverseIterative(head);
		head = linkReverseRecursion(head);
		print(head);

	}
}
