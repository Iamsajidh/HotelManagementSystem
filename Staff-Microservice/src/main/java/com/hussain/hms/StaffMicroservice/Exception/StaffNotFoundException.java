package com.hussain.hms.StaffMicroservice.Exception;

public class StaffNotFoundException extends RuntimeException 
{
	
	public StaffNotFoundException(String message)
	{
		super(message);
	}

}
