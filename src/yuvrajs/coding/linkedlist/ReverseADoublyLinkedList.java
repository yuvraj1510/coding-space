package yuvrajs.coding.linkedlist;

public class ReverseADoublyLinkedList {

	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;
		
		public DoublyLinkedListNode(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;
		
		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}
		
		public void insertNode(int data) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(data);
			
			if(this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = tail;
			}
			this.tail = node;
		}
	}
	
	public static void printList(DoublyLinkedListNode head) {
		DoublyLinkedListNode temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static DoublyLinkedListNode reverseList(DoublyLinkedListNode head) {
		DoublyLinkedListNode temp = head;
		DoublyLinkedListNode prev = null;
		
		while(temp != null) {
			DoublyLinkedListNode tempNext = temp.next;
 			temp.prev = temp.next;
			temp.next = prev;
			prev = temp;
			temp = tempNext;
		}
		
		head = prev;
		return head;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.insertNode(4);
		list.insertNode(5);
		
		System.out.print("Input List is : ");
		printList(list.head);
		System.out.println();

		list.head = reverseList(list.head);
		System.out.print("Output List is : ");
		printList(list.head);
		System.out.println();
	}

}
