package Library247;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibraryTest {

	@Test
	void testLogin() {
		Library libTest = new Library();
		Adult toAdd = new Adult();
		toAdd.setUsername("8888");
		toAdd.setPassword("8888");
		libTest.addUser(toAdd);
		User logged = libTest.login(toAdd.getUsername(), toAdd.getPassword());
		assertEquals(logged, toAdd);
	}

	@Test
	void testUpdateUser() {
		Library libTest = new Library();
		User test = libTest.getUsr().get(0);
		test.setAge(test.getAge() + 99999);
		libTest.updateUser(test);
		boolean isUpdated = test.equals(libTest.getUsr().get(0));
		assertEquals(isUpdated, true);
		libTest.save();
	}

	@Test
	void testUpdateItem() {
		Library libTest = new Library();
		Item check = libTest.getInv().get(0);
		check.setAuthor(check.getAuthor() + "aaaaaa");
		libTest.updateItem(check);
		boolean isUpdated = check.equals(libTest.getInv().get(0));
		assertEquals(isUpdated, true);
		libTest.save();
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
	void testOverallInventoryInfo() {
		Library libTest = new Library();
		libTest.getInventoryInfo();
		libTest.getPatronInfo();
	}

	@Test
	void testAddNewItem() {
		Library libTest = new Library();
		Book lookFor = new Book();
		lookFor.setTitle("Book notAdded");
		boolean prev = libTest.isAvailable(lookFor.getTitle());
		libTest.addNewItem(lookFor);
		boolean add = libTest.isAvailable(lookFor.getTitle());
		libTest.save();
	}

	@Test
	void testPushFines() {
		Library libTest = new Library();
		Kid k = new Kid();
		Adult a = new Adult();
		k.setFines(20);
		a.setName("Barry");
		k.setParent(a.getName());
		a.setPassword("aa");
		a.setUsername("aa");
		libTest.addUser(k);
		libTest.addUser(a);
		libTest.pushFines(k);
		assertEquals(20, libTest.login(a.getUsername(), a.getPassword()).getFines());
	}
	
	@Test
	void testAddCopyOfItem() {
		Library libTest = new Library();
		Item test1 = libTest.getInv().get(0);
		int quantity1 = test1.getQuantity();
		libTest.addCopyOfItem(test1.getTitle());
		int quantity2 = test1.getQuantity();
		int diff = quantity2 - quantity1;
		assertEquals(diff, 1);
		libTest.save();
	}

	@Test
	void testRemoveItem() {
		Library libTest = new Library();
		Book test = new Book();
		test.setTitle("Removing");
		libTest.addNewItem(test);
		boolean availablePrev = libTest.isAvailable(test.getTitle());
		libTest.removeItem(test.getTitle());
		boolean availableNow = libTest.isAvailable(test.getTitle());
		assertEquals(availablePrev, !availableNow);
		libTest.save();
	}

	@Test
	void testAddUser() {
		Library libTest = new Library();
		int prevUserCount = libTest.getUsr().size();
		Adult toAdd = new Adult();
		Kid toAdd2 = new Kid();
		libTest.addUser(toAdd);
		libTest.addUser(toAdd2);
		int newUserCount = libTest.getUsr().size();
		int diff = newUserCount - prevUserCount;
		assertEquals(diff, 2);
		libTest.save();
	}
}