/*
 * Jeffrey McGinty
 * jeffrey.mcginty@snhu.edu
 * CS-320 Module 3
 * March 15, 2023
 */

package ContactService;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		
		// Check that all parameters are not null and meet length restrictions
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID is not valid");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First Name is not valid");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name is not valid");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Phone number is not valid");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address is invalid");
		}
		
		// Set object parameters with validated input
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Contact parameter getter methods
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	// Contact parameter setter methods
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name is invalid");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name is invalid");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Phone number is invalid");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address is invalid");
		}
		this.address = address;
	}
	
}
