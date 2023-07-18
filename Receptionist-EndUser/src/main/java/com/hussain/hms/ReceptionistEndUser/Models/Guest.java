package com.hussain.hms.ReceptionistEndUser.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Guest")
public class Guest {

	@Id
	private int guestId;
	
	@NotEmpty(message = "Guest name must not be empty.")
	private String guestName;
	
	@NotNull(message = "Guest contact must not be null.")
	private long guestContact;
	
	@Email(message = "Invalid email format.")
	private String guestEmail;
	
	@Pattern(regexp = "^(Male|Female|Other)$", message = "Guest gender must be Male, Female, or Other.")
	private String guestGender;
	
	@Size(min = 5, max = 100, message = "Guest address must be between 5 and 100 characters.")
	private String guestAddress;

	public Guest() {

	}

	public Guest(int guestId, String guestName, long guestContact, String guestEmail, String guestGender,
			String guestAddress) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestContact = guestContact;
		this.guestEmail = guestEmail;
		this.guestGender = guestGender;
		this.guestAddress = guestAddress;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public long getGuestContact() {
		return guestContact;
	}

	public void setGuestContact(long guestContact) {
		this.guestContact = guestContact;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public String getGuestGender() {
		return guestGender;
	}

	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}

	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", guestName=" + guestName + ", guestContact=" + guestContact
				+ ", guestEmail=" + guestEmail + ", guestGender=" + guestGender + ", guestAddress=" + guestAddress
				+ "]";
	}
}
