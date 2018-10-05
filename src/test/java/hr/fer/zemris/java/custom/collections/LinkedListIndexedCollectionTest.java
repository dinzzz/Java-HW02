package hr.fer.zemris.java.custom.collections;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import hr.fer.zemris.java.custom.collections.LinkedListIndexedCollection;

public class LinkedListIndexedCollectionTest {
	@Test
	public void addBegginingTest() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		list.add((int) 20);

		Assert.assertEquals(20, list.get(0));
	}

	@Test
	public void addMiddleTest() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		list.add((int) 20);
		list.add((int) 25);

		Assert.assertEquals(25, list.get(1));
	}

	@Test
	public void addNull() {
		try {
			LinkedListIndexedCollection list = new LinkedListIndexedCollection();
			list.add(null);
			fail("Expected a NullPointerException to be thrown");
		} catch (NullPointerException ex) {

		}
	}

	@Test
	public void getTest() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		list.add((int) 350);

		Assert.assertEquals(350, list.get(0));
	}

	@Test
	public void getTestFail() {
		try {
			LinkedListIndexedCollection list = new LinkedListIndexedCollection();
			list.add((int) 1);
			list.get(17);
			fail("Expected an IndexOutOfBoundsException to be thrown");
		} catch (IndexOutOfBoundsException ex) {

		}
	}

	@Test
	public void clearTest() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		list.add((int) 1);
		list.add((int) 2);
		list.add((int) 3);
		list.clear();

		Assert.assertEquals(0, list.size());
	}

	@Test
	public void insertTest() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		list.add((int) 2);
		list.add((int) 3);
		list.add((int) 4);

		list.insert((int) 7, 2);
		Assert.assertEquals(7, list.get(2));

		list.insert((int) 10, 0);
		Assert.assertEquals(10, list.get(0));

		list.insert((int) 11, 0);
		Assert.assertEquals(11, list.get(0));

	}

	@Test
	public void insertBegginingTest() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		list.insert((int) 12, 0);

		Assert.assertEquals(12, list.get(0));
	}

	@Test
	public void insertEndTest() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		list.add((int) 2);
		list.add((int) 3);
		list.add((int) 4);
		list.add((int) 6);
		list.add((int) 7);
		list.add((int) 8);
		list.insert((int) 11, 6);

		Assert.assertEquals(11, list.get(6));
	}

	@Test
	public void insertNullTest() {
		try {
			LinkedListIndexedCollection list = new LinkedListIndexedCollection();
			list.insert(null, 0);
			fail("Expected a NullPointerException to be thrown");
		} catch (NullPointerException ex) {

		}
	}

	@Test
	public void insertFailTest() {
		try {
			LinkedListIndexedCollection list = new LinkedListIndexedCollection();
			list.add((int) 1);
			list.insert((int) 0, 17);
			fail("Expected an IndexOutOfBoundsException to be thrown");
		} catch (IndexOutOfBoundsException ex) {

		}
	}

	@Test
	public void indexOfTest() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		list.add((int) 2);
		list.add((int) 3);
		list.add((int) 4);
		list.add((int) 6);
		list.add((int) 7);
		list.add((int) 8);

		Assert.assertEquals(2, list.indexOf((int) 4));
	}

	@Test
	public void removeTest() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		list.add("SF");
		list.add("NY");
		list.add("ZG");
		list.add("ST");
		list.add("LA");
		list.add("BG");

		list.remove("ST");

		Assert.assertEquals(false, list.contains("ST"));
	}
}
