/*
 * Jeffrey McGinty
 * jeffrey.mcginty@snhu.edu
 * CS-320 Module 3
 * March 15, 2023
 */

package ContactService;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	
	// Create a list to hold contact objects
	public static List<Contact> contacts = new ArrayList<Contact>();
	
	public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		
		// If list is not empty check for duplicate ID
		if (!contacts.isEmpty()) {
			for (Contact item : contacts) {
				if (item.getContactID() == contactID) {
					throw new IllegalArgumentException("Duplicate Contact ID");
				}
			}
		}
		
		// Continue if no error thrown
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		contacts.add(newContact);
		
	}
	
	public void deleteContact(String contactID) {
		
		if (contacts.isEmpty()) {
			throw new IllegalArgumentException("List is empty");
		}
		
		// Seek and destroy
		for(int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getContactID() == contactID) {
				contacts.remove(i);
				return;
			}
		}
		// Contact ID not found
		throw new IllegalArgumentException("Contact ID does not exist");	
	}
	
	public void updateFirstName(String contactID, String firstName) {
		
		for (Contact item : contacts) {
			if (item.getContactID() == contactID) {
				item.setFirstName(firstName);
			}
		}
	}
	
	public void updateLastName(String contactID, String lastName) {
		
		for (Contact item : contacts) {
			if (item.getContactID() == contactID) {
				item.setLastName(lastName);
			}
		}
	}
	
public void updatePhone(String contactID, String phone) {
		
		for (Contact item : contacts) {
			if (item.getContactID() == contactID) {
				item.setPhone(phone);
			}
		}
	}
	
public void updateAddress(String contactID, String address) {
	
	for (Contact item : contacts) {
		if (item.getContactID() == contactID) {
			item.setAddress(address);
		}
	}
}
	
}
