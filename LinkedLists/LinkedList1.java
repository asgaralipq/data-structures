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

	static Node linkReverseGroup(Node head, int n){

		if(head == null){
			return null;
		}
		Node next = null , prev = null;
		Node current = head;
		int count = 0;

		while(count < n && current != null){
			
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
				count++;
		}

		if(next!=null){
			head.next = linkReverseGroup(next, n);
		}
		return prev;
	}

	static boolean linkLoop(Node head){

		if(head == null){
			return false;
		}
		else{
			while(head != null){
				
				if(head.data == -1){
					return true;
				}
				else{
					head.data = -1;
					head = head.next;
				}
			}
			return false;
		}
	}

	static int countNodes(Node head){
		int count = 1;
		Node temp = head;

		while(head.next != temp){
			count++;
			head = head.next;
		}

		return count;
	}

	static int linkLoopLength(Node head){
		Node fastPtr = head;
		Node slowPtr = head;

		while(slowPtr != null && fastPtr != null && fastPtr.next != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if(slowPtr == fastPtr){
				return countNodes(slowPtr);
			}
		}
		return 0;
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

	static Node deleteList(Node head){
		head = null;
		return head;
	}

	static Node removeDuplicates(Node head){
		Node ptr = head;
		Node next = null;

		while(ptr.next != null){
			if(ptr.data == ptr.next.data){
				next = ptr.next.next;
				ptr.next.next = null;
				ptr.next = next;
			}
			if(ptr.next != null){
				if(ptr.next.data != ptr.data)
					ptr = ptr.next;
			}
		}
		return head;
	}

	static Node removeDuplicates1(Node head){
		Node ptr = head;
		
		while(ptr != null){
			Node temp = ptr;

			while(temp != null && temp.data == ptr.data){
				temp = temp.next;
			}
		ptr.next = temp;
		ptr = ptr.next;	
		}
		return head;
	}

	static Node removeUnsortedDuplicates(Node head){
		Node ptr = head, ptr1 = null;
		// Node prev = null, next = null;

		while(ptr != null && ptr.next != null){
			ptr1 = ptr;


			while(ptr1.next != null){
				if(ptr.data == ptr1.next.data){
					ptr1.next = ptr1.next.next;
				}
				else{
					ptr1 = ptr1.next;
				}
			}
			ptr = ptr.next;
		}
		ptr = head;
		return ptr;
	}

	static Node lastToFirst(Node head){
		Node ptr = head;
		Node ptr2 = head;

		while(ptr.next != null){
			ptr = ptr.next;
		}
		while(ptr2.next != ptr){
			ptr2 = ptr2.next;
		}
		System.out.println("ptr "+ptr.data);
		System.out.println("ptr2 "+ptr2.data);
		System.out.println("head "+head.data);
		ptr2.next = null;
		ptr.next = head;
		head = ptr;

		return ptr;
	}

	static int middleOfLinkedList(Node head){
		Node slowPNode = head;
		Node fastPNode = head;

		while(fastPNode != null && fastPNode.next != null){
			fastPNode = fastPNode.next.next;
			slowPNode = slowPNode.next;
		}

		return slowPNode.data;
	}

	static boolean isCircular(Node head){
		Node ptr = head.next;

		while(ptr != null && ptr!= head)
			ptr = ptr.next;

		return (ptr == head);

	}

	static Node split(Node head){
		Node slowPNode = head;
		Node fastPNode = head;
		Node newHead = null;

		while(fastPNode != null && fastPNode.next != null){
			fastPNode = fastPNode.next.next;
			slowPNode = slowPNode.next;
		}
		fastPNode.next = slowPNode.next;
		slowPNode.next = head;
		// slowPNode.next = null;
		// print(fastPNode);

		return fastPNode;
	}


	// static Node addLinkedList(Node head, Node head1){
	// 	Node ptr = head;
	// 	Node ptr2 = head2;
	// }

	// static Node addOnetoList(Node head){
		
	// 	int carry = 0;
	// 	Node ptr = linkReverseIterative(head);
	// 	print(ptr);
	// 	int sum = 0;
	// 	Node temp = null;

	// 	while(ptr != null){
			
	// 		sum = ptr.data + carry;

	// 		if (sum >= 10){
	// 			carry = 1;
	// 		}
	// 		sum = sum % 10;

	// 		ptr.data = sum;

	// 		temp = head;
	// 		ptr = ptr.next;
	// 	}
	// 	if(carry > 0){
	// 		Node node = new Node();
	// 		node.createNewNode(carry);
	// 	}
	// }

	public static void main(String args[]) {

		// Node head = null;
		Node first = new Node();
		Node second = new Node();
		Node second1 = new Node();
		Node third = new Node();
		Node fourth = new Node();
		Node fifth = new Node();
		first.createNewNode(1);
		second.createNewNode(2);
		second1.createNewNode(3);
		third.createNewNode(4);
		fourth.createNewNode(5);
		fifth.createNewNode(6);

		Node head = first;
		first.next = second;
		second.next = second1;
		second1.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = first;


		// print(head);

		// System.out.println();

		// head = addNodeAtStart(head, 0);
		// print(head);

		// System.out.println();

		// System.out.println("Length is "+linkLenght(head));
		// System.out.println();

		// linkSearch(head);
		// System.out.println();

		// head =  linkDelete(head, 3);
		// System.out.println();

		// print(head);
		// System.out.println();

		// linkSearch(head);
		// System.out.println();

		// System.out.println(linkShare(head).data);

		// System.out.println();
		// linkCount(head);

		// System.out.println();
		// linkMinMax(head);

		// System.out.println();
		// print(head);

		// System.out.println("Is it palindrome: "+linkPaldindrome(head));

		// System.out.println(linkShareEnd(head).data);
		// head = linkCircular(head);
		// print(head);

		// head = linkReverseIterative(head);
		// head = linkReverseRecursion(head);
		// head = linkReverseGroup(head, 3);
		// print(head);

		// head = deleteList(head);
		// System.out.println("Loop"+linkLoop(head));

		// System.out.println("Loop Length"+linkLoopLength(head));
		// print(head);

		// head = removeUnsortedDuplicates(head);
		// head = lastToFirst(head);
		// head = addOnetoList(head);
		// System.out.println("Middle"+middleOfLinkedList(head));
		// System.out.println("What Circular???? "+isCircular(head));
		// print(head);

		Node head1 = split(head);

		print(head1);

		print(head);

	

	}
}
