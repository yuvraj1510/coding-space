package yuvrajs.coding.linkedlist;

public class DeleteANode {
	
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
	
	public static Integer deleteNode(SinglyLinkedListNode head, int position) {
		Integer data = null;
		if(head == null) {
			return data;
		} else {
			SinglyLinkedListNode temp = head;
			for(int i=1; i<position; i++) {
				temp = temp.next;
			}
			
			SinglyLinkedListNode deletedNode = temp.next;
			if(deletedNode != null) {
				data = temp.next.data;
				temp.next = temp.next.next;
			} else {
				temp.next = null;
			}
		}
		
		return data;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.insertNode(4);
		list.insertNode(5);
		list.insertNode(6);

		printList(list.head);
		int deletedNode = deleteNode(list.head, 5);
		System.out.println("DELETED NODE : "+deletedNode);
		printList(list.head);
		
	}

}
