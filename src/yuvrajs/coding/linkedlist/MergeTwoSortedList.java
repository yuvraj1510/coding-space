package yuvrajs.coding.linkedlist;

public class MergeTwoSortedList {

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
	
	public static void mergeList(SinglyLinkedListNode head1, SinglyLinkedListNode head2, SinglyLinkedList list3) {
		
		while(head1 != null && head2 != null) {
			if(head1.data < head2.data) {
				list3.insertNode(head1.data);
				head1 = head1.next;
			} else if(head2.data < head1.data) {
				list3.insertNode(head2.data);
				head2 = head2.next;
			} else {
				list3.insertNode(head1.data);
				head1 = head1.next;
				list3.insertNode(head2.data);
				head2 = head2.next;
			}
		}
		
		while(head1 != null) {
			list3.insertNode(head1.data);
			head1 = head1.next;
		}
		
		while(head2 != null) {
			list3.insertNode(head2.data);
			head2 = head2.next;
		}
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertNode(1);
		list1.insertNode(3);
		list1.insertNode(5);

		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insertNode(2);
		list2.insertNode(4);
		
		SinglyLinkedList list3 = new SinglyLinkedList();
		
		System.out.print("First List: ");
		printList(list1.head);
		
		System.out.print("Second List: ");
		printList(list2.head);
		
		System.out.print("Merged List: ");
		mergeList(list1.head, list2.head, list3);
		printList(list3.head);
		
	}

}
