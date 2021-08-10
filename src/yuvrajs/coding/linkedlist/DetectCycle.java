package yuvrajs.coding.linkedlist;

public class DetectCycle {

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
	
	public static boolean checkIfListIsCyclic(SinglyLinkedListNode head) {
		
		if(head == null || head.next == null) {
			return false;
		}
		
		SinglyLinkedListNode slow = head;
		SinglyLinkedListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
	}
	
	public static SinglyLinkedListNode convertListToCyclic(SinglyLinkedListNode head) {
		SinglyLinkedListNode head2 = head;
		SinglyLinkedListNode temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = head2;
		
		return head2;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.insertNode(4);
		list.insertNode(5);
		
		printList(list.head);
		System.out.println();
		
		boolean isCyclic = checkIfListIsCyclic(list.head);
		System.out.println("Is List Cyclic - "+isCyclic);
		
		SinglyLinkedListNode head2 = convertListToCyclic(list.head);
		
		isCyclic = checkIfListIsCyclic(head2);
		System.out.println("Is List Cyclic - "+isCyclic);

	}

}
