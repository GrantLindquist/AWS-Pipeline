package com.gcu.buisness;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService 
{
	public boolean authenticate(String username, String password)
	{
		System.out.println(String.format("Hello from SecurityBusinessService with a username of %s and a password of %s", username, password));
		
		return true;
	}
}
