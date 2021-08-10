package yuvrajs.coding.linkedlist;

public class DeleteDuplicateNodesInSortedList {

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
		
		if(temp == null) {
			return;
		}
		
		System.out.print(temp.data + " ");
		printList(temp.next);
	}
	
	public static SinglyLinkedListNode deleteDuplicateNodes(SinglyLinkedListNode head) {
		
		if(head != null) {
			SinglyLinkedListNode temp = head;
			int data = head.data;
			
			while(temp.next != null) {
				if(temp.next.data == data) {
					temp.next = temp.next.next;
				} else {
					temp = temp.next;
					data = temp.data;
				}
			}
		} 
		return head;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(2);
		list.insertNode(3);
		list.insertNode(3);
		list.insertNode(3);
		list.insertNode(3);
		
		System.out.print("Input List is : ");
		printList(list.head);
		System.out.println();
		
		list.head = deleteDuplicateNodes(list.head);
		
		System.out.print("Output List is : ");
		printList(list.head);
		System.out.println();
		

	}

}
