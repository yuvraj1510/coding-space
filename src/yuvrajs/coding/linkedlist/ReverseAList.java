package yuvrajs.coding.linkedlist;

public class ReverseAList {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;
		
		public SinglyLinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;
		
		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}
		
		public void insertNode(int data) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(data);
			if(this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}
			this.tail = node;
		}
	}
	
	public static void printList(SinglyLinkedListNode head) {
		SinglyLinkedListNode temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static SinglyLinkedListNode reverseAList(SinglyLinkedListNode head) {
		if(head == null) {
			return head;
		} else if(head.next == null) {
			return head;
		} else {
			SinglyLinkedListNode prev = null;
			SinglyLinkedListNode temp = head.next;
			
			while(temp != null) {
				head.next = prev;
				prev = head;
				head = temp;
				temp = temp.next;
			}
			
			head.next = prev;
		}
		return head;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.insertNode(4);
		list.insertNode(5);
		
		printList(list.head);
		list.head = reverseAList(list.head);
		printList(list.head);

	}

}
