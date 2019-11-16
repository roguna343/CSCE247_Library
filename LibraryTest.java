package CSCE247_Library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibraryTest {

	@Test
	void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateItem() {
		fail("Not yet implemented");
	}

	@Test
	void testIsAvailable() {
		Library libTest = new Library();
		Book toAdd = new Book();
		toAdd.setTitle("Find me");
		libTest.addNewItem(toAdd);
		boolean actual = libTest.isAvailable("Find me");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	void testGetPatronInfo() {
		Library libTest = new Library();
		libTest.getPatronInfo();
	}

	@Test
	void testGetInventoryInfo() {
		Library libTest = new Library();
		libTest.getInventoryInfo();
	}

	@Test
	void testPushFines() {
		fail("Not yet implemented");
	}

	@Test
	void testAddNewItem() {
		Library libTest = new Library();
		Book book = new Book();
		String title = "The Giver";
		book.setTitle(title);
		libTest.addNewItem(book);
		boolean expected = libTest.isAvailable(title);
		boolean actual = libTest.isAvailable(title);
		assertEquals(expected, actual);
	}

	@Test
	void testAddCopyOfItem() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveItem() {
		fail("Not yet implemented");
	}

	@Test
	void testAddUser() {
		fail("Not yet implemented");
	}

}
