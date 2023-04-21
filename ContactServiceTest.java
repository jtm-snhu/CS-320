/*
 * Jeffrey McGinty
 * jeffrey.mcginty@snhu.edu
 * CS-320 Module 3
 * March 15, 2023
 */

package ContactTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;

import ContactService.ContactService;


class ContactServiceTest {
	
	@AfterEach
	void clearContacts() throws Exception {
		ContactService.contacts.clear();
	}

	@Test
	@DisplayName("Add contact to empty list")
	void testAddContact() {
		ContactService testService = new ContactService();
		
		testService.addContact("007", "John", "Doe", "0123456789", "1313 Mockingbird Lane");
		assertEquals(ContactService.contacts.get(0).getContactID(), "007");
		assertEquals(ContactService.contacts.get(0).getFirstName(), "John");
		assertEquals(ContactService.contacts.get(0).getLastName(), "Doe");
		assertEquals(ContactService.contacts.get(0).getPhone(), "0123456789");
		assertEquals(ContactService.contacts.get(0).getAddress(), "1313 Mockingbird Lane");
	}
	
	@Test
	@DisplayName("Add two contacts")
	void testMultiContacts() {
		ContactService testService = new ContactService();
		
		testService.addContact("007", "John", "Doe", "0123456789", "1313 Mockingbird Lane");
		testService.addContact("009", "Jane", "Doe", "9876543210", "1313 Mockingbird Lane");
		assertEquals(ContactService.contacts.size(), 2);
	}
	
	
	@Test
	@DisplayName("Reject duplicate ID")
	void testDuplicateID() {
		ContactService testService = new ContactService();
		
		testService.addContact("007", "John", "Doe", "0123456789", "1313 Mockingbird Lane");
		assertThrows(IllegalArgumentException.class, () ->{
			testService.addContact("007", "Jane", "Doe", "9876543210", "1313 Mockingbird Lane");
		});
		
	}
	
	@Test
	@DisplayName("Delete from empty list")
	void testEmptyList() {
		ContactService testService = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () ->{
			testService.deleteContact("007");
		});
		
	}
	
	@Test
	@DisplayName("Delete invalid ID")
	void testDeleteInvalid() {
		ContactService testService = new ContactService();
		
		testService.addContact("007", "John", "Doe", "0123456789", "1313 Mockingbird Lane");
		assertThrows(IllegalArgumentException.class, () ->{
			testService.deleteContact("700");
		});
	}
	
	@Test
	@DisplayName("Update existing first name")
	void testUpdateFirstName() {
		ContactService testService = new ContactService();
		
		// Add and verify two records
		testService.addContact("007", "Original", "Original", "0123456789", "Original");
		testService.addContact("009", "Original", "Original", "0123456789", "Original");
		assertEquals(ContactService.contacts.size(), 2);
		assertEquals(ContactService.contacts.get(0).getFirstName(), "Original");
		assertEquals(ContactService.contacts.get(1).getFirstName(), "Original");
		
		// Check that exactly 1 record gets updated
		testService.updateFirstName("007", "Changed");
		assertEquals(ContactService.contacts.get(0).getFirstName(), "Changed");
		assertEquals(ContactService.contacts.get(1).getFirstName(), "Original");
		
	}
	
	@Test
	@DisplayName("Update existing last name")
	void testUpdateLastName() {
		ContactService testService = new ContactService();
		
		// Add and verify two records
		testService.addContact("007", "Original", "Original", "0123456789", "Original");
		testService.addContact("009", "Original", "Original", "0123456789", "Original");
		assertEquals(ContactService.contacts.size(), 2);
		assertEquals(ContactService.contacts.get(0).getLastName(), "Original");
		assertEquals(ContactService.contacts.get(1).getLastName(), "Original");
		
		// Check that exactly 1 record gets updated
		testService.updateLastName("007", "Changed");
		assertEquals(ContactService.contacts.get(0).getLastName(), "Changed");
		assertEquals(ContactService.contacts.get(1).getLastName(), "Original");
		
	}
	
	@Test
	@DisplayName("Update existing address")
	void testUpdateAddress() {
		ContactService testService = new ContactService();
		
		// Add and verify two records
		testService.addContact("007", "Original", "Original", "0123456789", "Original");
		testService.addContact("009", "Original", "Original", "0123456789", "Original");
		assertEquals(ContactService.contacts.size(), 2);
		assertEquals(ContactService.contacts.get(0).getAddress(), "Original");
		assertEquals(ContactService.contacts.get(1).getAddress(), "Original");
		
		// Check that exactly 1 record gets updated
		testService.updateAddress("007", "Changed");
		assertEquals(ContactService.contacts.get(0).getAddress(), "Changed");
		assertEquals(ContactService.contacts.get(1).getAddress(), "Original");
		
	}
	

	@Test
	@DisplayName("Update existing phone")
	void testUpdatePhone() {
		ContactService testService = new ContactService();
		
		// Add and verify two records
		testService.addContact("007", "Original", "Original", "0123456789", "Original");
		testService.addContact("009", "Original", "Original", "0123456789", "Original");
		assertEquals(ContactService.contacts.size(), 2);
		assertEquals(ContactService.contacts.get(0).getPhone(), "0123456789");
		assertEquals(ContactService.contacts.get(1).getPhone(), "0123456789");
		
		// Check that exactly 1 record gets updated
		testService.updatePhone("007", "9876543210");
		assertEquals(ContactService.contacts.get(0).getPhone(), "9876543210");
		assertEquals(ContactService.contacts.get(1).getPhone(), "0123456789");
		
	}
}
