import java.util.*;

class Node {
	int data;
	Node next;

	void createNewNode(int d) {
		this.data = d;
		this.next = null;
	}

	Node(int d){
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

	static void printC(Node head) {

		Node ptr = head;
		Node temp = ptr;
		do {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		} while (ptr != temp);
		System.out.println(ptr.data);
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
		// System.out.println("Index doesn't exist "+(linkLenght(ptr)-1));
		print(head);
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
		Node node = new Node(data);
		// node.createNewNode(data);

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
		Node node = new Node(data);
		// node.createNewNode(data);

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
			return head;
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

	static Node deleteFromC(Node head, int data){
		Node ptr = head;
		
		if(ptr==null ){
			return head;
		}
		printC(ptr);

		while(ptr.next.data != data ){
			System.out.println();
			printC(ptr);
			ptr = ptr.next;
			if(ptr == head){
				System.out.println("Element not found");
				return head;
			}
		}

		if(ptr.next == head){
			ptr.next = ptr.next.next;
			head = ptr.next;
			return head;
		}else{
			ptr.next = ptr.next.next;
			return head;
		}

	}

	//This function works
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


	//Don't know why I wrote this
	static Node removeDuplicates1(Node head){
		Node ptr = head;
		
		while(ptr != null){
			Node temp = ptr;

			while(temp != null && temp.data == ptr.data){
				System.out.println("Here data found "+temp.data);
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

	static void split(Node head){
		Node slowPNode = head;
		Node fastPNode = head;
		// Node newHead = null;
		printC(head);

		while(fastPNode.next.next != head && fastPNode.next != head){
			fastPNode = fastPNode.next.next;
			slowPNode = slowPNode.next;
		}

		if(fastPNode.next == head){
			fastPNode.next = slowPNode.next;
		}
		else{
			fastPNode = fastPNode.next;
			fastPNode.next = slowPNode.next;
		}

		slowPNode.next = head;
		// slowPNode.next = null;

		System.out.println();
		printC(fastPNode);

		System.out.println();
		printC(head);

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

	public static Node addTwoNumbers(Node l1, Node l2) {
		int carry = 0;
		Node ptr, dummy = new Node(0);
		ptr = dummy;

		while(l1!=null || l2!=null || carry != 0){
				if(l1!=null){
					carry += l1.data;
					l1 = l1.next;
				}
				if(l2!=null){
					carry += l2.data;
					l2 = l2.next;
				}
				ptr.next = new Node(carry%10);
				carry = carry/10;
				ptr = ptr.next;
		}
		return dummy.next;
	}

	public static Node AddOneToList(Node head){
		int carry = 1;
		Node ptr, dummy = new Node(0);
		ptr = dummy;

		while(head != null || carry != 0){
			if(head != null){
				carry += head.data;
				head = head.next;
			}
			ptr.next = new Node(carry%10);
			carry /= 10;
			ptr = ptr.next;
		}
		return dummy.next;
	}

	public static Node intersectionLink(Node a, Node b){
		Node newNode = new Node(0);
		Node temp = newNode;
		
		while(a!=null){
			Node ptr = b;
			while(ptr!=null){
				// System.out.println("Comparing a and b "+a.data+" "+ptr.data);
				if(a.data == ptr.data){
					// System.out.println("Adding "+a.data);
					newNode.next = new Node(a.data);
					newNode = newNode.next;
					break;
				}
				ptr = ptr.next;
			}
			a = a.next;
		}
		newNode = temp;
		return newNode.next;
	}

	public static int intersectPoint(Node head1, Node head2)
	{
         Node a = head1;
         Node b = head2;
         while(a != b){
             a = (a == null)? head1 : a.next;
             b = (b == null)? head2 : b.next;
         }
         if(a == null)
             return -1;
        return a.data;
	}

	public static Node exchangeNode(Node head){

		Node ptr = head;
		Node prev = ptr;
		while(ptr.next != null){
			prev = ptr;
			ptr = ptr.next;
		}

		ptr.next = head.next;
		prev.next = head;
		prev.next.next = null;

		return ptr;
	}

	public static void main(String args[]) {

		// Node head = null;
		Node first = new Node(1);
		Node second = new Node(2);
		Node second1 = new Node(3);
		Node third = new Node(4);
		Node fourth = new Node(5);
		Node fifth = new Node(6);
		// first.createNewNode(3);
		// second.createNewNode(4);
		// second1.createNewNode(5);
		// third.createNewNode(4);
		// fourth.createNewNode(5);
		// fifth.createNewNode(6);

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

		// head =  linkDelete(head, 7);
		// System.out.println();

		// print(head);
		// System.out.println();

		// linkSearch(head);
		// System.out.println();

		// System.out.println(linkShare(head).data);

		// System.out.println(linkShareEnd(head).data);

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
		// head = removeDuplicates1(head);
		// print(head);
		// head = lastToFirst(head);
		// head = addOnetoList(head);
		// System.out.println("Middle"+middleOfLinkedList(head));
		// System.out.println("What Circular???? "+isCircular(head));
		// print(head);

		// split(head);

		// Node dummy = addTwoNumbers(head,third);
		// Node dummy = AddOneToList(head);

		// Node dummy = intersectionLink(head, third);

		// print(dummy);

		// print(exchangeNode(head));
		// print(head1);

		head = deleteFromC(head, 7);
		printC(head);
		// print(head);

	

	}
}
