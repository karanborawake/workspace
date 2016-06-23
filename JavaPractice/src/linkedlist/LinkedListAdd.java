package linkedlist;

import java.util.LinkedList;

public class LinkedListAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Object> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add("A");
		ll.addFirst("Sonali");
		ll.addLast("Jadhav");
		ll.remove("A");
		ll.add(1, "C");
		System.out.println("Original content of ll :: " + ll);

	}

}
