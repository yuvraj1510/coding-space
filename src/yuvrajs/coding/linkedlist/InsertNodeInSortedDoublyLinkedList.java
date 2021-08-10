package yuvrajs.coding.linkedlist;

public class InsertNodeInSortedDoublyLinkedList {

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
				node.prev = this.tail;
				this.tail.next = node;
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
	
	public static DoublyLinkedListNode insertNodeInSortedList(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		
		if(head != null) {
			if(head.next == null) {
				if(head.data < data) {
					node.prev = head;
					head.next = node;
				} else {
					node.next = head;
					head.prev = node;
					head = node;
				}
			} else {
				DoublyLinkedListNode temp = head;
				while(temp.data < data) {
					temp = temp.next;
				}
				node.next = temp;
				node.prev = temp.prev;
				temp.prev.next = node;	
				temp.prev = node;
			}
		} else {
			head = node;
		}
		return head;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertNode(1);
		list.insertNode(3);
		
		
		System.out.print("Input List is : ");
		printList(list.head);
		System.out.println();

		list.head = insertNodeInSortedList(list.head, 2);
		
		System.out.print("Output List is : ");
		printList(list.head);
		System.out.println();

		
	}

}
