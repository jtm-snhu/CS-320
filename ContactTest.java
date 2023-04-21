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

import ContactService.Contact;


class ContactTest {
	
	@Test
	@DisplayName("New Contact Creation / Verify Getters")
	void testNewContact() {
		String contactID = "1234567890";
		String firstName = "John";
		String lastName = "Doe";
		String phone = "0123456789";
		String address = "1313 Mockingbird Lane";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phone, address);
		
		assertEquals("1234567890", testContact.getContactID());
		assertEquals("John", testContact.getFirstName());
		assertEquals("Doe", testContact.getLastName());
		assertEquals("0123456789", testContact.getPhone());
		assertEquals("1313 Mockingbird Lane", testContact.getAddress());		
	}
	
	@Test
	@DisplayName("Error on null values")
	void testContactNullArguments() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "John", "Doe", "0123456789", "1313 Mockingbird Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", null, "Doe", "0123456789", "1313 Mockingbird Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", "John", null, "0123456789", "1313 Mockingbird Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", "John", "Doe", null, "1313 Mockingbird Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", "John", "Doe", "0123456789", null);
		});
	}
	
	@Test
	@DisplayName("Error on string longer than max")
	void testContactMaxLength() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("01234567890", "John", "Doe", "0123456789", "1313 Mockingbird Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", "01234567890", "Doe", "0123456789", "1313 Mockingbird Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", "John", "01234567890", "0123456789", "1313 Mockingbird Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", "John", "Doe", "01234567890", "1313 Mockingbird Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", "John", "Doe", "0123456789", "01234567890012345678901234567890123");
		});
	}
	
	@Test
	@DisplayName("Error on invalid phone number")
	void testPhone() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", "John", "Doe", "12345", "1313 Mockingbird Lane");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567890", "John", "Doe", "12345678901", "1313 Mockingbird Lane");
		});
		
	}
	
	@Test
	@DisplayName("Verify contact setter methods")
	void testSetters() {
		String contactID = "1234567890";
		String firstName = "John";
		String lastName = "Doe";
		String phone = "0123456789";
		String address = "1313 Mockingbird Lane";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phone, address);
		
		testContact.setFirstName("Changed");
		assertEquals(testContact.getFirstName(), "Changed");
		testContact.setLastName("Changed");
		assertEquals(testContact.getLastName(), "Changed");
		testContact.setPhone("9876543210");
		assertEquals(testContact.getPhone(), "9876543210");
		testContact.setAddress("Changed");
		assertEquals(testContact.getAddress(), "Changed");
		
	}
}
