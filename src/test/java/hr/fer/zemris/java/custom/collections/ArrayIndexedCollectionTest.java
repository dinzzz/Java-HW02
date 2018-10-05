package hr.fer.zemris.java.custom.collections;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import hr.fer.zemris.java.custom.collections.ArrayIndexedCollection;

public class ArrayIndexedCollectionTest {

	@Test
	public void addBegginingTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection();
		array.add((int) 20);

		Assert.assertEquals(20, array.get(0));
	}

	@Test
	public void addMiddleTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection();
		array.add((int) 20);
		array.add((int) 25);

		Assert.assertEquals(25, array.get(1));
	}

	@Test
	public void addNull() {
		try {
			ArrayIndexedCollection array = new ArrayIndexedCollection();
			array.add(null);
			fail("Expected a NullPointerException to be thrown");
		} catch (NullPointerException ex) {

		}
	}

	@Test
	public void addReallocationTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection(2);
		array.add((int) 20);
		array.add((int) 21);
		array.add((int) 22);

		Assert.assertEquals(22, array.get(2));
	}

	@Test
	public void getTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection(2);
		array.add((int) 350);

		Assert.assertEquals(350, array.get(0));
	}

	@Test
	public void getTestFail() {
		try {
			ArrayIndexedCollection array = new ArrayIndexedCollection();
			array.add((int) 1);
			array.get(17);
			fail("Expected an IndexOutOfBoundsException to be thrown");
		} catch (IndexOutOfBoundsException ex) {

		}
	}

	@Test
	public void clearTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection(3);
		array.add((int) 1);
		array.add((int) 2);
		array.add((int) 3);
		array.clear();

		Assert.assertEquals(0, array.size());
	}

	@Test
	public void insertTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection(5);
		array.add((int) 2);
		array.add((int) 3);
		array.add((int) 4);
		array.insert((int) 7, 2);

		Assert.assertEquals(7, array.get(2));
	}

	@Test
	public void insertBegginingTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection(5);
		array.insert((int) 12, 0);

		Assert.assertEquals(12, array.get(0));
	}

	@Test
	public void insertEndTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection(5);
		array.add((int) 2);
		array.add((int) 3);
		array.add((int) 4);
		array.add((int) 6);
		array.add((int) 7);
		array.add((int) 8);
		array.insert((int) 11, 6);

		Assert.assertEquals(11, array.get(6));
	}

	@Test
	public void insertNullTest() {
		try {
			ArrayIndexedCollection array = new ArrayIndexedCollection();
			array.insert(null, 0);
			fail("Expected a NullPointerException to be thrown");
		} catch (NullPointerException ex) {

		}
	}

	@Test
	public void insertFailTest() {
		try {
			ArrayIndexedCollection array = new ArrayIndexedCollection();
			array.add((int) 1);
			array.insert((int) 0, 17);
			fail("Expected an IndexOutOfBoundsException to be thrown");
		} catch (IndexOutOfBoundsException ex) {

		}
	}

	@Test
	public void indexOfTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection(5);
		array.add((int) 2);
		array.add((int) 3);
		array.add((int) 4);
		array.add((int) 6);
		array.add((int) 7);
		array.add((int) 8);

		Assert.assertEquals(2, array.indexOf((int) 4));
	}

	@Test
	public void removeTest() {
		ArrayIndexedCollection array = new ArrayIndexedCollection(5);
		array.add("SF");
		array.add("NY");
		array.add("ZG");
		array.add("ST");
		array.add("LA");
		array.add("BG");

		array.remove("ST");

		Assert.assertEquals(false, array.contains("ST"));
	}
}
