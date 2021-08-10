package yuvrajs.coding.linkedlist;

public class CompareList {
	
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
	
	public static boolean isListEqual(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		while(head1 != null && head2 != null && head1.data == head2.data) {
			head1 = head1.next;
			head2 = head2.next;
		}
		
		return head1 == head2;
	}

	public static void main(String[] args) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertNode(1);
		list1.insertNode(2);
		list1.insertNode(3);
		list1.insertNode(4);
		list1.insertNode(5);

		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insertNode(1);
		list2.insertNode(2);
		list2.insertNode(3);
		list2.insertNode(4);
		list2.insertNode(5);
		
		boolean isEqual = isListEqual(list1.head, list2.head);
		
		System.out.println("RESULT : "+isEqual);
	}

}
