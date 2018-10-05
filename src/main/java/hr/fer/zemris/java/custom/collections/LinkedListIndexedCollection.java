package hr.fer.zemris.java.custom.collections;

/**
 * Class that represents the use and manipulation of the indexed linked lists.
 * The defining variables are size of the list, first node and last node. The
 * collection permits the storage of duplicate objects, but forbids the storage
 * of null objects.
 * 
 * @author Dinz
 *
 */
public class LinkedListIndexedCollection extends Collection {
	/**
	 * Inner class that represents the node of the indexed linked lists. Every node
	 * has its own value and reference to the previous and the next nodes.
	 * 
	 * @author Dinz
	 *
	 */
	private static class ListNode {
		ListNode previous;
		ListNode next;
		Object value;
	}

	private int size;
	private ListNode first;
	private ListNode last;

	/**
	 * Constructs a new LinkedListIndexedCollection with initializing first and last
	 * nodes of the collection to null.
	 */
	public LinkedListIndexedCollection() {
		this.first = this.last = null;
	}

	/**
	 * Constructs a new LinkedListIndexedCollection from another collection by
	 * adding all of the other collections elements to the linked list.
	 * 
	 * @param other
	 *            Another Collection
	 */
	public LinkedListIndexedCollection(Collection other) {
		this.addAll(other);
	}

	/**
	 * Returns the size of the linked list collection.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Adds the object to the linked list collection. If the given object is null,
	 * the method throws a NullPointerException. The adding is implemented as
	 * creating a new node and connecting it to its previous and next node in the
	 * list.
	 */
	@Override
	public void add(Object value) {
		if (value.equals(null))
			throw new NullPointerException("Object must not be null.");

		if (this.first == null) {
			ListNode createFirst = new ListNode();
			createFirst.value = value;
			this.first = this.last = createFirst;
		} else {
			ListNode createNode = new ListNode();
			createNode.value = value;
			createNode.previous = this.last;
			createNode.next = null; // iako je automatski inicijaliziran
			this.last.next = createNode;
			this.last = createNode;
		}
		this.size++;
	}

	/**
	 * Inserts an object into the list at the given position. If the given object is
	 * null or the position is in invalid range, the method throws an exception.
	 * 
	 * @param value
	 *            Object to be inserted
	 * @param position
	 *            Desired position
	 */
	public void insert(Object value, int position) {
		if (value.equals(null))
			throw new NullPointerException("Object must not be null.");

		if (position < 0 || position > size)
			throw new IndexOutOfBoundsException("Invalid position.");

		if (position == size)
			this.add(value);

		if (position == 0) {
			ListNode adding = new ListNode();
			adding.value = value;
			adding.next = first;
			adding.previous = null;
			first.previous = adding;
			first = adding;
		}

		else {

			ListNode assist = this.first;
			for (int i = 0; i < position - 1; i++)
				assist = assist.next;

			ListNode adding = new ListNode();
			adding.value = value;
			adding.next = assist.next;
			adding.previous = assist;
			assist.next = adding;
			assist.next.previous = adding;

			this.size++;
		}

	}

	/**
	 * Gets an object from the collection at the given index. If the range of an
	 * index is invalid, the method throws an IndexOutOfBoundsException
	 * 
	 * @param index
	 *            Desired index
	 * @return Object at the given index
	 */
	public Object get(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("Index out of bounds.");

		ListNode assist = this.first;
		for (int i = 0; i < index; i++)
			assist = assist.next;

		return assist.value;
	}

	/**
	 * Returns the index of the first occurance of the desired object. If the object
	 * is null, the method throws a NullPointerException.
	 * 
	 * @param value
	 *            Desired object
	 * @return Index of the desired object
	 */
	public int indexOf(Object value) {
		if (value.equals(null))
			throw new NullPointerException("Object must not be null.");

		if (this.contains(value)) {
			ListNode assist = this.first;
			for (int i = 0; i < size; i++) {
				if (assist.value.equals(value))
					return i;
				assist = assist.next;
			}
		}
		return -1;
	}

	/**
	 * Method that checks if the given object is present in a linked list.
	 */
	@Override
	public boolean contains(Object value) {
		if (value.equals(null))
			throw new NullPointerException("Object must not be null.");

		ListNode assist = this.first;
		for (int i = 0; i < size; i++) {
			if (assist.value.equals(value))
				return true;
			assist = assist.next;
		}
		return false;
	}

	/**
	 * Method that removes the given object from the linked list.
	 */
	@Override
	public boolean remove(Object value) {
		int index = this.indexOf(value);

		if (index == -1)
			return false;

		this.remove(index);
		return true;
	}

	/**
	 * Method that removes the object from the linked list at the given index
	 * 
	 * @param index
	 *            Index of the object that is to be removed
	 */
	public void remove(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("Index out of bounds.");

		ListNode assist = this.first;
		for (int i = 0; i < index; i++)
			assist = assist.next;

		if (index != 0)
			assist.previous.next = assist.next;

		if (index != this.size - 1)
			assist.next.previous = assist.previous;

		this.size--;
	}

	/**
	 * Method that transforms the list into the object array.
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[this.size];

		ListNode assist = this.first;
		for (int i = 0; i < size; i++) {
			array[i] = assist.value;
			assist = assist.next;
		}
		return array;
	}

	/**
	 * Method that clears the LinkedListIndexedCollection
	 */
	@Override
	public void clear() {
		for (int i = 0; i < size; i++)
			this.remove(0);

		this.size = 0;
	}

	/**
	 * Method that applies the action of the processor for every element of the
	 * linked list.
	 */
	@Override
	public void forEach(Processor processor) {
		ListNode assist = first;
		for (int i = 0; i < this.size; i++) {
			processor.process(assist.value);
			assist = assist.next;
		}
	}
}
