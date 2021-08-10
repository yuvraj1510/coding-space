package yuvrajs.coding.linkedlist;

public class GetNodeFromTail {

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
	
	public static int getNodeValueFromLast(SinglyLinkedListNode head, int postitionFromTail) {
		SinglyLinkedListNode temp1 = head;
		SinglyLinkedListNode temp2 = head;
		
		int i=0;
		
		while(i++ <= postitionFromTail) {
			temp2 = temp2.next;
		}

		while(temp2 != null) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		return temp1.data;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.insertNode(4);
		list.insertNode(5);
		
		System.out.print("Input LIST is : ");
		printList(list.head);
		System.out.println();
		
		int value = getNodeValueFromLast(list.head, 1);
		System.out.print("Node value from last is : "+value);

	}

}
