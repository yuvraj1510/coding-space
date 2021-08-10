package yuvrajs.coding.linkedlist;

import java.util.Scanner;

public class InsertNodeAtTail {

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
	
	public static SinglyLinkedListNode insertAtLast(SinglyLinkedListNode head, int data) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		
		if(head == null) {
			head = node;
			return head;
		}
		
		SinglyLinkedListNode temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = node;
		return head;
	}
	
	public static void printList(SinglyLinkedListNode head) {
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			list.insertNode(sc.nextInt());
		}
		
		int data = sc.nextInt();
		
		sc.close();
		
		printList(list.head);
		
		insertAtLast(list.head, data);
		
		printList(list.head);
		
		insertAtLast(list.head, data);
		
		printList(list.head);

	}

}
