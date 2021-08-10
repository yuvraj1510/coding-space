package yuvrajs.coding.linkedlist;

public class MergePointOfList {

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
	}
	
	public static void mergeList(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode temp = head2;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = head1.next.next.next;
	}
	
	public static int findMergingPoint(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode temp1 = head1;
		SinglyLinkedListNode temp2 = head2;
		
		int count1 = 0;
		int count2 = 0;
		
		while(temp1 != null) {
			count1 = count1 + 1;
			temp1 = temp1.next;
		}
		
		System.out.println();
		System.out.println("No of Nodes in 1st List : "+count1);
		while(temp2 != null) {
			count2 = count2 + 1;
			temp2 = temp2.next;
		}
		System.out.println("No of Nodes in 2nd List : "+count2);
		System.out.println();
		
		temp1 = head1;
		temp2 = head2;
		
		if(count1 < count2) {
			int i=0;
			while(i++ < (count2-count1)) {
				temp2 = temp2.next;
			}
		} else {
			int i=0;
			while(i++ < (count1-count2)) {
				temp1 = temp1.next;
			}
		}
		
		while(temp1 != null && temp2 != null) {
			if(temp1 == temp2) {
				return temp1.data;
			} else {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		
		return 0;
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
		
		System.out.print("First Input List is : ");
		printList(list1.head);
		
		System.out.println();
		System.out.print("Second Input List is : ");
		printList(list2.head);
		
		int data = findMergingPoint(list1.head, list2.head);
		
		System.out.println("RESULT Before Merge : "+data);	
		
		mergeList(list1.head, list2.head);
		
		System.out.println();
		System.out.print("Merged Input 1st List is : ");
		printList(list1.head);
		
		System.out.println();
		System.out.print("Merged Input 2nd List is : ");
		printList(list2.head);
		
		data = findMergingPoint(list1.head, list2.head);
		
		System.out.println("RESULT After Merge: "+data);	
		
	}

}
